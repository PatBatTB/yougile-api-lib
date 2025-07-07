package io.github.patbattb.yougileapilib.service;

import io.github.patbattb.yougileapilib.domain.*;
import io.github.patbattb.yougileapilib.domain.body.ColumnCreateBody;
import io.github.patbattb.yougileapilib.domain.body.ColumnUpdateBody;
import io.github.patbattb.yougileapilib.http.ResponseHandlerProvider;
import lombok.NonNull;
import org.apache.http.client.fluent.Content;
import org.apache.http.client.fluent.Response;

import java.io.IOException;
import java.net.URISyntaxException;

/**
 * Service for managing columns.
 */
public class ColumnService extends AbstractRequestService {

    /**
     * If the service constructs without {@link AuthKey}, key must be passed to each method as argument.
     */
    public ColumnService() {
        this(null);
    }

    /**
     * If the service constructs with {@link AuthKey}, you can use methods without key in parameters.
     * The passed key in constructor will be used by default.
     * If you want to send request with separate key, but without new service creating,
     * you can also use methods with {@link AuthKey} in parameters.
     * @param authKey yougile key for using by default in the Service instance.
     */
    public ColumnService(AuthKey authKey) {
        super("columns", authKey);
    }

    /**
     * The request gets container with {@link Column} list
     * @param params {@link QueryParams} Request parameters<p>
     *                                  Available parameter names:<ul>
     *                                  <li>{@code boardId} ({@code string}) - ID of the board.
     *                                  <li>{@code includeDeleted} ({@code boolean}) - By default,
     *                                     if an object has been marked as deleted, it will not be found.
     *                                     Set true so that deleted objects are returned.
     *                                  <li>{@code limit} ({@code number}) - The number of items you want to receive. Maximum 1000.
     *                                  <li>{@code offset} ({@code number}) - The index of the first element.
     *                                  <li>{@code title} ({@code String}) - Column title.
     *                                  </ul>
     * @param authKey yougile key.
     *
     * @return list of {@link Column}
     * @throws IOException then the json cannot be parsed correctly
     */
    public PagingContainer<Column> getColumnList(@NonNull QueryParams params, @NonNull AuthKey authKey) throws URISyntaxException, IOException {
        Response response = sendGetRequest(configureURI(params).build(), authKey);
        Content content = response.handleResponse(ResponseHandlerProvider::okJsonHandler);
        return ContentHandler.handleColumnList(content);
    }

    /**
     * The request gets container with {@link Column} list.
     * The passed key in constructor will be used by default.
     * @param params {@link QueryParams} Request parameters<p>
     *                                  Available parameter names:<ul>
     *                                  <li>{@code boardId} ({@code string}) - ID of the board.
     *                                  <li>{@code includeDeleted} ({@code boolean}) - By default,
     *                                     if an object has been marked as deleted, it will not be found.
     *                                     Set true so that deleted objects are returned.
     *                                  <li>{@code limit} ({@code number}) - The number of items you want to receive. Maximum 1000.
     *                                  <li>{@code offset} ({@code number}) - The index of the first element.
     *                                  <li>{@code title} ({@code String}) - Column title.
     *                                  </ul>
     *
     * @return list of {@link Column}
     * @throws IOException then the json cannot be parsed correctly
     */
    public PagingContainer<Column> getColumnList(@NonNull QueryParams params) throws URISyntaxException, IOException {
        if (authKey == null) {
            throw new NullPointerException(noAuthKeyMessage);
        }
        return getColumnList(params, authKey);
    }

    /**
     * The request creates new column.
     * The passed key in constructor will be used by default.
     * @param body request body.
     * @param authKey yougile key.
     * @return ID of the created column.
     * @throws IOException then the json cannot be parsed correctly
     */
    public Id createColumn(@NonNull ColumnCreateBody body, @NonNull AuthKey authKey) throws URISyntaxException, IOException {
        Response response = sendPostRequest(configureURI().build(), body, authKey);
        Content content = response.handleResponse(ResponseHandlerProvider::createdJsonHandler);
        return ContentHandler.handleId(content);
    }

    /**
     * The request creates new column.
     * @param body request body.
     * @return ID of the created column.
     * @throws IOException then the json cannot be parsed correctly
     */
    public Id createColumn(@NonNull ColumnCreateBody body) throws URISyntaxException, IOException {
        if (authKey == null) {
            throw new NullPointerException(noAuthKeyMessage);
        }
        return createColumn(body, authKey);
    }

    /**
     * The request gets {@link Column} by ID.
     * @param columnId - ID of the column.
     * @param authKey - yougile key.
     * @return column, if it's available.
     * @throws IOException The passed key in constructor will be used by default.
     */
    public Column getColumnById(@NonNull String columnId, @NonNull AuthKey authKey) throws URISyntaxException, IOException {
        Response response = sendGetRequest(configureURI(columnId).build(), authKey);
        Content content = response.handleResponse(ResponseHandlerProvider::okJsonHandler);
        return ContentHandler.handleColumn(content);
    }

    /**
     * The request gets {@link Column} by ID.
     * The passed key in constructor will be used by default.
     * @param columnId - ID of the column.
     * @return column, if it's available.
     * @throws IOException The passed key in constructor will be used by default.
     */
    public Column getColumnById(@NonNull String columnId) throws URISyntaxException, IOException {
        if (authKey == null) {
            throw new NullPointerException(noAuthKeyMessage);
        }
        return getColumnById(columnId, authKey);
    }

    /**
     * The request updates column by ID.
     * @param columnId - ID of the column.
     * @param body - update body.
     * @param authKey - yougile key.
     * @return ID of the updated column.
     * @throws IOException The passed key in constructor will be used by default.
     */
    public Id updateColumn(@NonNull String columnId, @NonNull ColumnUpdateBody body, @NonNull AuthKey authKey) throws URISyntaxException, IOException {
        Response response = sendPutRequest(configureURI(columnId).build(), body, authKey);
        Content content = response.handleResponse(ResponseHandlerProvider::okJsonHandler);
        return ContentHandler.handleId(content);
    }

    /**
     * The request updates column by ID.
     * The passed key in constructor will be used by default.
     * @param columnId - ID of the column.
     * @param body - update body.
     * @return ID of the updated column.
     * @throws IOException The passed key in constructor will be used by default.
     */
    public Id updateColumn(@NonNull String columnId, @NonNull ColumnUpdateBody body) throws URISyntaxException, IOException {
        if (authKey == null) {
            throw new NullPointerException(noAuthKeyMessage);
        }
        return updateColumn(columnId, body, authKey);
    }

    /**
     * The request updates column by the passed {@link Column}
     * @param column column to update.
     * @param authkey yougile key.
     * @return ID of the updated column.
     * @throws IOException The passed key in constructor will be used by default.
     */
    public Id updateColumn(@NonNull Column column, @NonNull AuthKey authkey) throws URISyntaxException, IOException {
        ColumnUpdateBody body = ColumnUpdateBody.builder()
                .deleted(column.isDeleted())
                .title(column.getTitle())
                .color(column.getColor())
                .boardId(column.getBoardId())
                .build();
        return updateColumn(column.getId(), body, authKey);
    }

    /**
     * The request updates column by the passed {@link Column}
     * The passed key in constructor will be used by default.
     * @param column column to update.
     * @return ID of the updated column.
     * @throws IOException The passed key in constructor will be used by default.
     */
    public Id updateColumn(@NonNull Column column) throws URISyntaxException, IOException {
        if (authKey == null) {
            throw new NullPointerException(noAuthKeyMessage);
        }
        return updateColumn(column, authKey);
    }
}
