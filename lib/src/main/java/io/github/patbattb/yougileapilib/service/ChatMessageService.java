package io.github.patbattb.yougileapilib.service;

import io.github.patbattb.yougileapilib.domain.*;
import io.github.patbattb.yougileapilib.domain.body.ChatMessageCreateBody;
import io.github.patbattb.yougileapilib.domain.body.ChatMessageUpdateBody;
import io.github.patbattb.yougileapilib.http.ResponseHandlerProvider;
import lombok.NonNull;
import org.apache.http.client.fluent.Content;
import org.apache.http.client.fluent.Response;

import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;

/**
 * Service for managing of chat messages.
 */
public class ChatMessageService extends AbstractRequestService {

    /**
     * If the service constructs without {@link AuthKey}, key must be passed to each method as argument.
     */
    public ChatMessageService() {
        this(null);
    }

    /**
     * If the service constructs with {@link AuthKey}, you can use methods without key in parameters.
     * The passed key in constructor will be used by default.
     * If you want to send request with separate key, but without new service creating,
     * you can also use methods with {@link AuthKey} in parameters.
     * @param authKey yougile key for using by default in the Service instance.
     */
    public ChatMessageService(AuthKey authKey) {
        super("chats", authKey);
    }

    /**
     * The request gets messages history of chat.
     * @param chatId ID of the chat.
     * @param params {@link QueryParams} Request parameters<p>
     *                                  Available parameter names:<ul>
     *                                  <li>{@code includeDeleted} ({@code boolean}) - By default,
     *                                  if an object has been marked as deleted, it will not be found.
     *                                  Set true so that deleted objects are returned.
     *                                  <li>{@code limit} ({@code number}) - The number of items you want to receive. Maximum 1000.
     *                                  <li>{@code offset} ({@code number}) - The index of the first element.
     *                                  <li>{@code fromUserId} ({@code string}) - ID of messages author.
     *                                  <li>{@code includeSystem} ({@code boolean}) - Whether to include system messages. They are not enabled by default.
     *                                  <li>{@code label} ({@code string}) - Quick Link search.
     *                                  <li>{@code since} ({@code long}) - Search among messages whose creation time is later than the specified time (timestamp).
     *                                  <li>{@code text} ({@code string}) - Search for substring.
     *                                  </ul>
     * @param authKey yougile key.
     * @return container with chat messages list.
     * @throws IOException then the json cannot be parsed correctly.
     */
    public PagingContainer<ChatMessage> getChatMessageHistory(@NonNull String chatId, @NonNull QueryParams params, @NonNull AuthKey authKey) throws URISyntaxException, IOException {
        URI uri = configureURI(params).setPathSegments(getPathSegments(chatId)).build();
        Response response = sendGetRequest(uri, authKey);
        Content content = response.handleResponse(ResponseHandlerProvider::okJsonHandler);
        return ContentHandler.handlePagingContent(content, ChatMessage.class);
    }

    /**
     * The request gets messages history of chat.
     * The passed key in constructor will be used by default.
     * @param chatId ID of the chat.
     * @param params {@link QueryParams} Request parameters<p>
     *               Available parameter names:<ul>
     *               <li>{@code includeDeleted} ({@code boolean}) - By default,
     *               if an object has been marked as deleted, it will not be found.
     *               Set true so that deleted objects are returned.
     *               <li>{@code limit} ({@code number}) - The number of items you want to receive. Maximum 1000.
     *               <li>{@code offset} ({@code number}) - The index of the first element.
     *               <li>{@code fromUserId} ({@code string}) - ID of messages author.
     *               <li>{@code includeSystem} ({@code boolean}) - Whether to include system messages. They are not enabled by default.
     *               <li>{@code label} ({@code string}) - Quick Link search.
     *               <li>{@code since} ({@code long}) - Search among messages whose creation time is later than the specified time (timestamp).
     *               <li>{@code text} ({@code string}) - Search for substring.
     *               </ul>
     * @return container with chat messages list.
     * @throws IOException then the json cannot be parsed correctly.
     */
    public PagingContainer<ChatMessage> getChatMessageHistory(@NonNull String chatId, @NonNull QueryParams params) throws URISyntaxException, IOException {
        if (authKey == null) {
            throw new NullPointerException(noAuthKeyMessage);
        }
        return getChatMessageHistory(chatId, params, authKey);
    }

    /**
     * The request sends message to the chat.
     * @param chatId ID of the chat.
     * @param body body with parameters for creating new message.
     * @param authKey yougile key.
     * @return ID of the sent message.
     * @throws IOException then the json cannot be parsed correctly.
     */
    public Id sendMessage(@NonNull String chatId, @NonNull  ChatMessageCreateBody body, @NonNull AuthKey authKey) throws URISyntaxException, IOException {
            URI uri = configureURI().setPathSegments(getPathSegments(chatId)).build();
            Response response = sendPostRequest(uri, body, authKey);
            Content content = response.handleResponse(ResponseHandlerProvider::createdJsonHandler);
            return ContentHandler.handleEntity(content, Id.class);
    }

    /**
     * The request sends message to the chat.
     * The passed key in constructor will be used by default.
     * @param chatId ID of the chat.
     * @param body   body with parameters for creating new message.
     * @return ID of the sent message.
     * @throws IOException then the json cannot be parsed correctly.
     */
    public Id sendMessage(@NonNull String chatId, @NonNull  ChatMessageCreateBody body) throws URISyntaxException, IOException {
        if (authKey == null) {
            throw new NullPointerException(noAuthKeyMessage);
        }
        return sendMessage(chatId, body, authKey);
    }

    /**
     * The request gets chat message by ID.
     * @param chatId ID of the chat.
     * @param messageId ID of the message.
     * @param authKey yougile key.
     * @return Chat message, if it's available.
     * @throws IOException then the json cannot be parsed correctly.
     */
    public ChatMessage getChatMessageById(@NonNull String chatId, @NonNull String messageId, @NonNull AuthKey authKey) throws URISyntaxException, IOException {
        URI uri = configureURI().setPathSegments(getPathSegments(chatId, messageId)).build();
        Response response = sendGetRequest(uri, authKey);
        Content content = response.handleResponse(ResponseHandlerProvider::okJsonHandler);
        return ContentHandler.handleEntity(content, ChatMessage.class);
    }

    /**
     * The request gets chat message by ID.
     * The passed key in constructor will be used by default.
     * @param chatId    ID of the chat.
     * @param messageId ID of the message.
     * @return Chat message, if it's available.
     * @throws IOException then the json cannot be parsed correctly.
     */
    public ChatMessage getChatMessageById(@NonNull String chatId, @NonNull String messageId) throws URISyntaxException, IOException {
        if (authKey == null) {
            throw new NullPointerException(noAuthKeyMessage);
        }
        return getChatMessageById(chatId, messageId, authKey);
    }

    /**
     * The request updates existing chat message by ID.
     * @param chatId ID of the chat.
     * @param messageId ID of the message.
     * @param body body with parameters to update.
     * @param authKey yougile key.
     * @return ID of the updated message.
     * @throws IOException then the json cannot be parsed correctly.
     */
    public Id updateChatMessage(@NonNull String chatId, @NonNull String messageId, @NonNull ChatMessageUpdateBody body, @NonNull AuthKey authKey) throws URISyntaxException, IOException {
        URI uri = configureURI().setPathSegments(getPathSegments(chatId, messageId)).build();
        Response response = sendPutRequest(uri, body, authKey);
        Content content = response.handleResponse(ResponseHandlerProvider::okJsonHandler);
        return ContentHandler.handleEntity(content, Id.class);
    }

    /**
     * The request updates existing chat message by ID.
     * The passed key in constructor will be used by default.
     * @param chatId    ID of the chat.
     * @param messageId ID of the message.
     * @param body      body with parameters to update.
     * @return ID of the updated message.
     * @throws IOException then the json cannot be parsed correctly.
     */
    public Id updateChatMessage(@NonNull String chatId, @NonNull String messageId, @NonNull ChatMessageUpdateBody body) throws URISyntaxException, IOException {
        if (authKey == null) {
            throw new NullPointerException(noAuthKeyMessage);
        }
        return updateChatMessage(chatId, messageId, body, authKey);
    }

    /**
     * The request updates existing chat message by passed {@link ChatMessage}.
     * @param chatId  ID of the chat.
     * @param message chat message to update.
     * @param authKey yougile key.
     * @return ID of the updated message.
     * @throws IOException then the json cannot be parsed correctly.
     */
    public Id updateChatMessage(@NonNull String chatId, @NonNull ChatMessage message, @NonNull AuthKey authKey) throws URISyntaxException, IOException {
        ChatMessageUpdateBody body = ChatMessageUpdateBody.builder()
                .label(message.getLabel())
                .deleted(message.isDeleted())
                .build();
        return updateChatMessage(chatId, message.getId(), body, authKey);
    }

    /**
     * The request updates existing chat message by passed {@link ChatMessage}.
     * The passed key in constructor will be used by default.
     * @param chatId  ID of the chat.
     * @param message chat message to update.
     * @return ID of the updated message.
     * @throws IOException then the json cannot be parsed correctly.
     */
    public Id updateChatMessage(@NonNull String chatId, @NonNull ChatMessage message) throws URISyntaxException, IOException {
        if (authKey == null) {
            throw new NullPointerException(noAuthKeyMessage);
        }
        return updateChatMessage(chatId, message, authKey);
    }

    private String[] getPathSegments(String chatId) {
        return new String[] {apiPath, endpoint, chatId, "messages"};
    }

    private String[] getPathSegments(String chatId, String messageId) {
        return new String[] {apiPath, endpoint, chatId, "messages", messageId};
    }
}
