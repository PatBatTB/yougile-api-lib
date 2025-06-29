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

public class ColumnService extends AbstractRequestService {

    public ColumnService() {
        this(null);
    }

    public ColumnService(AuthKey authKey) {
        super("columns", authKey);
    }

    /**
     * @param params {@link QueryParams} Request parameters<p>
     *                                  Available parameter names:<ul>
     *                                  <li>{@code boardId} - string
     *                                  <li>{@code includeDeleted} - boolean
     *                                  <li>{@code limit} - number
     *                                  <li>{@code offset} - number
     *                                  <li>{@code parentId} - string
     *                                  <li>{@code title} - string
     *                                  </ul>
     *
     * @return list of {@link Column}
     * @throws URISyntaxException
     * @throws IOException
     */
    public PagingContainer<Column> getColumnList(@NonNull QueryParams params, @NonNull AuthKey authKey) throws URISyntaxException, IOException {
        Response response = sendGetRequest(configureURI(params).build(), authKey);
        Content content = response.handleResponse(ResponseHandlerProvider::okJsonHandler);
        return ContentHandler.handleColumnList(content);
    }

    /**
     * @param params {@link QueryParams} Request parameters<p>
     *                                  Available parameter names:<ul>
     *                                  <li>{@code boardId} - string
     *                                  <li>{@code includeDeleted} - boolean
     *                                  <li>{@code limit} - number
     *                                  <li>{@code offset} - number
     *                                  <li>{@code parentId} - string
     *                                  <li>{@code title} - string
     *                                  </ul>
     *
     * @return list of {@link Column}
     * @throws URISyntaxException
     * @throws IOException
     */
    public PagingContainer<Column> getColumnList(@NonNull QueryParams params) throws URISyntaxException, IOException {
        if (authKey == null) {
            throw new NullPointerException(noAuthKeyMessage);
        }
        return getColumnList(params, authKey);
    }

    public Id createColumn(@NonNull ColumnCreateBody body, @NonNull AuthKey authKey) throws URISyntaxException, IOException {
        Response response = sendPostRequest(configureURI().build(), body, authKey);
        Content content = response.handleResponse(ResponseHandlerProvider::createdJsonHandler);
        return ContentHandler.handleId(content);
    }

    public Id createColumn(@NonNull ColumnCreateBody body) throws URISyntaxException, IOException {
        if (authKey == null) {
            throw new NullPointerException(noAuthKeyMessage);
        }
        return createColumn(body, authKey);
    }

    public Column getColumnById(@NonNull String columnId, @NonNull AuthKey authKey) throws URISyntaxException, IOException {
        Response response = sendGetRequest(configureURI(columnId).build(), authKey);
        Content content = response.handleResponse(ResponseHandlerProvider::okJsonHandler);
        return ContentHandler.handleColumn(content);
    }

    public Column getColumnById(@NonNull String columnId) throws URISyntaxException, IOException {
        if (authKey == null) {
            throw new NullPointerException(noAuthKeyMessage);
        }
        return getColumnById(columnId, authKey);
    }

    public Id updateColumn(@NonNull String columnId, @NonNull ColumnUpdateBody body, @NonNull AuthKey authKey) throws URISyntaxException, IOException {
        Response response = sendPutRequest(configureURI(columnId).build(), body, authKey);
        Content content = response.handleResponse(ResponseHandlerProvider::okJsonHandler);
        return ContentHandler.handleId(content);
    }

    public Id updateColumn(@NonNull String columnId, @NonNull ColumnUpdateBody body) throws URISyntaxException, IOException {
        if (authKey == null) {
            throw new NullPointerException(noAuthKeyMessage);
        }
        return updateColumn(columnId, body, authKey);
    }

    public Id updateColumn(@NonNull Column column, @NonNull AuthKey authkey) throws URISyntaxException, IOException {
        ColumnUpdateBody body = ColumnUpdateBody.builder()
                .deleted(column.isDeleted())
                .title(column.getTitle())
                .color(column.getColor())
                .boardId(column.getBoardId())
                .build();
        return updateColumn(column.getId(), body, authKey);
    }

    public Id updateColumn(@NonNull Column column) throws URISyntaxException, IOException {
        if (authKey == null) {
            throw new NullPointerException(noAuthKeyMessage);
        }
        return updateColumn(column, authKey);
    }
}
