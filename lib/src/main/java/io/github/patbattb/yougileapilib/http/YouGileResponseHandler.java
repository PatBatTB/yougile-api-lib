package io.github.patbattb.yougileapilib.http;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.json.JsonMapper;
import com.fasterxml.jackson.databind.node.ArrayNode;
import lombok.experimental.UtilityClass;
import org.apache.http.HttpResponse;
import org.apache.http.HttpStatus;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.fluent.Content;
import org.apache.http.entity.ContentType;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@UtilityClass
public class YouGileResponseHandler {

    public Content getJsonOKHandler(HttpResponse response) throws IOException {
        ContentType contentType = ContentType.APPLICATION_JSON;
        checkContainedEntity(response);
        checkContentType(response, contentType);
        checkStatusCode(response, HttpStatus.SC_OK);
        return new Content(response.getEntity().getContent().readAllBytes(), contentType);
    }

    public Content getJsonCreatedHandler(HttpResponse response) throws IOException {
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
        System.out.println(rootNode);
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
