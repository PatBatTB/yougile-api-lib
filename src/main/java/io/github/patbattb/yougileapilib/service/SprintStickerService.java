package io.github.patbattb.yougileapilib.service;

import io.github.patbattb.yougileapilib.domain.*;
import io.github.patbattb.yougileapilib.domain.body.SprintStickerCreateBody;
import io.github.patbattb.yougileapilib.domain.body.SprintStickerStateCreateBody;
import io.github.patbattb.yougileapilib.domain.body.SprintStickerStateUpdateBody;
import io.github.patbattb.yougileapilib.domain.body.SprintStickerUpdateBody;
import io.github.patbattb.yougileapilib.http.ResponseHandlerProvider;
import lombok.NonNull;
import org.apache.http.client.fluent.Content;
import org.apache.http.client.fluent.Response;

import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;

/**
 * The service for managing of sprint-stickers.
 */
public class SprintStickerService extends AbstractRequestService {

    /**
     * If the service constructs without {@link AuthKey}, key must be passed to each method as argument.
     */
    public SprintStickerService() {
        this(null);
    }

    /**
     * If the service constructs with {@link AuthKey}, you can use methods without key in parameters.
     * The passed key in constructor will be used by default.
     * If you want to send request with separate key, but without new service creating,
     * you can also use methods with {@link AuthKey} in parameters.
     * @param authKey yougile key for using by default in the Service instance.
     */
    public SprintStickerService(AuthKey authKey) {
        super("sprint-stickers", authKey);
    }

    /**
     * The request gets the container with {@link SprintSticker} list.
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
     * @return container with {@link SprintSticker} list.
     * @throws IOException then the json cannot be parsed correctly.
     */
    public PagingContainer<SprintSticker> getSprintStickerList(@NonNull QueryParams params, @NonNull AuthKey authKey) throws URISyntaxException, IOException {
        Response response = sendGetRequest(configureURI(params).build(), authKey);
        Content content = response.handleResponse(ResponseHandlerProvider::okJsonHandler);
        return ContentHandler.handlePagingContent(content, SprintSticker.class);
    }

    /**
     * The request gets the container with {@link SprintSticker} list.
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
     * @return container with {@link SprintSticker} list.
     * @throws IOException then the json cannot be parsed correctly.
     */
    public PagingContainer<SprintSticker> getSprintStickerList(@NonNull QueryParams params) throws URISyntaxException, IOException {
        if (authKey == null) {
            throw new NullPointerException(noAuthKeyMessage);
        }
        return getSprintStickerList(params, authKey);
    }

    /**
     * The request creates new sprint-sticker.
     * @param body body with parameters for creating sticker.
     * @param authKey yougile key.
     * @return ID of the created sticker.
     * @throws IOException then the json cannot be parsed correctly.
     */
    public Id createSprintSticker(@NonNull SprintStickerCreateBody body, @NonNull AuthKey authKey) throws URISyntaxException, IOException {
        Response response = sendPostRequest(configureURI().build(), body, authKey);
        Content content = response.handleResponse(ResponseHandlerProvider::createdJsonHandler);
        return ContentHandler.handleEntity(content, Id.class);
    }

    /**
     * The request creates new sprint-sticker.
     * The passed key in constructor will be used by default.
     * @param body body with parameters for creating sticker.
     * @return ID of the created sticker.
     * @throws IOException then the json cannot be parsed correctly.
     */
    public Id createSprintSticker(@NonNull SprintStickerCreateBody body) throws URISyntaxException, IOException {
        if (authKey == null) {
            throw new NullPointerException(noAuthKeyMessage);
        }
        return createSprintSticker(body, authKey);
    }

    /**
     * The request gets {@link SprintSticker} by ID.
     * @param stickerId ID of the sprint-sticker.
     * @param authKey yougile key.
     * @return sprint-sticker, if it's available.
     * @throws IOException then the json cannot be parsed correctly.
     */
    public SprintSticker getSprintStickerById(@NonNull String stickerId, @NonNull AuthKey authKey) throws URISyntaxException, IOException {
        Response response = sendGetRequest(configureURI(stickerId).build(), authKey);
        Content content = response.handleResponse(ResponseHandlerProvider::okJsonHandler);
        return ContentHandler.handleEntity(content, SprintSticker.class);
    }

    /**
     * The request gets {@link SprintSticker} by ID.
     * The passed key in constructor will be used by default.
     * @param stickerId ID of the sprint-sticker.
     * @return sprint-sticker, if it's available.
     * @throws IOException then the json cannot be parsed correctly.
     */
    public SprintSticker getSprintStickerById(@NonNull String stickerId) throws URISyntaxException, IOException {
        if (authKey == null) {
            throw new NullPointerException(noAuthKeyMessage);
        }
        return getSprintStickerById(stickerId, authKey);
    }

    /**
     * The request updates sprint-sticker.
     * @param stickerId ID of the sticker to update.
     * @param body body with parameters to update.
     * @param authKey yougile key.
     * @return ID of the updates sticker.
     * @throws IOException then the json cannot be parsed correctly.
     */
    public Id updateSprintSticker(@NonNull String stickerId, @NonNull SprintStickerUpdateBody body, @NonNull AuthKey authKey) throws URISyntaxException, IOException {
        Response response = sendPutRequest(configureURI(stickerId).build(), body, authKey);
        Content content = response.handleResponse(ResponseHandlerProvider::okJsonHandler);
        return ContentHandler.handleEntity(content, Id.class);
    }

    /**
     * The request updates sprint-sticker.
     * The passed key in constructor will be used by default.
     * @param stickerId ID of the sticker to update.
     * @param body body with parameters to update.
     * @return ID of the updates sticker.
     * @throws IOException then the json cannot be parsed correctly.
     */
    public Id updateSprintSticker(@NonNull String stickerId, @NonNull SprintStickerUpdateBody body) throws URISyntaxException, IOException {
        if (authKey == null) {
            throw new NullPointerException(noAuthKeyMessage);
        }
        return updateSprintSticker(stickerId, body, authKey);
    }

    /**
     * The request updates sprint-sticker by passed {@link SprintSticker}.
     * @param sticker sticker to update.
     * @param authKey yougile key
     * @return ID of the updated sticker.
     * @throws IOException then the json cannot be parsed correctly.
     */
    public Id updateSprintSticker(@NonNull SprintSticker sticker, @NonNull AuthKey authKey) throws URISyntaxException, IOException {
        SprintStickerUpdateBody body = SprintStickerUpdateBody.builder()
                .deleted(sticker.isDeleted())
                .name(sticker.getName())
                .build();
        return updateSprintSticker(sticker.getId(), body, authKey);
    }

    /**
     * The request updates sprint-sticker by passed {@link SprintSticker}.
     * The passed key in constructor will be used by default.
     * @param sticker sticker to update.
     * @return ID of the updated sticker.
     * @throws IOException then the json cannot be parsed correctly.
     */
    public Id updateSprintSticker(@NonNull SprintSticker sticker) throws URISyntaxException, IOException {
        if (authKey == null) {
            throw new NullPointerException(noAuthKeyMessage);
        }
        return updateSprintSticker(sticker, authKey);
    }

    /**
     * The request gets {@link SprintStickerState} by ID.
     * @param stickerId ID of the sticker contained the state.
     * @param stateId ID of the state
     * @param params {@link QueryParams} Request parameters<p>
     *                                  Available parameter names:<ul>
     *                                  <li>{@code includeDeleted} ({@code boolean}) - By default,
     *                                   if an object has been marked as deleted, it will not be found.
     *                                   Set true so that deleted objects are returned.
     *                                  </ul>
     * @param authKey yougile key.
     * @return sprint-sticker, if it's available.
     * @throws IOException then the json cannot be parsed correctly.
     */
    public SprintStickerState getSprintStickerStateById(
            @NonNull String stickerId, @NonNull String stateId, @NonNull QueryParams params, @NonNull AuthKey authKey) throws URISyntaxException, IOException {
        URI uri = configureURI(params).setPathSegments(getStatePathSegments(stickerId, stateId)).build();
        Response response = sendGetRequest(uri, authKey);
        Content content = response.handleResponse(ResponseHandlerProvider::okJsonHandler);
        return ContentHandler.handleEntity(content, SprintStickerState.class);
    }

    /**
     * The request gets {@link SprintStickerState} by ID.
     * The passed key in constructor will be used by default.
     * @param stickerId ID of the sticker contained the state.
     * @param stateId ID of the state
     * @param params {@link QueryParams} Request parameters<p>
     *                                  Available parameter names:<ul>
     *                                  <li>{@code includeDeleted} ({@code boolean}) - By default,
     *                                   if an object has been marked as deleted, it will not be found.
     *                                   Set true so that deleted objects are returned.
     *                                  </ul>
     * @return sprint-sticker, if it's available.
     * @throws IOException then the json cannot be parsed correctly.
     */
    public SprintStickerState getSprintStickerStateById(
            @NonNull String stickerId, @NonNull String stateId, @NonNull QueryParams params) throws URISyntaxException, IOException {
        if (authKey == null) {
            throw new NullPointerException(noAuthKeyMessage);
        }
        return getSprintStickerStateById(stickerId, stateId, params, authKey);
    }

    /**
     * The request updates state of the sprint-sticker.
     * @param stickerId ID of the sticker contained the state.
     * @param stateId ID of the state.
     * @param body body with parameters to update.
     * @param authKey yougile key.
     * @return ID of the updated state.
     * @throws IOException then the json cannot be parsed correctly.
     */
    public Id updateSprintStickerState(@NonNull String stickerId, @NonNull String stateId,
                                       @NonNull SprintStickerStateUpdateBody body, @NonNull AuthKey authKey) throws URISyntaxException, IOException {
        URI uri = configureURI().setPathSegments(getStatePathSegments(stickerId, stateId)).build();
        Response response = sendPutRequest(uri, body, authKey);
        Content content = response.handleResponse(ResponseHandlerProvider::okJsonHandler);
        return ContentHandler.handleEntity(content, Id.class);
    }

    /**
     * The request updates state of the sprint-sticker.
     * The passed key in constructor will be used by default.
     * @param stickerId ID of the sticker contained the state.
     * @param stateId ID of the state.
     * @param body body with parameters to update.
     * @return ID of the updated state.
     * @throws IOException then the json cannot be parsed correctly.
     */
    public Id updateSprintStickerState(@NonNull String stickerId, @NonNull String stateId,
                                       @NonNull SprintStickerStateUpdateBody body) throws URISyntaxException, IOException {
        if (authKey == null) {
            throw new NullPointerException(noAuthKeyMessage);
        }
        return updateSprintStickerState(stickerId, stateId, body, authKey);
    }

    /**
     * The request updates state of the sprint-sticker by passed {@link SprintStickerState}.
     *
     * @param stickerId ID of the sticker contained the state.
     * @param state state of the sprint-sticker to update.
     * @param authKey yougile key.
     * @return ID of the updated state.
     * @throws IOException then the json cannot be parsed correctly.
     */
    public Id updateSprintStickerState(@NonNull String stickerId, @NonNull SprintStickerState state,
                                       @NonNull AuthKey authKey) throws URISyntaxException, IOException {
        SprintStickerStateUpdateBody body = SprintStickerStateUpdateBody.builder()
                .name(state.getName())
                .deleted(state.isDeleted())
                .build();
        return updateSprintStickerState(stickerId, state.getId(), body, authKey);
    }

    /**
     * The request updates state of the sprint-sticker by passed {@link SprintStickerState}.
     * The passed key in constructor will be used by default.
     * @param stickerId ID of the sticker contained the state.
     * @param state     state of the sprint-sticker to update.
     * @return ID of the updated state.
     * @throws IOException then the json cannot be parsed correctly.
     */
    public Id updateSprintStickerState(@NonNull String stickerId, @NonNull SprintStickerState state) throws URISyntaxException, IOException {
        if (authKey == null) {
            throw new NullPointerException(noAuthKeyMessage);
        }
        return updateSprintStickerState(stickerId, state, authKey);
    }

    /**
     * The request creates new state for the sprint-sticker.
     * @param stickerId ID of the sprint-sticker.
     * @param body body with parameters to create.
     * @param authKey youfile key.
     * @return ID of the created state.
     * @throws IOException then the json cannot be parsed correctly.
     */
    public Id createSprintStickerState(@NonNull String stickerId, @NonNull SprintStickerStateCreateBody body, @NonNull AuthKey authKey) throws URISyntaxException, IOException {
        URI uri = configureURI().setPathSegments(getStatePathSegments(stickerId)).build();
        Response response = sendPostRequest(uri, body, authKey);
        Content content = response.handleResponse(ResponseHandlerProvider::createdJsonHandler);
        return ContentHandler.handleEntity(content, Id.class);
    }

    /**
     * The request creates new state for the sprint-sticker.
     * The passed key in constructor will be used by default.
     * @param stickerId ID of the sprint-sticker.
     * @param body      body with parameters to create.
     * @return ID of the created state.
     * @throws IOException then the json cannot be parsed correctly.
     */
    public Id createSprintStickerState(@NonNull String stickerId, @NonNull SprintStickerStateCreateBody body) throws URISyntaxException, IOException {
        if (authKey == null) {
            throw new NullPointerException(noAuthKeyMessage);
        }
        return createSprintStickerState(stickerId, body, authKey);
    }

    private String[] getStatePathSegments(String stickerId, String stateId) {
        return new String[] {apiPath, endpoint, stickerId, "states", stateId};
    }

    private String[] getStatePathSegments(String stickerId) {
        return new String[] {apiPath, endpoint, stickerId, "states"};
    }

}
