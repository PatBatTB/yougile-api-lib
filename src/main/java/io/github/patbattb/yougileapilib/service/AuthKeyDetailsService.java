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

/**
 * Service for managing of keys in the authorization section.
 */
//TODO need to transfer to the AuthKeyService
public class AuthKeyDetailsService extends AbstractRequestService {

    public AuthKeyDetailsService() {
        super("auth/keys/get");
    }

    /**
     * The request gets {@link AuthKeyDetails} list.
     * @param body Request body.
     * @return {@link List} of the {@link AuthKeyDetails}
     * @throws IOException then the json cannot be parsed correctly
     */
    public List<AuthKeyDetails> getAuthKeyList(@NonNull AuthKeyBody body) throws URISyntaxException, IOException {
        Response response = sendPostRequest(configureURI().build(), body);
        Content content = response.handleResponse(ResponseHandlerProvider::okJsonHandler);
        return ContentHandler.handleAuthKeyList(content);
    }

}
