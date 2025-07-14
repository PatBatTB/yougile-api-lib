package io.github.patbattb.yougileapilib.service;

import io.github.patbattb.yougileapilib.domain.*;
import io.github.patbattb.yougileapilib.domain.body.GroupChatCreateBody;
import io.github.patbattb.yougileapilib.domain.body.GroupChatUpdateBody;
import io.github.patbattb.yougileapilib.http.ResponseHandlerProvider;
import lombok.NonNull;
import org.apache.http.client.fluent.Content;
import org.apache.http.client.fluent.Response;

import java.io.IOException;
import java.net.URISyntaxException;

/**
 * Service for managing of group chats.
 * <p>
 * <b>ATTENTION! GroupChat doesn't work correctly!
 * <p>
 * If you delete all users from the chat, it will get bogged down.
 * You can get it through the API, but if you try to change it, add users, or something else, there will be no result.
 * The server returns the 200 status (OK), but no changes occur.
 * <p>
 * There may be other errors that I have not been able to identify as a result of the tests.
 * </b>
 */
public class GroupChatService extends AbstractRequestService {

    /**
     * If the service constructs without {@link AuthKey}, key must be passed to each method as argument.
     */
    public GroupChatService() {
        this(null);
    }

    /**
     * If the service constructs with {@link AuthKey}, you can use methods without key in parameters.
     * The passed key in constructor will be used by default.
     * If you want to send request with separate key, but without new service creating,
     * you can also use methods with {@link AuthKey} in parameters.
     * @param authKey yougile key for using by default in the Service instance.
     */
    public GroupChatService(AuthKey authKey) {
        super("group-chats", authKey);
    }

    /**
     * The request gets container with {@link GroupChat} list.
     * @param params {@link QueryParams} Request parameters<p>
     *                                  Available parameter names:<ul>
     *                                  <li>{@code includeDeleted} ({@code boolean}) - By default,
     *                                     if an object has been marked as deleted, it will not be found.
     *                                     Set true so that deleted objects are returned.
     *                                  <li>{@code limit} ({@code number}) - The number of items you want to receive. Maximum 1000.
     *                                  <li>{@code offset} ({@code number}) - The index of the first element.
     *                                  <li>{@code title} ({@code String}) - Group chat title.
     *                                  </ul>
     * @param authKey yougile key.
     * @return container with {@link GroupChat} list.
     * @throws IOException then the json cannot be parsed correctly.
     */
    public PagingContainer<GroupChat> getGroupChatList(@NonNull QueryParams params, @NonNull AuthKey authKey) throws URISyntaxException, IOException {
        Response response = sendGetRequest(configureURI(params).build(), authKey);
        Content content = response.handleResponse(ResponseHandlerProvider::okJsonHandler);
        return ContentHandler.handlePagingContent(content, GroupChat.class);
    }

    /**
     * The request gets container with {@link GroupChat} list.
     * The passed key in constructor will be used by default.
     * @param params {@link QueryParams} Request parameters<p>
     *               Available parameter names:<ul>
     *               <li>{@code includeDeleted} ({@code boolean}) - By default,
     *               if an object has been marked as deleted, it will not be found.
     *               Set true so that deleted objects are returned.
     *               <li>{@code limit} ({@code number}) - The number of items you want to receive. Maximum 1000.
     *               <li>{@code offset} ({@code number}) - The index of the first element.
     *               <li>{@code title} ({@code String}) - Group chat title.
     *               </ul>
     * @return container with {@link GroupChat} list.
     * @throws IOException then the json cannot be parsed correctly.
     */
    public PagingContainer<GroupChat> getGroupChatList(@NonNull QueryParams params) throws URISyntaxException, IOException {
        if (authKey == null) {
            throw new NullPointerException(noAuthKeyMessage);
        }
        return getGroupChatList(params, authKey);
    }

    /**
     * The request creates new group chat.
     * @param body body with parameters to create new chat.
     * @param authKey yougile key.
     * @return ID of the created group chat.
     * @throws IOException then the json cannot be parsed correctly.
     */
    public Id createGroupChat(@NonNull GroupChatCreateBody body, @NonNull AuthKey authKey) throws URISyntaxException, IOException {
        Response response = sendPostRequest(configureURI().build(), body, authKey);
        Content content = response.handleResponse(ResponseHandlerProvider::createdJsonHandler);
        return ContentHandler.handleEntity(content, Id.class);
    }

    /**
     * The request creates new group chat.
     * The passed key in constructor will be used by default.
     * @param body body with parameters to create new chat.
     * @return ID of the created group chat.
     * @throws IOException then the json cannot be parsed correctly.
     */
    public Id createGroupChat(@NonNull GroupChatCreateBody body) throws URISyntaxException, IOException {
        if (authKey == null) {
            throw new NullPointerException(noAuthKeyMessage);
        }
        return createGroupChat(body, authKey);
    }

    /**
     * The request gets {@link GroupChat} by ID.
     * @param chatId ID of the chat.
     * @param authKey yougile key.
     * @return group chat, if it's available.
     * @throws IOException then the json cannot be parsed correctly.
     */
    public GroupChat getGroupChatById(@NonNull String chatId, @NonNull AuthKey authKey) throws URISyntaxException, IOException {
        Response response = sendGetRequest(configureURI(chatId).build(), authKey);
        Content content = response.handleResponse(ResponseHandlerProvider::okJsonHandler);
        return ContentHandler.handleEntity(content, GroupChat.class);
    }

    /**
     * The request gets {@link GroupChat} by ID.
     * The passed key in constructor will be used by default.
     * @param chatId ID of the chat.
     * @return group chat, if it's available.
     * @throws IOException then the json cannot be parsed correctly.
     */
    public GroupChat getGroupChatById(@NonNull String chatId) throws URISyntaxException, IOException {
        if (authKey == null) {
            throw new NullPointerException(noAuthKeyMessage);
        }
        return getGroupChatById(chatId, authKey);
    }

    /**
     * The request updates group chat.
     * @param chatId ID of the group chat.
     * @param body body with parameters to update.
     * @param authKey yougile key.
     * @return ID of the updated chat.
     * @throws IOException then the json cannot be parsed correctly.
     */
    public Id updateGroupChat(@NonNull String chatId, @NonNull GroupChatUpdateBody body, @NonNull AuthKey authKey) throws URISyntaxException, IOException {
        Response response = sendPutRequest(configureURI(chatId).build(), body, authKey);
        Content content = response.handleResponse(ResponseHandlerProvider::okJsonHandler);
        return ContentHandler.handleEntity(content, Id.class);
    }

    /**
     * The request updates group chat.
     * The passed key in constructor will be used by default.
     * @param chatId ID of the group chat.
     * @param body   body with parameters to update.
     * @return ID of the updated chat.
     * @throws IOException then the json cannot be parsed correctly.
     */
    public Id updateGroupChat(@NonNull String chatId, @NonNull GroupChatUpdateBody body) throws URISyntaxException, IOException {
        if (authKey == null) {
            throw new NullPointerException(noAuthKeyMessage);
        }
        return updateGroupChat(chatId, body, authKey);
    }

    /**
     * The request updates group chat by passed {@link GroupChat}.
     * @param groupChat group chat to update.
     * @param authKey yougile key.
     * @return ID of the update chat.
     * @throws IOException then the json cannot be parsed correctly.
     */
    public Id updateGroupChat (@NonNull GroupChat groupChat, @NonNull AuthKey authKey) throws URISyntaxException, IOException {
        GroupChatUpdateBody body = GroupChatUpdateBody.builder()
                .deleted(groupChat.isDeleted())
                .title(groupChat.getTitle())
                .users(groupChat.getUsers().toArray(GroupChatUser[]::new))
                .build();
        return updateGroupChat(groupChat.getId(), body, authKey);
    }

    /**
     * The request updates group chat by passed {@link GroupChat}.
     * The passed key in constructor will be used by default.
     * @param groupChat group chat to update.
     * @return ID of the update chat.
     * @throws IOException then the json cannot be parsed correctly.
     */
    public Id updateGroupChat (@NonNull GroupChat groupChat) throws URISyntaxException, IOException {
        if (authKey == null) {
            throw new NullPointerException(noAuthKeyMessage);
        }
        return updateGroupChat(groupChat, authKey);
    }

}
