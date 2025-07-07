package io.github.patbattb.yougileapilib.service;

import io.github.patbattb.yougileapilib.domain.AuthKey;
import io.github.patbattb.yougileapilib.domain.body.AuthKeyBody;
import io.github.patbattb.yougileapilib.http.ResponseHandlerProvider;
import lombok.NonNull;
import org.apache.http.client.fluent.Content;
import org.apache.http.client.fluent.Response;

import java.io.IOException;
import java.net.URISyntaxException;

/**
 * Service for managing of keys in the authorization section.
 */
public class AuthKeyService extends AbstractRequestService {

    public AuthKeyService() {
        super("auth/keys");
    }

    /**
     * Request creates new key for authorization.
     * @param body request body.
     * @return created key.
     * @throws IOException then the json cannot be parsed correctly
     */
    public AuthKey createAuthKey(@NonNull AuthKeyBody body) throws URISyntaxException, IOException {
        Response response = sendPostRequest(configureURI().build(), body);
        Content content = response.handleResponse(ResponseHandlerProvider::createdJsonHandler);
        return ContentHandler.handleAuthKey(content);
    }

    /**
     * Request deletes the key.
     * @param authKey the key for deleting.
     * @return true, if key has been deleted.
     * @throws IOException then the json cannot be parsed correctly
     */
    public boolean deleteAuthKey(@NonNull AuthKey authKey) throws URISyntaxException, IOException {
        Response response = sendDeleteRequest(configureURI(authKey.key()).build());
        Content content = response.handleResponse(ResponseHandlerProvider::okJsonHandler);
        return ContentHandler.handleResult(content);
    }
}
