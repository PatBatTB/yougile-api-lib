package io.github.patbattb.yougileapilib.http;

import io.github.patbattb.yougileapilib.http.deserialize.AbstractDeserializerTest;
import org.apache.http.*;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.fluent.Content;
import org.apache.http.entity.ContentType;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.io.InputStream;
import java.nio.charset.StandardCharsets;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

class ResponseHandlerProviderTest extends AbstractDeserializerTest {

    private HttpResponse response;
    private ContentType contentType;
    private HttpEntity entity;
    private InputStream stream;
    private StatusLine statusLine;
    private int statusCode;
    private Content validContent;
    private byte[] byteArray;
    private NameValuePair valuePair;
    private HeaderElement element;
    private Header header;


    @BeforeEach
    void setUp() throws IOException {
        response = mock(HttpResponse.class);
        contentType = ContentType.APPLICATION_JSON;
        entity = mock(HttpEntity.class);
        stream = mock(InputStream.class);
        statusLine = mock(StatusLine.class);
        byteArray = new byte[] {};
        validContent = new Content(byteArray, contentType);

        valuePair = mock(NameValuePair.class);
        element = mock(HeaderElement.class);
        header = mock(Header.class);

        when(valuePair.getName()).thenReturn("charset");
        when(valuePair.getValue()).thenReturn("utf-8");

        when(element.getName()).thenReturn("application/json");
        when(element.getParameters()).thenReturn(new NameValuePair[] {valuePair});

        when(header.getElements()).thenReturn(new HeaderElement[] {element});
        when(header.getName()).thenReturn("Content-Type");
        when(header.getValue()).thenReturn("application/json; charset=utf-8");

        when(stream.readAllBytes()).thenReturn(byteArray);

        when(entity.getContent()).thenReturn(stream);
        when(entity.getContentType()).thenReturn(header);

        when(response.getStatusLine()).thenReturn(statusLine);
        when(response.getEntity()).thenReturn(entity);

    }

    @Test
    @DisplayName("okJsonHandler handle with correct data")
    void okJsonHandler() throws IOException {
        statusCode = 200;
        when(statusLine.getStatusCode()).thenReturn(statusCode);

        Content content = ResponseHandlerProvider.okJsonHandler(response);
        assertThat(content.asString()).isEqualTo(validContent.asString());
        assertThat(content.getType()).isEqualTo(validContent.getType());
    }

    @Test
    @DisplayName("Response doesn't have entity")
    void responseWithoutEntity() {
        when(response.getEntity()).thenReturn(null);
        assertThatThrownBy(() -> ResponseHandlerProvider.okJsonHandler(response)).isInstanceOf(ClientProtocolException.class);
    }

    @Test
    @DisplayName("Response doesn't have content")
    void responseWithoutContent() throws IOException {
        when(response.getEntity()).thenReturn(entity);
        when(entity.getContent()).thenReturn(null);
        assertThatThrownBy(() -> ResponseHandlerProvider.okJsonHandler(response)).isInstanceOf(ClientProtocolException.class);
    }

    @Test
    @DisplayName("Response has different mime-type then application/json")
    void responseNoJson() {
        when(response.getEntity()).thenReturn(entity);
        when(element.getName()).thenReturn("text/plain");
        assertThatThrownBy(() -> ResponseHandlerProvider.okJsonHandler(response)).isInstanceOf(ClientProtocolException.class);
    }

    @Test
    @DisplayName("okJsonHandler() with response contained different status code than 200")
    void handleOkJsonWithCodeDifferentThan200() throws IOException {
        int errorCode = 404;
        String errorMessage = "errorMessageText";
        String reasonPhrase = "reasonPhraseText";

        String errorJsonString = String.format("{\"message\": \"%s\"}", errorMessage);

        when(statusLine.getStatusCode()).thenReturn(errorCode);
        when(statusLine.getReasonPhrase()).thenReturn(reasonPhrase);
        when(stream.readAllBytes()).thenReturn(errorJsonString.getBytes(StandardCharsets.UTF_8));
        assertThatThrownBy(() -> ResponseHandlerProvider.okJsonHandler(response))
                .isInstanceOf(ClientProtocolException.class)
                .hasMessageContainingAll(errorMessage, reasonPhrase);
    }

    @Test
    @DisplayName("Error status code exception contains a few messages")
    void responseWithErrorCodeAndAFewMessages() throws IOException {
        int errorCode = 404;
        String errorMessageOne = "errorMessageTextOne";
        String errorMessageTwo = "errorMessageTextTwo";
        String errorJsonString = String.format("{\"message\": [\"%s\", \"%s\"]}", errorMessageOne, errorMessageTwo);
        when(statusLine.getStatusCode()).thenReturn(errorCode);
        when(stream.readAllBytes()).thenReturn(errorJsonString.getBytes(StandardCharsets.UTF_8));
        assertThatThrownBy(() -> ResponseHandlerProvider.okJsonHandler(response))
                .hasMessageContainingAll(errorMessageOne, errorMessageTwo);
    }

    @Test
    @DisplayName("createdJsonHandler() handle with correct data")
    void createdJsonHandler() throws IOException {
        statusCode = 201;
        when(statusLine.getStatusCode()).thenReturn(statusCode);
        Content content = ResponseHandlerProvider.createdJsonHandler(response);
        assertThat(content.getType()).isEqualTo(validContent.getType());
        assertThat(content.asString()).isEqualTo(validContent.asString());
    }

}