package io.github.patbattb.yougileapilib.service;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.json.JsonMapper;
import com.fasterxml.jackson.databind.node.ArrayNode;
import io.github.patbattb.yougileapilib.domain.AuthKey;
import io.github.patbattb.yougileapilib.domain.Id;
import io.github.patbattb.yougileapilib.domain.QueryParams;
import io.github.patbattb.yougileapilib.domain.User;
import io.github.patbattb.yougileapilib.domain.body.UserBody;
import io.github.patbattb.yougileapilib.http.YouGileResponseHandler;
import lombok.NonNull;
import org.apache.http.client.fluent.Content;
import org.apache.http.client.fluent.Response;

import java.io.IOException;
import java.net.URISyntaxException;
import java.util.ArrayList;
import java.util.List;

public class UserService extends AbstractRequestService {

    private final AuthKey authKey;

    public UserService(AuthKey authKey) {
        super("users");
        this.authKey = authKey;
    }

    public UserService() {
        this(null);
    }


    /**
     * @param authKey {@link AuthKey} with your YouGile token
     * @param params {@link QueryParams} Request parameters<p>
     *                                  Available parameter names:<ul>
     *                                  <li>{@code email} - string
     *                                  <li>{@code limit} - number
     *                                  <li>{@code offset} - number
     *                                  <li>{@code projectId} - string
     *                                  </ul>
     *
     * @return list of {@link User}
     * @throws URISyntaxException
     * @throws IOException
     */
    public List<User> getUserList(@NonNull QueryParams params, @NonNull AuthKey authKey) throws URISyntaxException, IOException {
        Response response = sendGetRequest(configureURI(params).build(), authKey);
        Content content = response.handleResponse(YouGileResponseHandler::getJsonOKHandler);
        return handleUserListContent(content);
    }

    /**
     * @param params {@link QueryParams} Request parameters<p>
     *                                  Available parameter names:<ul>
     *                                  <li>{@code email} - string
     *                                  <li>{@code limit} - number
     *                                  <li>{@code offset} - number
     *                                  <li>{@code projectId} - string
     *                                  </ul>
     *
     * @return list of {@link User}
     * @throws URISyntaxException
     * @throws IOException
     */
    public List<User> getUserList(@NonNull QueryParams params) throws URISyntaxException, IOException {
        if (this.authKey == null) {
            throw new NullPointerException(noAuthKeyMessage);
        }
        return getUserList(params, this.authKey);
    }

    public Id inviteToCompany(UserBody body, AuthKey authKey) throws URISyntaxException, IOException {
        Response response = sendPostRequest(configureURI().build(), body, authKey);
        Content content = response.handleResponse(YouGileResponseHandler::getJsonCreatedHandler);
        return handleIdContent(content);
    }

    public Id inviteToCompany(UserBody body) throws URISyntaxException, IOException {
        if (this.authKey == null) {
            throw new NullPointerException(noAuthKeyMessage);
        }
        return inviteToCompany(body, authKey);
    }

    private List<User> handleUserListContent(Content content) throws JsonProcessingException {
        JsonMapper mapper = new JsonMapper();
        List<User> userList = new ArrayList<>();
        JsonNode rootNode = mapper.readTree(content.asString());
        ArrayNode arrayNode = (ArrayNode) rootNode.get("content");
        for (JsonNode node: arrayNode) {
            userList.add(mapper.readValue(node.toString(), User.class));
        }
        return userList;
    }

    private Id handleIdContent(Content content) throws JsonProcessingException {
        JsonMapper mapper = new JsonMapper();
        JsonNode node = mapper.readTree(content.asString());
        return mapper.readValue(node.toString(), Id.class);
    }
}
