package io.github.patbattb.yougileapilib.service;

import io.github.patbattb.yougileapilib.domain.AuthKeyDetails;
import io.github.patbattb.yougileapilib.domain.body.AuthKeyBody;
import io.github.patbattb.yougileapilib.http.ResponseHandlerProvider;
import lombok.NonNull;
import org.apache.http.client.fluent.Content;
import org.apache.http.client.fluent.Response;

import java.io.IOException;
import java.net.URISyntaxException;
import java.util.List;

public class AuthKeyDetailsService extends AbstractRequestService {

    public AuthKeyDetailsService() {
        super("auth/keys/get");
    }

    public List<AuthKeyDetails> getAuthKeyList(@NonNull AuthKeyBody body) throws URISyntaxException, IOException {
        Response response = sendPostRequest(configureURI().build(), body);
        Content content = response.handleResponse(ResponseHandlerProvider::OKJsonHandler);
        return ContentHandler.handleAuthKeyList(content);
    }

}
