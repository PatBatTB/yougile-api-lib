package io.github.patbattb.yougileapilib.http;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.json.JsonMapper;
import com.fasterxml.jackson.databind.node.ArrayNode;
import lombok.experimental.UtilityClass;
import org.apache.http.HttpResponse;
import org.apache.http.HttpStatus;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.ResponseHandler;
import org.apache.http.client.fluent.Content;
import org.apache.http.entity.ContentType;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * Utility class with static methods for use in {@link org.apache.http.client.fluent.Response#handleResponse(ResponseHandler)}
 * as implementation of functional interface {@link ResponseHandler}
 */
@UtilityClass
public class ResponseHandlerProvider {

    /**
     * The handler execute necessary checks and returns response content.
     * The handler used for response with:
     * <ul>
     *     <li> 200 (OK) HTTP status code
     *     <li> JSON typed content
     * </ul>
     * @return content of the response.
     * @throws IOException then gets content doesn't successfully or content can't be reads
     */
    public Content okJsonHandler(HttpResponse response) throws IOException {
        ContentType contentType = ContentType.APPLICATION_JSON;
        checkContainedEntity(response);
        checkContentType(response, contentType);
        checkStatusCode(response, HttpStatus.SC_OK);
        return new Content(response.getEntity().getContent().readAllBytes(), contentType);
    }

    /**
     * The handler execute necessary checks and returns response content.
     * The handler used for response with:
     * <ul>
     *     <li> 201 (CREATED) HTTP status code
     *     <li> JSON typed content
     * </ul>
     * @return content of the response.
     * @throws IOException then gets content doesn't successfully or content can't be reads
     */
    public Content createdJsonHandler(HttpResponse response) throws IOException {
        ContentType contentType = ContentType.APPLICATION_JSON;
        checkContainedEntity(response);
        checkContentType(response, contentType);
        checkStatusCode(response, HttpStatus.SC_CREATED);
        return  new Content(response.getEntity().getContent().readAllBytes(), contentType);
    }

    private void checkStatusCode(HttpResponse response, int status) throws IOException {
        int responseStatusCode = response.getStatusLine().getStatusCode();
        if (responseStatusCode != status) {
            String phrase = response.getStatusLine().getReasonPhrase();
            String messageString = getMessage(response);
            throw new ClientProtocolException(String.format("Error %d %s: %s", responseStatusCode, phrase, messageString));
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

    private String getMessage(HttpResponse response) throws IOException {
        Content content = new Content(response.getEntity().getContent().readAllBytes(), ContentType.APPLICATION_JSON);
        JsonMapper mapper = new JsonMapper();
        JsonNode rootNode = mapper.readTree(content.asString());
        String messageString;
        JsonNode messageNode = rootNode.get("message");
        if (messageNode instanceof ArrayNode) {
            List<String> messagesList = new ArrayList<>();
            for (JsonNode node: messageNode) {
                messagesList.add(node.asText());
            }
            messageString = String.join(", ", messagesList);
        } else {
            messageString = messageNode.asText();
        }
        return messageString;
    }
}
