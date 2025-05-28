package io.github.patbattb.yougileapilib.service;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.node.ArrayNode;
import io.github.patbattb.yougileapilib.domain.AuthCompany;
import io.github.patbattb.yougileapilib.http.YouGileResponseHandler;
import org.apache.http.client.fluent.Content;
import org.apache.http.client.fluent.Response;

import java.io.IOException;
import java.net.URISyntaxException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;


public class AuthCompanyService extends AbstractRequestService{

    public AuthCompanyService() {
        super("auth/companies");
    }

    //default number = 50
    public List<AuthCompany> getAuthCompanyList(String login, String password) throws URISyntaxException, IOException {
        Map<String, Object> bodyMap = Map.of(
                "login", login,
                "password", password
        );
        Response response = sendPostRequest(bodyMap, configureURI().build());
        Content content = response.handleResponse(YouGileResponseHandler::getJsonOKHandler);
        return handleContent(content);
    }

    public List<AuthCompany> getAuthCompanyList(String login, String password, int limit) throws URISyntaxException, IOException {
        Map<String, Object> bodyMap = Map.of(
                "login", login,
                "password", password
        );
        Response response = sendPostRequest(
                bodyMap,
                configureURI().addParameter("limit", String.valueOf(limit)).build());
        Content content = response.handleResponse(YouGileResponseHandler::getJsonOKHandler);
        return handleContent(content);
    }

    public AuthCompany getCompanyInfo(String login, String password, String companyName) throws URISyntaxException, IOException {
        Map<String, Object> bodyMap = Map.of(
                "login", login,
                "password", password,
                "name", companyName
        );
        Response response = sendPostRequest(bodyMap, configureURI().build());
        Content content = response.handleResponse(YouGileResponseHandler::getJsonOKHandler);
        return handleContent(content).getFirst();
    }

    private List<AuthCompany> handleContent(Content content) {
        try {
            ObjectMapper mapper = new ObjectMapper();
            List<AuthCompany> authCompanyList = new ArrayList<>();
            JsonNode rootNode = mapper.readTree(content.asString());
            ArrayNode contentArrayNode = (ArrayNode) rootNode.get("content");
            for (JsonNode contentNode: contentArrayNode) {
                authCompanyList.add(mapper.readValue(contentNode.toString(), AuthCompany.class));
            }
            return authCompanyList;
        } catch (JsonProcessingException e) {
            throw new RuntimeException(e);
        }
    }
}
