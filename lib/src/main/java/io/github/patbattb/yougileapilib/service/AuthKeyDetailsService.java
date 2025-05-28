package io.github.patbattb.yougileapilib.service;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.node.ArrayNode;
import io.github.patbattb.yougileapilib.domain.AuthKeyDetails;
import io.github.patbattb.yougileapilib.http.YouGileResponseHandler;
import org.apache.http.client.fluent.Content;
import org.apache.http.client.fluent.Response;

import java.io.IOException;
import java.net.URISyntaxException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class AuthKeyDetailsService extends AbstractRequestService {

    public AuthKeyDetailsService() {
        super("auth/keys/get");
    }

    public List<AuthKeyDetails> getAuthKeyList(String login, String password, String companyId) throws URISyntaxException, IOException {
        Map<String, Object> bodyMap = Map.of(
                "login", login,
                "password", password,
                "companyId", companyId
        );
        Response response = sendPostRequest(bodyMap, configureURI().build());
        Content content = response.handleResponse(YouGileResponseHandler::getJsonOKHandler);
        return handleContent(content);
    }

    private List<AuthKeyDetails> handleContent(Content content) throws JsonProcessingException {
        ObjectMapper mapper = new ObjectMapper();
        ArrayNode arrayNode = (ArrayNode) mapper.readTree(content.toString());
        List<AuthKeyDetails> authKeyDetailsList = new ArrayList<>();
        for (JsonNode node: arrayNode) {
            authKeyDetailsList.add(mapper.readValue(node.toString(), AuthKeyDetails.class));
        }
        return authKeyDetailsList;
    }

}
