package io.github.patbattb.yougileapilib.service;

import io.github.patbattb.yougileapilib.domain.*;
import io.github.patbattb.yougileapilib.domain.body.ProjectCreateBody;
import io.github.patbattb.yougileapilib.domain.body.ProjectEditBody;
import io.github.patbattb.yougileapilib.http.ResponseHandlerProvider;
import lombok.NonNull;
import org.apache.http.client.fluent.Content;
import org.apache.http.client.fluent.Response;

import java.io.IOException;
import java.net.URISyntaxException;
import java.util.List;

public class ProjectService extends AbstractRequestService {

    public ProjectService() {
        this(null);
    }

    public ProjectService(AuthKey authKey) {
        super("projects", authKey);
    }

    /**
     * @param authKey {@link AuthKey} with your YouGile token
     * @param params {@link QueryParams} Request parameters<p>
     *                                  Available parameter names:<ul>
     *                                  <li>{@code includeDeleted} - boolean
     *                                  <li>{@code limit} - number
     *                                  <li>{@code offset} - number
     *                                  <li>{@code title} - string
     *                                  </ul>
     *
     * @return list of {@link User}
     * @throws URISyntaxException
     * @throws IOException
     */
    public List<Project> getProjectList(@NonNull QueryParams params, @NonNull AuthKey authKey) throws URISyntaxException, IOException {
        Response response = sendGetRequest(configureURI(params).build(), authKey);
        Content content = response.handleResponse(ResponseHandlerProvider::OKJsonHandler);
        return ContentHandler.handleProjectList(content);
    }

    /**
     * @param params {@link QueryParams} Request parameters<p>
     *                                  Available parameter names:<ul>
     *                                  <li>{@code includeDeleted} - boolean
     *                                  <li>{@code limit} - number
     *                                  <li>{@code offset} - number
     *                                  <li>{@code title} - string
     *                                  </ul>
     *
     * @return list of {@link User}
     * @throws URISyntaxException
     * @throws IOException
     */
    public List<Project> getProjectList(@NonNull QueryParams params) throws URISyntaxException, IOException {
        if (authKey == null) {
            throw new NullPointerException(noAuthKeyMessage);
        }
        return getProjectList(params, authKey);
    }

    public Id createProject(@NonNull ProjectCreateBody body, @NonNull AuthKey authKey) throws URISyntaxException, IOException {
        Response response = sendPostRequest(configureURI().build(), body, authKey);
        Content content = response.handleResponse(ResponseHandlerProvider::CreatedJsonHandler);
        return ContentHandler.handleId(content);
    }

    public Id createProject(@NonNull ProjectCreateBody body) throws URISyntaxException, IOException {
        if (authKey == null) {
            throw new NullPointerException(noAuthKeyMessage);
        }
        return createProject(body, authKey);
    }

    public Project getProjectById(@NonNull String projectId, @NonNull AuthKey authKey) throws URISyntaxException, IOException {
        Response response = sendGetRequest(configureURI(projectId).build(), authKey);
        Content content = response.handleResponse(ResponseHandlerProvider::OKJsonHandler);
        return ContentHandler.handleProject(content);
    }

    public Project getProjectById(@NonNull String projectId) throws URISyntaxException, IOException {
        if (authKey == null) {
            throw new NullPointerException(noAuthKeyMessage);
        }
        return getProjectById(projectId, authKey);
    }

    public Id editProject(@NonNull String projectId, @NonNull ProjectEditBody body, @NonNull AuthKey authKey) throws URISyntaxException, IOException {
        Response response = sendPutRequest(configureURI(projectId).build(), body, authKey);
        Content content = response.handleResponse(ResponseHandlerProvider::OKJsonHandler);
        return ContentHandler.handleId(content);
    }

    public Id editProject(@NonNull String projectId, @NonNull ProjectEditBody body) throws URISyntaxException, IOException {
        if (authKey == null) {
            throw new NullPointerException(noAuthKeyMessage);
        }
        return editProject(projectId, body, authKey);
    }
}
