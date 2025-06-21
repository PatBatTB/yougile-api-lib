package io.github.patbattb.yougileapilib.service;

import io.github.patbattb.yougileapilib.domain.*;
import io.github.patbattb.yougileapilib.domain.body.UserBody;
import io.github.patbattb.yougileapilib.domain.body.UserUpdateBody;
import io.github.patbattb.yougileapilib.http.ResponseHandlerProvider;
import lombok.NonNull;
import org.apache.http.client.fluent.Content;
import org.apache.http.client.fluent.Response;

import java.io.IOException;
import java.net.URISyntaxException;

public class UserService extends AbstractRequestService {

    public UserService(AuthKey authKey) {
        super("users", authKey);
    }

    public UserService() {
        this(null);
    }


    /**
     * @param authKey {@link AuthKey} with your YouGile token
     * @param params {@link QueryParams} Request parameters<p>
     *                                  Available parameter names:<ul>
     *                                  <li>{@code email} - string
     *                                  <li>{@code limit} - number
     *                                  <li>{@code offset} - number
     *                                  <li>{@code projectId} - string
     *                                  </ul>
     *
     * @return list of {@link User}
     * @throws URISyntaxException
     * @throws IOException
     */
    public PagingContainer<User> getUserList(@NonNull QueryParams params, @NonNull AuthKey authKey) throws URISyntaxException, IOException {
        Response response = sendGetRequest(configureURI(params).build(), authKey);
        Content content = response.handleResponse(ResponseHandlerProvider::okJsonHandler);
        return ContentHandler.handleUserList(content);
    }

    /**
     * @param params {@link QueryParams} Request parameters<p>
     *                                  Available parameter names:<ul>
     *                                  <li>{@code email} - string
     *                                  <li>{@code limit} - number
     *                                  <li>{@code offset} - number
     *                                  <li>{@code projectId} - string
     *                                  </ul>
     *
     * @return list of {@link User}
     * @throws URISyntaxException
     * @throws IOException
     */
    public PagingContainer<User> getUserList(@NonNull QueryParams params) throws URISyntaxException, IOException {
        if (this.authKey == null) {
            throw new NullPointerException(noAuthKeyMessage);
        }
        return getUserList(params, this.authKey);
    }

    public Id inviteToCompany(@NonNull UserBody body, @NonNull AuthKey authKey) throws URISyntaxException, IOException {
        Response response = sendPostRequest(configureURI().build(), body, authKey);
        Content content = response.handleResponse(ResponseHandlerProvider::createdJsonHandler);
        return ContentHandler.handleId(content);
    }

    public Id inviteToCompany(@NonNull UserBody body) throws URISyntaxException, IOException {
        if (this.authKey == null) {
            throw new NullPointerException(noAuthKeyMessage);
        }
        return inviteToCompany(body, authKey);
    }

    public User getUserById(@NonNull String userId, @NonNull AuthKey authKey) throws URISyntaxException, IOException {
        Response response = sendGetRequest(configureURI(userId).build(), authKey);
        Content content = response.handleResponse(ResponseHandlerProvider::okJsonHandler);
        return ContentHandler.handleUser(content);
    }

    public User getUserById(@NonNull String userId) throws URISyntaxException, IOException {
        if (this.authKey == null) {
            throw new NullPointerException(noAuthKeyMessage);
        }
        return getUserById(userId, authKey);
    }

    public Id updateUser(@NonNull String userId, @NonNull UserUpdateBody body, @NonNull  AuthKey authKey) throws URISyntaxException, IOException {
        Response response = sendPutRequest(configureURI(userId).build(), body, authKey);
        Content content = response.handleResponse(ResponseHandlerProvider::okJsonHandler);
        return ContentHandler.handleId(content);
    }

    public Id updateUser(@NonNull String userId, @NonNull UserUpdateBody body) throws URISyntaxException, IOException {
        if (this.authKey == null) {
            throw new NullPointerException(noAuthKeyMessage);
        }
        return updateUser(userId, body, authKey);
    }

    public Id updateUser(@NonNull User user, @NonNull AuthKey authKey) throws URISyntaxException, IOException {
        UserUpdateBody body = UserUpdateBody.builder(user.isAdmin())
                .build();
        return updateUser(user.getId(), body, authKey);
    }

    public Id updateUser(@NonNull User user) throws URISyntaxException, IOException {
        if (this.authKey == null) {
            throw new NullPointerException(noAuthKeyMessage);
        }
        return updateUser(user, authKey);
    }

    public Id deleteFromCompany(@NonNull String userId, @NonNull AuthKey authKey) throws URISyntaxException, IOException {
        Response response = sendDeleteRequest(configureURI(userId).build(), authKey);
        Content content = response.handleResponse(ResponseHandlerProvider::okJsonHandler);
        return ContentHandler.handleId(content);
    }

    public Id deleteFromCompany(@NonNull String userId) throws URISyntaxException, IOException {
        if (this.authKey == null) {
            throw new NullPointerException(noAuthKeyMessage);
        }
        return deleteFromCompany(userId, authKey);
    }
}
