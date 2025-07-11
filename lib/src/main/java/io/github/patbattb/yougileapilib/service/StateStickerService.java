package io.github.patbattb.yougileapilib.service;

import io.github.patbattb.yougileapilib.domain.*;
import io.github.patbattb.yougileapilib.domain.body.StateStickerCreateBody;
import io.github.patbattb.yougileapilib.domain.body.StateStickerStateUpdateBody;
import io.github.patbattb.yougileapilib.domain.body.StateStickerUpdateBody;
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
public class StateStickerService extends AbstractRequestService {

    /**
     * If the service constructs without {@link AuthKey}, key must be passed to each method as argument.
     */
    public StateStickerService() {
        this(null);
    }

    /**
     * If the service constructs with {@link AuthKey}, you can use methods without key in parameters.
     * The passed key in constructor will be used by default.
     * If you want to send request with separate key, but without new service creating,
     * you can also use methods with {@link AuthKey} in parameters.
     * @param authKey yougile key for using by default in the Service instance.
     */
    public StateStickerService(AuthKey authKey) {
        super("string-stickers", authKey);
    }

    /**
     * The request gets the container with {@link StateSticker} list.
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
     * @return container with {@link StateSticker} list.
     * @throws IOException then the json cannot be parsed correctly.
     */
    public PagingContainer<StateSticker> getStateStickerList(@NonNull QueryParams params, @NonNull AuthKey authKey) throws URISyntaxException, IOException {
        Response response = sendGetRequest(configureURI(params).build(), authKey);
        Content content = response.handleResponse(ResponseHandlerProvider::okJsonHandler);
        return ContentHandler.handlePagingContent(content, StateSticker.class);
    }

    /**
     * The request gets the container with {@link StateSticker} list.
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
     * @return container with {@link StateSticker} list.
     * @throws IOException then the json cannot be parsed correctly.
     */
    public PagingContainer<StateSticker> getStateStickerList(@NonNull QueryParams params) throws URISyntaxException, IOException {
        if (authKey == null) {
            throw new NullPointerException(noAuthKeyMessage);
        }
        return getStateStickerList(params, authKey);
    }

    /**
     * The request creates new {@link StateSticker}.
     * @param body body with parameters to create new sticker.
     * @param authKey yougile key.
     * @return ID of the created sticker.
     * @throws IOException then the json cannot be parsed correctly.
     */
    public Id createStateSticker(@NonNull StateStickerCreateBody body, @NonNull AuthKey authKey) throws URISyntaxException, IOException {
        Response response = sendPostRequest(configureURI().build(), body, authKey);
        Content content = response.handleResponse(ResponseHandlerProvider::createdJsonHandler);
        return ContentHandler.handleEntity(content, Id.class);
    }

    /**
     * The request creates new {@link StateSticker}.
     * The passed key in constructor will be used by default.
     * @param body body with parameters to create new sticker.
     * @return ID of the created sticker.
     * @throws IOException then the json cannot be parsed correctly.
     */
    public Id createStateSticker(@NonNull StateStickerCreateBody body) throws URISyntaxException, IOException {
        if (authKey == null) {
            throw new NullPointerException(noAuthKeyMessage);
        }
        return createStateSticker(body, authKey);
    }

    /**
     * The request gets {@link StateSticker} by ID.
     * @param id sticker ID.
     * @param authKey yougile key.
     * @return state-sticker, if it's available.
     * @throws IOException then the json cannot be parsed correctly.
     */
    public StateSticker getStateStickerById(@NonNull String id, @NonNull AuthKey authKey) throws URISyntaxException, IOException {
        Response response = sendGetRequest(configureURI(id).build(), authKey);
        Content content = response.handleResponse(ResponseHandlerProvider::okJsonHandler);
        return ContentHandler.handleEntity(content, StateSticker.class);
    }

    /**
     * The request gets {@link StateSticker} by ID.
     * The passed key in constructor will be used by default.
     * @param id sticker ID.
     * @return state-sticker, if it's available.
     * @throws IOException then the json cannot be parsed correctly.
     */
    public StateSticker getStateStickerById(@NonNull String id) throws URISyntaxException, IOException {
        if (authKey == null) {
            throw new NullPointerException(noAuthKeyMessage);
        }
        return getStateStickerById(id, authKey);
    }

    /**
     * The request updates state-sticker by ID.
     * @param id sticker ID.
     * @param body body with parameters to update.
     * @param authKey yougile key.
     * @return ID of the updated sticker.
     * @throws IOException then the json cannot be parsed correctly.
     */
    public Id updateStateSticker(@NonNull String id, @NonNull StateStickerUpdateBody body, @NonNull AuthKey authKey) throws URISyntaxException, IOException {
        Response response = sendPutRequest(configureURI(id).build(), body, authKey);
        Content content = response.handleResponse(ResponseHandlerProvider::okJsonHandler);
        return ContentHandler.handleEntity(content, Id.class);
    }

    /**
     * The request updates state-sticker by ID.
     * The passed key in constructor will be used by default.
     * @param id sticker ID.
     * @param body body with parameters to update.
     * @return ID of the updated sticker.
     * @throws IOException then the json cannot be parsed correctly.
     */
    public Id updateStateSticker(@NonNull String id, @NonNull StateStickerUpdateBody body) throws URISyntaxException, IOException {
        if (authKey == null) {
            throw new NullPointerException(noAuthKeyMessage);
        }
        return updateStateSticker(id, body, authKey);
    }

    /**
     * The request updated state-sticker by passed {@link StateSticker}.
     * @param stateSticker state-sticker to update.
     * @param authKey yougile key.
     * @return ID of the updated state-sticker.
     * @throws IOException then the json cannot be parsed correctly.
     */
    public Id updateStateSticker(@NonNull StateSticker stateSticker, @NonNull AuthKey authKey) throws URISyntaxException, IOException {
        StateStickerUpdateBody body = StateStickerUpdateBody.builder()
                .deleted(stateSticker.isDeleted())
                .icon(stateSticker.getIcon())
                .name(stateSticker.getName())
                .build();
        return updateStateSticker(stateSticker.getId(), body);
    }

    /**
     * The request updated state-sticker by passed {@link StateSticker}.
     * The passed key in constructor will be used by default.
     * @param stateSticker state-sticker to update.
     * @return ID of the updated state-sticker.
     * @throws IOException then the json cannot be parsed correctly.
     */
    public Id updateStateSticker(@NonNull StateSticker stateSticker) throws URISyntaxException, IOException {
        if (authKey == null) {
            throw new NullPointerException(noAuthKeyMessage);
        }
        return updateStateSticker(stateSticker, authKey);
    }

    /**
     * The request gets {@link StateStickerState} by ID.
     * @param stickerId ID of the sticker, which the state is placed.
     * @param stateId ID of the state.
     * @param params {@link QueryParams} Request parameters<p>
     *                                  Available parameter names:<ul>
     *                                  <li>{@code includeDeleted} ({@code boolean}) - By default,
     *                                   if an object has been marked as deleted, it will not be found.
     *                                   Set true so that deleted objects are returned.
     *                                  </ul>
     * @param authKey yougile key
     * @return State of the state-sticker, if it's available.
     * @throws IOException then the json cannot be parsed correctly.
     */
    public StateStickerState getStateStickerState(@NonNull String stickerId, @NonNull String stateId, @NonNull QueryParams params ,@NonNull AuthKey authKey) throws URISyntaxException, IOException {
        URI uri = configureURI(params).setPathSegments(getStatePathSegments(stickerId, stateId)).build();
        Response response = sendGetRequest(uri, authKey);
        Content content = response.handleResponse(ResponseHandlerProvider::okJsonHandler);
        return ContentHandler.handleEntity(content, StateStickerState.class);
    }

    /**
     * The request gets {@link StateStickerState} by ID.
     * The passed key in constructor will be used by default.
     * @param stickerId ID of the sticker, which the state is placed.
     * @param stateId ID of the state.
     * @param params {@link QueryParams} Request parameters<p>
     *                                  Available parameter names:<ul>
     *                                  <li>{@code includeDeleted} ({@code boolean}) - By default,
     *                                   if an object has been marked as deleted, it will not be found.
     *                                   Set true so that deleted objects are returned.
     *                                  </ul>
     * @return State of the state-sticker, if it's available.
     * @throws IOException then the json cannot be parsed correctly.
     */
    public StateStickerState getStateStickerState(@NonNull String stickerId, @NonNull String stateId, @NonNull QueryParams params) throws URISyntaxException, IOException {
        if (authKey == null) {
            throw new NullPointerException(noAuthKeyMessage);
        }
        return getStateStickerState(stickerId, stateId, params, authKey);
    }

    /**
     * The request updates state for state-sticker.
     * @param stickerId ID of the state-sticker.
     * @param stateId ID of the state.
     * @param body body with parameters to update.
     * @param authKey yougile key.
     * @return ID of the updated state.
     * @throws IOException then the json cannot be parsed correctly.
     */
    public Id updateStateStickerState(@NonNull String stickerId, @NonNull String stateId, @NonNull StateStickerStateUpdateBody body, @NonNull AuthKey authKey) throws URISyntaxException, IOException {
        URI uri = configureURI().setPathSegments(getStatePathSegments(stickerId, stateId)).build();
        Response response = sendPutRequest(uri, body, authKey);
        Content content = response.handleResponse(ResponseHandlerProvider::okJsonHandler);
        return ContentHandler.handleEntity(content, Id.class);
    }

    /**
     * The request updates state for state-sticker.
     * The passed key in constructor will be used by default.
     * @param stickerId ID of the state-sticker.
     * @param stateId ID of the state.
     * @param body body with parameters to update.
     * @return ID of the updated state.
     * @throws IOException then the json cannot be parsed correctly.
     */
    public Id updateStateStickerState(@NonNull String stickerId, @NonNull String stateId, @NonNull StateStickerStateUpdateBody body) throws URISyntaxException, IOException {
        if (authKey == null) {
            throw new NullPointerException(noAuthKeyMessage);
        }
        return updateStateStickerState(stickerId, stateId, body, authKey);
    }

    /**
     * The request updates state for passed {@link StateStickerState}.
     * @param stickerId ID of the state-sticker.
     * @param state state for update.
     * @param authKey yougile key.
     * @return ID of the updated state.
     * @throws IOException then the json cannot be parsed correctly.
     */
    public Id updateStateStickerState(@NonNull String stickerId, @NonNull StateStickerState state, @NonNull AuthKey authKey) throws URISyntaxException, IOException {
        StateStickerStateUpdateBody body = StateStickerStateUpdateBody.builder()
                .name(state.getName())
                .color(state.getColor())
                .deleted(state.isDeleted())
                .build();
        return updateStateStickerState(stickerId, state.getId(), body, authKey);
    }

    /**
     * The request updates state for passed {@link StateStickerState}.
     * The passed key in constructor will be used by default.
     * @param stickerId ID of the state-sticker.
     * @param state state for update.
     * @return ID of the updated state.
     * @throws IOException then the json cannot be parsed correctly.
     */
    public Id updateStateStickerState(@NonNull String stickerId, @NonNull StateStickerState state) throws URISyntaxException, IOException {
        if (authKey == null) {
            throw new NullPointerException(noAuthKeyMessage);
        }
        return updateStateStickerState(stickerId, state, authKey);
    }

    private String[] getStatePathSegments (String stickerId, String stateId) {
        return new String[]{apiPath, "string-stickers", stickerId, "states", stateId};
    }

}
