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

/**
 * The service for managing projects.
 */
public class ProjectService extends AbstractRequestService {

    /**
     * If the service constructs without {@link AuthKey}, key must be passed to each method as argument.
     */
    public ProjectService() {
        this(null);
    }

    /**
     * If the service constructs with {@link AuthKey}, you can use methods without key in parameters.
     * The passed key in constructor will be used by default.
     * If you want to send request with separate key, but without new service creating,
     * you can also use methods with {@link AuthKey} in parameters.
     * @param authKey yougile key for using by default in the Service instance.
     */
    public ProjectService(AuthKey authKey) {
        super("projects", authKey);
    }

    /**
     * The request gets the container with {@link Project} list.
     * @param params {@link QueryParams} Request parameters<p>
     *                                  Available parameter names:<ul>
     *                                  <li>{@code includeDeleted} ({@code boolean}) - By default,
     *                                   if an object has been marked as deleted, it will not be found.
     *                                   Set true so that deleted objects are returned.
     *                                  <li>{@code limit} ({@code number}) - The number of items you want to receive. Maximum 1000.
     *                                  <li>{@code offset} ({@code number}) - The index of the first element.
     *                                  <li>{@code title} ({@code string}) - Project title.
     *                                  </ul>
     * @param authKey {@link AuthKey} with your YouGile token
     * @return container with {@link Project} list
     * @throws IOException then the json cannot be parsed correctly.
     */
    public PagingContainer<Project> getProjectList(@NonNull QueryParams params, @NonNull AuthKey authKey) throws URISyntaxException, IOException {
        Response response = sendGetRequest(configureURI(params).build(), authKey);
        Content content = response.handleResponse(ResponseHandlerProvider::okJsonHandler);
        return ContentHandler.handlePagingContent(content, Project.class);
    }

    /**
     * The request gets the container with {@link Project} list.
     * The passed key in constructor will be used by default.
     * @param params {@link QueryParams} Request parameters<p>
     *                                  Available parameter names:<ul>
     *                                  <li>{@code includeDeleted} ({@code boolean}) - By default,
     *                                   if an object has been marked as deleted, it will not be found.
     *                                   Set true so that deleted objects are returned.
     *                                  <li>{@code limit} ({@code number}) - The number of items you want to receive. Maximum 1000.
     *                                  <li>{@code offset} ({@code number}) - The index of the first element.
     *                                  <li>{@code title} ({@code String}) - Project title.
     *                                  </ul>
     * @return container with {@link Project} list
     * @throws IOException then the json cannot be parsed correctly.
     */
    public PagingContainer<Project> getProjectList(@NonNull QueryParams params) throws URISyntaxException, IOException {
        if (authKey == null) {
            throw new NullPointerException(noAuthKeyMessage);
        }
        return getProjectList(params, authKey);
    }

    /**
     * The request creates new project.
     * @param body body contained parameters of the creating project.
     * @param authKey yougile key.
     * @return ID of the created project.
     * @throws IOException then the json cannot be parsed correctly.
     */
    public Id createProject(@NonNull ProjectCreateBody body, @NonNull AuthKey authKey) throws URISyntaxException, IOException {
        Response response = sendPostRequest(configureURI().build(), body, authKey);
        Content content = response.handleResponse(ResponseHandlerProvider::createdJsonHandler);
        return ContentHandler.handleEntity(content, Id.class);
    }

    /**
     * The request creates new project.
     * The passed key in constructor will be used by default.
     * @param body body contained parameters of the creating project.
     * @return ID of the created project.
     * @throws IOException then the json cannot be parsed correctly.
     */
    public Id createProject(@NonNull ProjectCreateBody body) throws URISyntaxException, IOException {
        if (authKey == null) {
            throw new NullPointerException(noAuthKeyMessage);
        }
        return createProject(body, authKey);
    }

    /**
     * The request gets {@link Project} by ID.
     * @param projectId id of the project.
     * @param authKey yougile key.
     * @return project entity, if it's available.
     * @throws IOException then the json cannot be parsed correctly.
     */
    public Project getProjectById(@NonNull String projectId, @NonNull AuthKey authKey) throws URISyntaxException, IOException {
        Response response = sendGetRequest(configureURI(projectId).build(), authKey);
        Content content = response.handleResponse(ResponseHandlerProvider::okJsonHandler);
        return ContentHandler.handleEntity(content, Project.class);
    }

    /**
     * The request gets {@link Project} by ID.
     * The passed key in constructor will be used by default.
     * @param projectId id of the project.
     * @return project entity, if it's available.
     * @throws IOException then the json cannot be parsed correctly.
     */
    public Project getProjectById(@NonNull String projectId) throws URISyntaxException, IOException {
        if (authKey == null) {
            throw new NullPointerException(noAuthKeyMessage);
        }
        return getProjectById(projectId, authKey);
    }

    /**
     * The request updates project by ID.
     * @param projectId ID of the project to update
     * @param body body with project parameters to update.
     * @param authKey yougile key.
     * @return ID of the updated project.
     * @throws IOException then the json cannot be parsed correctly.
     */
    public Id updateProject(@NonNull String projectId, @NonNull ProjectUpdateBody body, @NonNull AuthKey authKey) throws URISyntaxException, IOException {
        Response response = sendPutRequest(configureURI(projectId).build(), body, authKey);
        Content content = response.handleResponse(ResponseHandlerProvider::okJsonHandler);
        return ContentHandler.handleEntity(content, Id.class);
    }

    /**
     * The request updates project by ID.
     * The passed key in constructor will be used by default.
     * @param projectId ID of the project to update
     * @param body body with project parameters to update.
     * @return ID of the updated project.
     * @throws IOException then the json cannot be parsed correctly.
     */
    public Id updateProject(@NonNull String projectId, @NonNull ProjectUpdateBody body) throws URISyntaxException, IOException {
        if (authKey == null) {
            throw new NullPointerException(noAuthKeyMessage);
        }
        return updateProject(projectId, body, authKey);
    }

    /**
     * The request updates project by passed instance of {@link Project}.
     * @param project project instance to update.
     * @param authKey yougile key.
     * @return ID of the updated project.
     * @throws IOException then the json cannot be parsed correctly.
     */
    public Id updateProject(@NonNull Project project, @NonNull AuthKey authKey) throws URISyntaxException, IOException {
        ProjectUpdateBody body = ProjectUpdateBody.builder()
                .deleted(project.isDeleted())
                .title(project.getTitle())
                .users(project.getUsers().toArray(ProjectUser[]::new))
                .build();
        return updateProject(project.getId(), body, authKey);
    }

    /**
     * The request updates project by passed instance of {@link Project}.
     * The passed key in constructor will be used by default.
     * @param project project instance to update.
     * @return ID of the updated project.
     * @throws IOException then the json cannot be parsed correctly.
     */
    public Id updateProject(@NonNull Project project) throws URISyntaxException, IOException {
        if (authKey == null) {
            throw new NullPointerException(noAuthKeyMessage);
        }
        return updateProject(project, authKey);
    }
}
