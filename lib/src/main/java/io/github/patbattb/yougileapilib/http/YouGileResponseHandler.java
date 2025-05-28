package io.github.patbattb.yougileapilib.http;

import lombok.experimental.UtilityClass;
import org.apache.http.HttpResponse;
import org.apache.http.HttpStatus;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.fluent.Content;
import org.apache.http.entity.ContentType;

import java.io.IOException;

@UtilityClass
public class YouGileResponseHandler {

    public Content getJsonOKHandler(HttpResponse response) throws IOException {
        ContentType contentType = ContentType.APPLICATION_JSON;
        checkStatusCode(response, HttpStatus.SC_OK);
        checkContainedEntity(response);
        checkContentType(response, contentType);
        return new Content(response.getEntity().getContent().readAllBytes(), contentType);
    }

    public Content getJsonCreatedHandler(HttpResponse response) throws IOException {
        ContentType contentType = ContentType.APPLICATION_JSON;
        checkStatusCode(response, HttpStatus.SC_CREATED);
        checkContainedEntity(response);
        checkContentType(response, contentType);
        return  new Content(response.getEntity().getContent().readAllBytes(), contentType);
    }

    private void checkStatusCode(HttpResponse response, int status) throws ClientProtocolException {
        int responseStatusCode = response.getStatusLine().getStatusCode();
        if (responseStatusCode != status) {
            String phrase = response.getStatusLine().getReasonPhrase();
            throw new ClientProtocolException(String.format("Error %d %s", responseStatusCode, phrase));
        }
    }
    private void checkContainedEntity(HttpResponse response) throws IOException {
        if ((response.getEntity() == null || response.getEntity().getContent() == null)) {
            String message = "Response doesn't have content";
            throw new ClientProtocolException(message);
        }
    }
    private void checkContentType(HttpResponse response, ContentType contentType) throws ClientProtocolException {
        if (!(ContentType.get(response.getEntity()).getMimeType().equals(contentType.getMimeType()))) {
            throw new ClientProtocolException("Response content type is not equals \"application/json\"");
        }
    }
}
