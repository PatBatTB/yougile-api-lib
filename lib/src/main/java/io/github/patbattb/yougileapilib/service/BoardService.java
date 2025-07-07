package io.github.patbattb.yougileapilib.service;

import io.github.patbattb.yougileapilib.domain.*;
import io.github.patbattb.yougileapilib.domain.body.BoardCreateBody;
import io.github.patbattb.yougileapilib.domain.body.BoardUpdateBody;
import io.github.patbattb.yougileapilib.http.ResponseHandlerProvider;
import lombok.NonNull;
import org.apache.http.client.fluent.Content;
import org.apache.http.client.fluent.Response;

import java.io.IOException;
import java.net.URISyntaxException;

/**
 * Service for managing of boards.
 */
public class BoardService extends AbstractRequestService {

    /**
     * If the service constructs without {@link AuthKey}, key must be passed to each method as argument.
     */
    public BoardService() {
        this(null);
    }

    /**
     * If the service constructs with {@link AuthKey}, you can use methods without key in parameters.
     * The passed key in constructor will be used by default.
     * If you want to send request with separate key, but without new service creating,
     * you can also use methods with {@link AuthKey} in parameters.
     * @param authKey yougile key for using by default in the Service instance.
     */
    public BoardService(AuthKey authKey) {
        super("boards", authKey);
    }

    /**
     * The request gets container with {@link Board} list.
     * @param params {@link QueryParams} Request parameters<p>
     *                                   Available parameter names:<ul>
     *                                   <li>{@code includeDeleted} ({@code boolean}) - By default,
     *                                   if an object has been marked as deleted, it will not be found.
     *                                   Set true so that deleted objects are returned.
     *                                   <li>{@code limit} ({@code number}) - The number of items you want to receive. Maximum 1000.
     *                                   <li>{@code offset} ({@code number}) - The index of the first element.
     *                                   <li>{@code projectId} ({@code String}) - project ID
     *                                   <li>{@code title} ({@code String}) - Board title.
     *                                   </ul>
     *
     * @param authKey yougile key.
     * @return the list of {@link AuthKey}
     * @throws IOException then the json cannot be parsed correctly.
     */
    public PagingContainer<Board> getBoardList(@NonNull QueryParams params, @NonNull AuthKey authKey) throws URISyntaxException, IOException {
        Response response = sendGetRequest(configureURI(params).build(), authKey);
        Content content = response.handleResponse(ResponseHandlerProvider::okJsonHandler);
        return ContentHandler.handleBoardList(content);
    }

    /**
     * The request gets container with {@link Board} list.
     * The method uses {@link AuthKey} passed to service constructor on instantiation.
     * @param params {@link QueryParams} Request parameters<p>
     *                                   Available parameter names:<ul>
     *                                   <li>{@code includeDeleted} ({@code boolean}) - By default,
     *                                   if an object has been marked as deleted, it will not be found.
     *                                   Set true so that deleted objects are returned.
     *                                   <li>{@code limit} ({@code number}) - The number of items you want to receive. Maximum 1000.
     *                                   <li>{@code offset} ({@code number}) - The index of the first element.
     *                                   <li>{@code projectId} ({@code String}) - project ID
     *                                   <li>{@code title} ({@code String}) - Board title.
     *                                   </ul>
     *
     * @return the list of {@link AuthKey}
     * @throws IOException then the json cannot be parsed correctly
     */
    public PagingContainer<Board> getBoardList(@NonNull QueryParams params) throws URISyntaxException, IOException {
        if (authKey == null) {
            throw new NullPointerException(noAuthKeyMessage);
        }
        return getBoardList(params, authKey);
    }

    /**
     * The request creates new board.
     * @param body request body.
     * @param authKey yougile key.
     * @return ID of the created Board.
     * @throws IOException then the json cannot be parsed correctly
     */
    public Id createBoard(@NonNull BoardCreateBody body, @NonNull AuthKey authKey) throws URISyntaxException, IOException {
        Response response = sendPostRequest(configureURI().build(), body, authKey);
        Content content = response.handleResponse(ResponseHandlerProvider::createdJsonHandler);
        return ContentHandler.handleId(content);
    }

    /**
     * The request creates new board.
     * The method uses {@link AuthKey} passed to service constructor on instantiation.
     * @param body request body.
     * @return ID of the created Board.
     * @throws IOException then the json cannot be parsed correctly
     */
    public Id createBoard(@NonNull BoardCreateBody body) throws URISyntaxException, IOException {
        if (authKey == null) {
            throw new NullPointerException(noAuthKeyMessage);
        }
        return createBoard(body, authKey);
    }

    /**
     * The request gets the board by ID.
     * @param boardId ID of the board.
     * @param authKey yougile key.
     * @return board, if it's available.
     * @throws IOException then the json cannot be parsed correctly
     */
    public Board getBoardById(@NonNull String boardId, @NonNull AuthKey authKey) throws URISyntaxException, IOException {
        Response response = sendGetRequest(configureURI(boardId).build(), authKey);
        Content content = response.handleResponse(ResponseHandlerProvider::okJsonHandler);
        return ContentHandler.handleBoard(content);
    }

    /**
     * The request gets the board by ID.
     * The method uses {@link AuthKey} passed to service constructor on instantiation.
     * @param boardId ID of the board.
     * @return board, if it's available.
     * @throws IOException then the json cannot be parsed correctly
     */
    public Board getBoardById(@NonNull String boardId) throws URISyntaxException, IOException {
        if (authKey == null) {
            throw new NullPointerException(noAuthKeyMessage);
        }
        return getBoardById(boardId, authKey);
    }

    /**
     * The request updates board by id.
     * @param boardId ID of the board to update.
     * @param body update request body with elements to update.
     * @param authkey yougile key.
     * @return ID of the updated Board.
     * @throws IOException then the json cannot be parsed correctly
     */
    public Id updateBoard(@NonNull String boardId, @NonNull BoardUpdateBody body, @NonNull AuthKey authkey) throws URISyntaxException, IOException {
        Response response = sendPutRequest(configureURI(boardId).build(), body, authKey);
        Content content = response.handleResponse(ResponseHandlerProvider::okJsonHandler);
        return ContentHandler.handleId(content);
    }

    /**
     * The request updates board by id.
     * The method uses {@link AuthKey} passed to service constructor on instantiation.
     * @param boardId ID of the board to update.
     * @param body update request body with elements to update.
     * @return ID of the updated board.
     * @throws IOException then the json cannot be parsed correctly
     */
    public Id updateBoard(@NonNull String boardId, @NonNull BoardUpdateBody body) throws URISyntaxException, IOException {
        if (authKey == null) {
            throw new NullPointerException(noAuthKeyMessage);
        }
        return updateBoard(boardId, body, authKey);
    }

    /**
     * The request updates board by the passed {@link Board}.
     * @param board board to update.
     * @param authKey yougile key.
     * @return ID of the update board.
     * @throws IOException then the json cannot be parsed correctly
     */
    public Id updateBoard(@NonNull Board board, @NonNull AuthKey authKey) throws URISyntaxException, IOException {
        BoardUpdateBody body = BoardUpdateBody.builder()
                .deleted(board.isDeleted())
                .title(board.getTitle())
                .projectId(board.getProjectId())
                .stickers(board.getStickers())
                .build();
        return updateBoard(board.getId(), body, authKey);
    }

    /**
     * The request updates board by the passed {@link Board}.
     * @param board board to update.
     * @return ID of the update board.
     * @throws IOException then the json cannot be parsed correctly
     */
    public Id updateBoard(@NonNull Board board) throws URISyntaxException, IOException {
        if (authKey == null) {
            throw new NullPointerException(noAuthKeyMessage);
        }
        return updateBoard(board, authKey);
    }
}
