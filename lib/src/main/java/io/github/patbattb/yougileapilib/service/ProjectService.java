package io.github.patbattb.yougileapilib.service;

import io.github.patbattb.yougileapilib.domain.*;
import io.github.patbattb.yougileapilib.domain.body.ProjectCreateBody;
import io.github.patbattb.yougileapilib.domain.body.ProjectUpdateBody;
import io.github.patbattb.yougileapilib.http.ResponseHandlerProvider;
import lombok.NonNull;
import org.apache.http.client.fluent.Content;
import org.apache.http.client.fluent.Response;

import java.io.IOException;
import java.net.URISyntaxException;

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
    public PagingContainer<Project> getProjectList(@NonNull QueryParams params, @NonNull AuthKey authKey) throws URISyntaxException, IOException {
        Response response = sendGetRequest(configureURI(params).build(), authKey);
        Content content = response.handleResponse(ResponseHandlerProvider::okJsonHandler);
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
    public PagingContainer<Project> getProjectList(@NonNull QueryParams params) throws URISyntaxException, IOException {
        if (authKey == null) {
            throw new NullPointerException(noAuthKeyMessage);
        }
        return getProjectList(params, authKey);
    }

    public Id createProject(@NonNull ProjectCreateBody body, @NonNull AuthKey authKey) throws URISyntaxException, IOException {
        Response response = sendPostRequest(configureURI().build(), body, authKey);
        Content content = response.handleResponse(ResponseHandlerProvider::createdJsonHandler);
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
        Content content = response.handleResponse(ResponseHandlerProvider::okJsonHandler);
        return ContentHandler.handleProject(content);
    }

    public Project getProjectById(@NonNull String projectId) throws URISyntaxException, IOException {
        if (authKey == null) {
            throw new NullPointerException(noAuthKeyMessage);
        }
        return getProjectById(projectId, authKey);
    }

    public Id updateProject(@NonNull String projectId, @NonNull ProjectUpdateBody body, @NonNull AuthKey authKey) throws URISyntaxException, IOException {
        Response response = sendPutRequest(configureURI(projectId).build(), body, authKey);
        Content content = response.handleResponse(ResponseHandlerProvider::okJsonHandler);
        return ContentHandler.handleId(content);
    }

    public Id updateProject(@NonNull String projectId, @NonNull ProjectUpdateBody body) throws URISyntaxException, IOException {
        if (authKey == null) {
            throw new NullPointerException(noAuthKeyMessage);
        }
        return updateProject(projectId, body, authKey);
    }

    public Id updateProject(@NonNull Project project, @NonNull AuthKey authKey) throws URISyntaxException, IOException {
        ProjectUpdateBody body = ProjectUpdateBody.builder()
                .deleted(project.isDeleted())
                .title(project.getTitle())
                .users(project.getUsers().toArray(UserRole[]::new))
                .build();
        return updateProject(project.getId(), body, authKey);
    }

    public Id updateProject(@NonNull Project project) throws URISyntaxException, IOException {
        if (authKey == null) {
            throw new NullPointerException(noAuthKeyMessage);
        }
        return updateProject(project, authKey);
    }
}
