package io.github.patbattb.yougileapilib.service;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.json.JsonMapper;
import io.github.patbattb.yougileapilib.domain.AuthKey;
import io.github.patbattb.yougileapilib.domain.body.AuthKeyBody;
import io.github.patbattb.yougileapilib.http.YouGileResponseHandler;
import lombok.NonNull;
import org.apache.http.client.fluent.Content;
import org.apache.http.client.fluent.Response;

import java.io.IOException;
import java.net.URISyntaxException;

public class AuthKeyService extends AbstractRequestService {

    public AuthKeyService() {
        super("auth/keys");
    }

    public AuthKey createAuthKey(@NonNull AuthKeyBody body) throws URISyntaxException, IOException {
        Response response = sendPostRequest(configureURI().build(), body);
        Content content = response.handleResponse(YouGileResponseHandler::getJsonCreatedHandler);
        return handleContent(content);

    }

    public boolean deleteAuthKey(@NonNull AuthKey authKey) throws URISyntaxException, IOException {
        Response response = sendDeleteRequest(configureURI(authKey.key()).build());
        Content content = response.handleResponse(YouGileResponseHandler::getJsonOKHandler);
        return handleDeleteContent(content);
    }

    private AuthKey handleContent(Content content) throws JsonProcessingException {
        return new JsonMapper().readValue(content.toString(), AuthKey.class);
    }

    private boolean handleDeleteContent(Content content) throws JsonProcessingException {
        String validString = "ok";
        JsonMapper mapper = new JsonMapper();
        JsonNode node = mapper.readTree(content.toString());
        return node.get("result").asText().equals(validString);
    }

}
