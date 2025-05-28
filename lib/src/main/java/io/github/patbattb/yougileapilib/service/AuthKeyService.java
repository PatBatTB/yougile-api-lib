package io.github.patbattb.yougileapilib.service;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import io.github.patbattb.yougileapilib.domain.AuthKey;
import io.github.patbattb.yougileapilib.http.YouGileResponseHandler;
import org.apache.http.HttpStatus;
import org.apache.http.client.fluent.Content;
import org.apache.http.client.fluent.Response;

import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;
import java.util.Map;

public class AuthKeyService extends AbstractRequestService {

    public AuthKeyService() {
        super("auth/keys");
    }

    public AuthKey createAuthKey(String login, String password, String companyId) throws URISyntaxException, IOException {
        Map<String, Object> bodyMap = Map.of(
                "login", login,
                "password", password,
                "companyId", companyId
        );
        Response response = sendPostRequest(bodyMap, configureURI().build());
        Content content = response.handleResponse(YouGileResponseHandler::getJsonCreatedHandler);
        return handleContent(content);

    }

    public boolean deleteAuthKey(AuthKey authKey) throws URISyntaxException, IOException {
        String basePath = configureURI().getPath();
        URI uri = configureURI().setPath(String.join("/", basePath, authKey.key())).build();
        Response response = sendDeleteRequest(uri);
        Content content = response.handleResponse(YouGileResponseHandler::getJsonOKHandler);
        return response.returnResponse().getStatusLine().getStatusCode() == HttpStatus.SC_OK;
    }

    private AuthKey handleContent(Content content) throws JsonProcessingException {
        return new ObjectMapper().readValue(content.toString(), AuthKey.class);
    }

}
