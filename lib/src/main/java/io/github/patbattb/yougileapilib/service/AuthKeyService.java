package io.github.patbattb.yougileapilib.service;

import io.github.patbattb.yougileapilib.domain.AuthKey;
import io.github.patbattb.yougileapilib.domain.body.AuthKeyBody;
import io.github.patbattb.yougileapilib.http.ResponseHandlerProvider;
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
        Content content = response.handleResponse(ResponseHandlerProvider::createdJsonHandler);
        return ContentHandler.handleAuthKey(content);
    }

    public boolean deleteAuthKey(@NonNull AuthKey authKey) throws URISyntaxException, IOException {
        Response response = sendDeleteRequest(configureURI(authKey.key()).build());
        Content content = response.handleResponse(ResponseHandlerProvider::okJsonHandler);
        return ContentHandler.handleResult(content);
    }
}
