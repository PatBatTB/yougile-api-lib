package io.github.patbattb.yougileapilib.service;

import io.github.patbattb.yougileapilib.domain.*;
import io.github.patbattb.yougileapilib.domain.body.StringStickerCreateBody;
import io.github.patbattb.yougileapilib.domain.body.StringStickerStateCreateBody;
import io.github.patbattb.yougileapilib.domain.body.StringStickerStateUpdateBody;
import io.github.patbattb.yougileapilib.domain.body.StringStickerUpdateBody;
import io.github.patbattb.yougileapilib.http.ResponseHandlerProvider;
import lombok.NonNull;
import org.apache.http.client.fluent.Content;
import org.apache.http.client.fluent.Response;

import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;

/**
 * Service for managing of string-stickers.
 */
public class StringStickerService extends AbstractRequestService {

    /**
     * If the service constructs without {@link AuthKey}, key must be passed to each method as argument.
     */
    public StringStickerService() {
        this(null);
    }

    /**
     * If the service constructs with {@link AuthKey}, you can use methods without key in parameters.
     * The passed key in constructor will be used by default.
     * If you want to send request with separate key, but without new service creating,
     * you can also use methods with {@link AuthKey} in parameters.
     * @param authKey yougile key for using by default in the Service instance.
     */
    public StringStickerService(AuthKey authKey) {
        super("string-stickers", authKey);
    }

    /**
     * The request gets the container with {@link StringSticker} list.
     * @param params {@link QueryParams} Request parameters<p>
     *                                  Available parameter names:<ul>
     *                                  <li>{@code boardId} ({@code string}) - ID of the board.
     *                                  <li>{@code includeDeleted} ({@code boolean}) - By default,
     *                                   if an object has been marked as deleted, it will not be found.
     *                                   Set true so that deleted objects are returned.
     *                                  <li>{@code limit} ({@code number}) - The number of items you want to receive. Maximum 1000.
     *                                  <li>{@code offset} ({@code number}) - The index of the first element.
     *                                  <li>{@code name} ({@code string}) - Sticker name.
     *                                  </ul>
     * @param authKey yougile key.
     * @return container with {@link StringSticker} list.
     * @throws IOException then the json cannot be parsed correctly.
     */
    public PagingContainer<StringSticker> getStringStickerList(@NonNull QueryParams params, @NonNull AuthKey authKey) throws URISyntaxException, IOException {
        Response response = sendGetRequest(configureURI(params).build(), authKey);
        Content content = response.handleResponse(ResponseHandlerProvider::okJsonHandler);
        return ContentHandler.handlePagingContent(content, StringSticker.class);
    }

    /**
     * The request gets the container with {@link StringSticker} list.
     * The passed key in constructor will be used by default.
     * @param params {@link QueryParams} Request parameters<p>
     *                                  Available parameter names:<ul>
     *                                  <li>{@code boardId} ({@code string}) - ID of the board.
     *                                  <li>{@code includeDeleted} ({@code boolean}) - By default,
     *                                   if an object has been marked as deleted, it will not be found.
     *                                   Set true so that deleted objects are returned.
     *                                  <li>{@code limit} ({@code number}) - The number of items you want to receive. Maximum 1000.
     *                                  <li>{@code offset} ({@code number}) - The index of the first element.
     *                                  <li>{@code name} ({@code string}) - Sticker name.
     *                                  </ul>
     * @return container with {@link StringSticker} list.
     * @throws IOException then the json cannot be parsed correctly.
     */
    public PagingContainer<StringSticker> getStringStickerList(@NonNull QueryParams params) throws URISyntaxException, IOException {
        if (authKey == null) {
            throw new NullPointerException(noAuthKeyMessage);
        }
        return getStringStickerList(params, authKey);
    }

    /**
     * The request creates new {@link StringSticker}.
     * @param body body with parameters to create new sticker.
     * @param authKey yougile key.
     * @return ID of the created sticker.
     * @throws IOException then the json cannot be parsed correctly.
     */
    public Id createStringSticker(@NonNull StringStickerCreateBody body, @NonNull AuthKey authKey) throws URISyntaxException, IOException {
        Response response = sendPostRequest(configureURI().build(), body, authKey);
        Content content = response.handleResponse(ResponseHandlerProvider::createdJsonHandler);
        return ContentHandler.handleEntity(content, Id.class);
    }

    /**
     * The request creates new {@link StringSticker}.
     * The passed key in constructor will be used by default.
     * @param body body with parameters to create new sticker.
     * @return ID of the created sticker.
     * @throws IOException then the json cannot be parsed correctly.
     */
    public Id createStringSticker(@NonNull StringStickerCreateBody body) throws URISyntaxException, IOException {
        if (authKey == null) {
            throw new NullPointerException(noAuthKeyMessage);
        }
        return createStringSticker(body, authKey);
    }

    /**
     * The request gets {@link StringSticker} by ID.
     * @param id sticker ID.
     * @param authKey yougile key.
     * @return string-sticker, if it's available.
     * @throws IOException then the json cannot be parsed correctly.
     */
    public StringSticker getStringStickerById(@NonNull String id, @NonNull AuthKey authKey) throws URISyntaxException, IOException {
        Response response = sendGetRequest(configureURI(id).build(), authKey);
        Content content = response.handleResponse(ResponseHandlerProvider::okJsonHandler);
        return ContentHandler.handleEntity(content, StringSticker.class);
    }

    /**
     * The request gets {@link StringSticker} by ID.
     * The passed key in constructor will be used by default.
     * @param id sticker ID.
     * @return state-sticker, if it's available.
     * @throws IOException then the json cannot be parsed correctly.
     */
    public StringSticker getStringStickerById(@NonNull String id) throws URISyntaxException, IOException {
        if (authKey == null) {
            throw new NullPointerException(noAuthKeyMessage);
        }
        return getStringStickerById(id, authKey);
    }

    /**
     * The request updates string-sticker by ID.
     * @param id sticker ID.
     * @param body body with parameters to update.
     * @param authKey yougile key.
     * @return ID of the updated sticker.
     * @throws IOException then the json cannot be parsed correctly.
     */
    public Id updateStringSticker(@NonNull String id, @NonNull StringStickerUpdateBody body, @NonNull AuthKey authKey) throws URISyntaxException, IOException {
        Response response = sendPutRequest(configureURI(id).build(), body, authKey);
        Content content = response.handleResponse(ResponseHandlerProvider::okJsonHandler);
        return ContentHandler.handleEntity(content, Id.class);
    }

    /**
     * The request updates string-sticker by ID.
     * The passed key in constructor will be used by default.
     * @param id sticker ID.
     * @param body body with parameters to update.
     * @return ID of the updated sticker.
     * @throws IOException then the json cannot be parsed correctly.
     */
    public Id updateStringSticker(@NonNull String id, @NonNull StringStickerUpdateBody body) throws URISyntaxException, IOException {
        if (authKey == null) {
            throw new NullPointerException(noAuthKeyMessage);
        }
        return updateStringSticker(id, body, authKey);
    }

    /**
     * The request updated string-sticker by passed {@link StringSticker}.
     * @param stringSticker state-sticker to update.
     * @param authKey yougile key.
     * @return ID of the updated state-sticker.
     * @throws IOException then the json cannot be parsed correctly.
     */
    public Id updateStringSticker(@NonNull StringSticker stringSticker, @NonNull AuthKey authKey) throws URISyntaxException, IOException {
        StringStickerUpdateBody body = StringStickerUpdateBody.builder()
                .deleted(stringSticker.isDeleted())
                .icon(stringSticker.getIcon())
                .name(stringSticker.getName())
                .build();
        return updateStringSticker(stringSticker.getId(), body);
    }

    /**
     * The request updated string-sticker by passed {@link StringSticker}.
     * The passed key in constructor will be used by default.
     * @param stringSticker state-sticker to update.
     * @return ID of the updated state-sticker.
     * @throws IOException then the json cannot be parsed correctly.
     */
    public Id updateStringSticker(@NonNull StringSticker stringSticker) throws URISyntaxException, IOException {
        if (authKey == null) {
            throw new NullPointerException(noAuthKeyMessage);
        }
        return updateStringSticker(stringSticker, authKey);
    }

    /**
     * The request gets {@link StringStickerState} by ID.
     * @param stickerId ID of the sticker, which the state is placed.
     * @param stateId ID of the state.
     * @param params {@link QueryParams} Request parameters<p>
     *                                  Available parameter names:<ul>
     *                                  <li>{@code includeDeleted} ({@code boolean}) - By default,
     *                                   if an object has been marked as deleted, it will not be found.
     *                                   Set true so that deleted objects are returned.
     *                                  </ul>
     * @param authKey yougile key
     * @return State of the string-sticker, if it's available.
     * @throws IOException then the json cannot be parsed correctly.
     */
    public StringStickerState getStringStickerState(@NonNull String stickerId, @NonNull String stateId, @NonNull QueryParams params , @NonNull AuthKey authKey) throws URISyntaxException, IOException {
        URI uri = configureURI(params).setPathSegments(getStatePathSegments(stickerId, stateId)).build();
        Response response = sendGetRequest(uri, authKey);
        Content content = response.handleResponse(ResponseHandlerProvider::okJsonHandler);
        return ContentHandler.handleEntity(content, StringStickerState.class);
    }

    /**
     * The request gets {@link StringStickerState} by ID.
     * The passed key in constructor will be used by default.
     * @param stickerId ID of the sticker, which the state is placed.
     * @param stateId ID of the state.
     * @param params {@link QueryParams} Request parameters<p>
     *                                  Available parameter names:<ul>
     *                                  <li>{@code includeDeleted} ({@code boolean}) - By default,
     *                                   if an object has been marked as deleted, it will not be found.
     *                                   Set true so that deleted objects are returned.
     *                                  </ul>
     * @return State of the string-sticker, if it's available.
     * @throws IOException then the json cannot be parsed correctly.
     */
    public StringStickerState getStringStickerState(@NonNull String stickerId, @NonNull String stateId, @NonNull QueryParams params) throws URISyntaxException, IOException {
        if (authKey == null) {
            throw new NullPointerException(noAuthKeyMessage);
        }
        return getStringStickerState(stickerId, stateId, params, authKey);
    }

    /**
     * The request updates state for string-sticker.
     * @param stickerId ID of the string-sticker.
     * @param stateId ID of the state.
     * @param body body with parameters to update.
     * @param authKey yougile key.
     * @return ID of the updated state.
     * @throws IOException then the json cannot be parsed correctly.
     */
    public Id updateStringStickerState(@NonNull String stickerId, @NonNull String stateId, @NonNull StringStickerStateUpdateBody body, @NonNull AuthKey authKey) throws URISyntaxException, IOException {
        URI uri = configureURI().setPathSegments(getStatePathSegments(stickerId, stateId)).build();
        Response response = sendPutRequest(uri, body, authKey);
        Content content = response.handleResponse(ResponseHandlerProvider::okJsonHandler);
        return ContentHandler.handleEntity(content, Id.class);
    }

    /**
     * The request updates state for string-sticker.
     * The passed key in constructor will be used by default.
     * @param stickerId ID of the string-sticker.
     * @param stateId ID of the state.
     * @param body body with parameters to update.
     * @return ID of the updated state.
     * @throws IOException then the json cannot be parsed correctly.
     */
    public Id updateStringStickerState(@NonNull String stickerId, @NonNull String stateId, @NonNull StringStickerStateUpdateBody body) throws URISyntaxException, IOException {
        if (authKey == null) {
            throw new NullPointerException(noAuthKeyMessage);
        }
        return updateStringStickerState(stickerId, stateId, body, authKey);
    }

    /**
     * The request updates state for passed {@link StringStickerState}.
     * @param stickerId ID of the string-sticker.
     * @param state state for update.
     * @param authKey yougile key.
     * @return ID of the updated state.
     * @throws IOException then the json cannot be parsed correctly.
     */
    public Id updateStringStickerState(@NonNull String stickerId, @NonNull StringStickerState state, @NonNull AuthKey authKey) throws URISyntaxException, IOException {
        StringStickerStateUpdateBody body = StringStickerStateUpdateBody.builder()
                .name(state.getName())
                .color(state.getColor())
                .deleted(state.isDeleted())
                .build();
        return updateStringStickerState(stickerId, state.getId(), body, authKey);
    }

    /**
     * The request updates state for passed {@link StringStickerState}.
     * The passed key in constructor will be used by default.
     * @param stickerId ID of the state-sticker.
     * @param state state for update.
     * @return ID of the updated state.
     * @throws IOException then the json cannot be parsed correctly.
     */
    public Id updateStringStickerState(@NonNull String stickerId, @NonNull StringStickerState state) throws URISyntaxException, IOException {
        if (authKey == null) {
            throw new NullPointerException(noAuthKeyMessage);
        }
        return updateStringStickerState(stickerId, state, authKey);
    }

    /**
     * The request creates new state for string-sticker.
     * @param stickerId ID of the string-sticker.
     * @param body body with parameters to create.
     * @param authKey yougile key.
     * @return ID of the created state.
     * @throws IOException then the json cannot be parsed correctly.
     */
    public Id createStringStickerState(@NonNull String stickerId, @NonNull StringStickerStateCreateBody body, @NonNull AuthKey authKey) throws URISyntaxException, IOException {
        URI uri = configureURI().setPathSegments(getStatePathSegments(stickerId)).build();
        Response response = sendPostRequest(uri, body, authKey);
        Content content = response.handleResponse(ResponseHandlerProvider::createdJsonHandler);
        return ContentHandler.handleEntity(content, Id.class);
    }

    /**
     * The request creates new state for string-sticker.
     * The passed key in constructor will be used by default.
     * @param stickerId ID of the string-sticker.
     * @param body      body with parameters to create.
     * @return ID of the created state.
     * @throws IOException then the json cannot be parsed correctly.
     */
    public Id createStringStickerState(@NonNull String stickerId, @NonNull StringStickerStateCreateBody body) throws URISyntaxException, IOException {
        if (authKey == null) {
            throw new NullPointerException(noAuthKeyMessage);
        }
        return createStringStickerState(stickerId, body, authKey);
    }

    private String[] getStatePathSegments(String stickerId, String stateId) {
        return new String[] {apiPath, endpoint, stickerId, "states", stateId};
    }

    private String[] getStatePathSegments(String stickerId) {
        return new String[] {apiPath, endpoint, stickerId, "states"};
    }

}
