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

/**
 * The service to managing of users.
 */
public class UserService extends AbstractRequestService {

    /**
     * If the service constructs with {@link AuthKey}, you can use methods without key in parameters.
     * The passed key in constructor will be used by default.
     * If you want to send request with separate key, but without new service creating,
     * you can also use methods with {@link AuthKey} in parameters.
     * @param authKey yougile key for using by default in the Service instance.
     */
    public UserService(AuthKey authKey) {
        super("users", authKey);
    }

    /**
     * If the service constructs without {@link AuthKey}, key must be passed to each method as argument.
     */
    public UserService() {
        this(null);
    }


    /**
     * The request gets container with {@link User} list.
     * @param authKey {@link AuthKey} with your YouGile token
     * @param params {@link QueryParams} Request parameters<p>
     *                                  Available parameter names:<ul>
     *                                  <li>{@code email} ({@code String}) - user email.
     *                                  <li>{@code limit} ({@code number}) - The number of items you want to receive. Maximum 1000.
     *                                  <li>{@code offset} ({@code number}) - The index of the first element.
     *                                  <li>{@code projectId} ({@code String}) - project ID.
     *                                  </ul>
     *
     * @return list of {@link User}
     * @throws IOException then the json cannot be parsed correctly.
     */
    public PagingContainer<User> getUserList(@NonNull QueryParams params, @NonNull AuthKey authKey) throws URISyntaxException, IOException {
        Response response = sendGetRequest(configureURI(params).build(), authKey);
        Content content = response.handleResponse(ResponseHandlerProvider::okJsonHandler);
        return ContentHandler.handlePagingContent(content, User.class);
    }

    /**
     * The request gets container with {@link User} list.
     * The passed key in constructor will be used by default.
     * @param params {@link QueryParams} Request parameters<p>
     *                                  Available parameter names:<ul>
     *                                  <li>{@code email} ({@code String}) - user email.
     *                                  <li>{@code limit} ({@code number}) - The number of items you want to receive. Maximum 1000.
     *                                  <li>{@code offset} ({@code number}) - The index of the first element.
     *                                  <li>{@code projectId} ({@code String}) - project ID.
     *                                  </ul>
     *
     * @return list of {@link User}
     * @throws IOException then the json cannot be parsed correctly.
     */
    public PagingContainer<User> getUserList(@NonNull QueryParams params) throws URISyntaxException, IOException {
        if (this.authKey == null) {
            throw new NullPointerException(noAuthKeyMessage);
        }
        return getUserList(params, this.authKey);
    }

    /**
     * The request invites new user to the company.
     * If user hasn't registered on yougile, inviting will send to the user email.
     * @param body request body with necessary parameters.
     * @param authKey yougile key.
     * @return ID of the company to which the employee is invited
     * @throws IOException then the json cannot be parsed correctly.
     */
    public Id inviteToCompany(@NonNull UserBody body, @NonNull AuthKey authKey) throws URISyntaxException, IOException {
        Response response = sendPostRequest(configureURI().build(), body, authKey);
        Content content = response.handleResponse(ResponseHandlerProvider::createdJsonHandler);
        return ContentHandler.handleEntity(content, Id.class);
    }

    /**
     * The request invites new user to the company.
     * The passed key in constructor will be used by default.
     * If user hasn't registered on yougile, inviting will send to the user email.
     * @param body request body with necessary parameters.
     * @return ID of the company to which the employee is invited
     * @throws IOException then the json cannot be parsed correctly.
     */
    public Id inviteToCompany(@NonNull UserBody body) throws URISyntaxException, IOException {
        if (this.authKey == null) {
            throw new NullPointerException(noAuthKeyMessage);
        }
        return inviteToCompany(body, authKey);
    }

    /**
     * The request gets {@link User} by ID.
     * @param userId ID of the user.
     * @param authKey yougile key.
     * @return The user, if it's available.
     * @throws IOException then the json cannot be parsed correctly.
     */
    public User getUserById(@NonNull String userId, @NonNull AuthKey authKey) throws URISyntaxException, IOException {
        Response response = sendGetRequest(configureURI(userId).build(), authKey);
        Content content = response.handleResponse(ResponseHandlerProvider::okJsonHandler);
        return ContentHandler.handleEntity(content, User.class);
    }

    /**
     * The request gets {@link User} by ID.
     * The passed key in constructor will be used by default.
     * @param userId ID of the user.
     * @return The user, if it's available.
     * @throws IOException then the json cannot be parsed correctly.
     */
    public User getUserById(@NonNull String userId) throws URISyntaxException, IOException {
        if (this.authKey == null) {
            throw new NullPointerException(noAuthKeyMessage);
        }
        return getUserById(userId, authKey);
    }

    /**
     * The request updates user.
     * @param userId ID of the user to update.
     * @param body body with parameters to update.
     * @param authKey yougile key.
     * @return ID of the updated user.
     * @throws IOException then the json cannot be parsed correctly.
     */
    public Id updateUser(@NonNull String userId, @NonNull UserUpdateBody body, @NonNull  AuthKey authKey) throws URISyntaxException, IOException {
        Response response = sendPutRequest(configureURI(userId).build(), body, authKey);
        Content content = response.handleResponse(ResponseHandlerProvider::okJsonHandler);
        return ContentHandler.handleEntity(content, Id.class);
    }

    /**
     * The request updates user.
     * The passed key in constructor will be used by default.
     * @param userId ID of the user to update.
     * @param body body with parameters to update.
     * @return ID of the updated user.
     * @throws IOException then the json cannot be parsed correctly.
     */
    public Id updateUser(@NonNull String userId, @NonNull UserUpdateBody body) throws URISyntaxException, IOException {
        if (this.authKey == null) {
            throw new NullPointerException(noAuthKeyMessage);
        }
        return updateUser(userId, body, authKey);
    }

    /**
     * The request updates user by passed instance of the {@link User}.
     * @param user user instance to update.
     * @param authKey yougile key.
     * @return ID of the updated user.
     * @throws IOException then the json cannot be parsed correctly.
     */
    public Id updateUser(@NonNull User user, @NonNull AuthKey authKey) throws URISyntaxException, IOException {
        UserUpdateBody body = UserUpdateBody.builder(user.isAdmin())
                .build();
        return updateUser(user.getId(), body, authKey);
    }

    /**
     * The request updates user by passed instance of the {@link User}.
     * The passed key in constructor will be used by default.
     * @param user user instance to update.
     * @return ID of the updated user.
     * @throws IOException then the json cannot be parsed correctly.
     */
    public Id updateUser(@NonNull User user) throws URISyntaxException, IOException {
        if (this.authKey == null) {
            throw new NullPointerException(noAuthKeyMessage);
        }
        return updateUser(user, authKey);
    }

    /**
     * The request deletes user from the current company.
     * The current company determines by passed authKey. Each key creates for specific company.
     * @param userId ID of the user to delete.
     * @param authKey yougile key.
     * @return ID of the deleted user.
     * @throws IOException then the json cannot be parsed correctly.
     */
    public Id deleteFromCompany(@NonNull String userId, @NonNull AuthKey authKey) throws URISyntaxException, IOException {
        Response response = sendDeleteRequest(configureURI(userId).build(), authKey);
        Content content = response.handleResponse(ResponseHandlerProvider::okJsonHandler);
        return ContentHandler.handleEntity(content, Id.class);
    }

    /**
     * The request deletes user from the current company.
     * The passed key in constructor will be used by default.
     * The current company determines by passed authKey. Each key creates for specific company.
     * @param userId ID of the user to delete.
     * @return ID of the deleted user.
     * @throws IOException then the json cannot be parsed correctly.
     */
    public Id deleteFromCompany(@NonNull String userId) throws URISyntaxException, IOException {
        if (this.authKey == null) {
            throw new NullPointerException(noAuthKeyMessage);
        }
        return deleteFromCompany(userId, authKey);
    }
}
