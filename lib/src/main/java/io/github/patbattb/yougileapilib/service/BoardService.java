package io.github.patbattb.yougileapilib.service;

import io.github.patbattb.yougileapilib.domain.AuthKey;
import io.github.patbattb.yougileapilib.domain.Board;
import io.github.patbattb.yougileapilib.domain.PagingContainer;
import io.github.patbattb.yougileapilib.domain.QueryParams;
import io.github.patbattb.yougileapilib.http.ResponseHandlerProvider;
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

    public PagingContainer<Board> getBoardList(QueryParams params, AuthKey authKey) throws URISyntaxException, IOException {
        Response response = sendGetRequest(configureURI(params).build(), authKey);
        Content content = response.handleResponse(ResponseHandlerProvider::okJsonHandler);
        return ContentHandler.handleBoardList(content);
    }

    public PagingContainer<Board> getBoardList(QueryParams params) throws URISyntaxException, IOException {
        if (authKey == null) {
            throw new NullPointerException(noAuthKeyMessage);
        }
        return getBoardList(params, authKey);
    }
}
