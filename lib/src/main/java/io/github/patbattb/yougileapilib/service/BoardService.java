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

public class BoardService extends AbstractRequestService {

    public BoardService() {
        this(null);
    }

    public BoardService(AuthKey authKey) {
        super("boards", authKey);
    }

    public PagingContainer<Board> getBoardList(@NonNull QueryParams params, @NonNull AuthKey authKey) throws URISyntaxException, IOException {
        Response response = sendGetRequest(configureURI(params).build(), authKey);
        Content content = response.handleResponse(ResponseHandlerProvider::okJsonHandler);
        return ContentHandler.handleBoardList(content);
    }

    public PagingContainer<Board> getBoardList(@NonNull QueryParams params) throws URISyntaxException, IOException {
        if (authKey == null) {
            throw new NullPointerException(noAuthKeyMessage);
        }
        return getBoardList(params, authKey);
    }

    public Id createBoard(@NonNull BoardCreateBody body, @NonNull AuthKey authKey) throws URISyntaxException, IOException {
        Response response = sendPostRequest(configureURI().build(), body, authKey);
        Content content = response.handleResponse(ResponseHandlerProvider::createdJsonHandler);
        return ContentHandler.handleId(content);
    }

    public Id createBoard(@NonNull BoardCreateBody body) throws URISyntaxException, IOException {
        if (authKey == null) {
            throw new NullPointerException(noAuthKeyMessage);
        }
        return createBoard(body, authKey);
    }

    public Board getBoardById(@NonNull String boardId, @NonNull AuthKey authKey) throws URISyntaxException, IOException {
        Response response = sendGetRequest(configureURI(boardId).build(), authKey);
        Content content = response.handleResponse(ResponseHandlerProvider::okJsonHandler);
        return ContentHandler.handleBoard(content);
    }

    public Board getBoardById(@NonNull String boardId) throws URISyntaxException, IOException {
        if (authKey == null) {
            throw new NullPointerException(noAuthKeyMessage);
        }
        return getBoardById(boardId, authKey);
    }

    public Id updateBoard(@NonNull String boardId, @NonNull BoardUpdateBody body, @NonNull AuthKey authkey) throws URISyntaxException, IOException {
        Response response = sendPutRequest(configureURI(boardId).build(), body, authKey);
        Content content = response.handleResponse(ResponseHandlerProvider::okJsonHandler);
        return ContentHandler.handleId(content);
    }

    public Id updateBoard(@NonNull String boardId, @NonNull BoardUpdateBody body) throws URISyntaxException, IOException {
        if (authKey == null) {
            throw new NullPointerException(noAuthKeyMessage);
        }
        return updateBoard(boardId, body, authKey);
    }

    public Id updateBoard(@NonNull Board board, @NonNull AuthKey authKey) throws URISyntaxException, IOException {
        BoardUpdateBody body = BoardUpdateBody.builder()
                .deleted(board.isDeleted())
                .title(board.getTitle())
                .projectId(board.getProjectId())
                .stickers(board.getStickers())
                .build();
        return updateBoard(board.getId(), body, authKey);
    }

    public Id updateBoard(@NonNull Board board) throws URISyntaxException, IOException {
        if (authKey == null) {
            throw new NullPointerException(noAuthKeyMessage);
        }
        return updateBoard(board, authKey);
    }
}
