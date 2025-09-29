package io.github.patbattb.yougileapilib.service;

import io.github.patbattb.yougileapilib.domain.*;
import io.github.patbattb.yougileapilib.domain.body.ProjectRoleCreateBody;
import io.github.patbattb.yougileapilib.domain.body.ProjectRoleUpdateBody;
import io.github.patbattb.yougileapilib.http.ResponseHandlerProvider;
import lombok.NonNull;
import org.apache.http.client.fluent.Content;
import org.apache.http.client.fluent.Response;

import java.io.IOException;
import java.net.URISyntaxException;

/**
 * The service for managing roles of projects.
 */
public class ProjectRoleService extends AbstractRequestService {

    /**
     * If the service constructs without {@link AuthKey}, key must be passed to each method as argument.
     */
    public ProjectRoleService() {
        this(null);
    }

    /**
     * If the service constructs with {@link AuthKey}, you can use methods without key in parameters.
     * The passed key in constructor will be used by default.
     * If you want to send request with separate key, but without new service creating,
     * you can also use methods with {@link AuthKey} in parameters.
     * @param authKey yougile key for using by default in the Service instance.
     */
    public ProjectRoleService(AuthKey authKey) {
        super("", authKey);
    }

    /**
     * The request gets the container with {@link ProjectRole} list by the project ID.
     * @param projectId ID of the project.
     * @param params {@link QueryParams} Request parameters<p>
     *                                  Available parameter names:<ul>
     *                                  <li> {@code limit} ({@code number}) - The number of items you want to receive. Maximum 1000.
     *                                  <li> {@code offset} ({@code number}) - The index of the first element.
     *                                  <li> {@code name} ({@code string}) - role name.
     *                                  </ul>
     * @param authKey yougile key.
     * @return the container with role list.
     * @throws IOException then the json cannot be parsed correctly
     */
    public PagingContainer<ProjectRole> getRoleList(@NonNull String projectId,@NonNull QueryParams params,@NonNull AuthKey authKey) throws URISyntaxException, IOException {
        Response response = sendGetRequest(configureURI(params).setPath(getEndpoint(projectId)).build(), authKey);
        Content content = response.handleResponse(ResponseHandlerProvider::okJsonHandler);
        return ContentHandler.handlePagingContent(content, ProjectRole.class);
    }

    /**
     * The request gets the container with {@link ProjectRole} list by the project ID.
     * The passed key in constructor will be used by default.
     * @param projectId ID of the project.
     * @param params {@link QueryParams} Request parameters<p>
     *                                  Available parameter names:<ul>
     *                                  <li>{@code limit} ({@code number}) - The number of items you want to receive. Maximum 1000.
     *                                  <li>{@code offset} ({@code number}) - The index of the first element.
     *                                  <li>{@code name} ({@code string}) - role name.
     *                                  </ul>
     * @return the container with role list.
     * @throws IOException then the json cannot be parsed correctly
     */
    public PagingContainer<ProjectRole> getRoleList(@NonNull String projectId,@NonNull QueryParams params) throws URISyntaxException, IOException {
        if (authKey == null) {
            throw new NullPointerException(noAuthKeyMessage);
        }
        return getRoleList(projectId, params, authKey);
    }

    /**
     * The request creates new role for the project.
     * @param projectId ID of the project.
     * @param body body with parameters for creating a project role.
     * @param authKey yougile key.
     * @return ID of the created role.
     * @throws IOException then the json cannot be parsed correctly
     */
    public Id createRole(@NonNull String projectId,@NonNull ProjectRoleCreateBody body,@NonNull AuthKey authKey) throws URISyntaxException, IOException {
        Response response = sendPostRequest(configureURI().setPath(getEndpoint(projectId)).build(), body, authKey);
        Content content = response.handleResponse(ResponseHandlerProvider::createdJsonHandler);
        return ContentHandler.handleEntity(content, Id.class);
    }

    /**
     * The request creates new role for the project.
     * The passed key in constructor will be used by default.
     * @param projectId ID of the project.
     * @param body body with parameters for creating a project role.
     * @return ID of the created role.
     * @throws IOException then the json cannot be parsed correctly
     */
    public Id createRole(@NonNull String projectId,@NonNull ProjectRoleCreateBody body) throws URISyntaxException, IOException {
        if (authKey == null) {
            throw new NullPointerException(noAuthKeyMessage);
        }
        return createRole(projectId, body, authKey);
    }

    /**
     * The request gets {@link ProjectRole} by ID.
     * @param projectId ID of the project.
     * @param roleId ID of the project role.
     * @param authKey yougile key.
     * @return project role, if it's available.
     * @throws IOException then the json cannot be parsed correctly
     */
    public ProjectRole getRoleById(@NonNull String projectId,@NonNull String roleId,@NonNull AuthKey authKey) throws URISyntaxException, IOException {
        Response response = sendGetRequest(configureURI().setPath(getEndpoint(projectId, roleId)).build(), authKey);
        Content content = response.handleResponse(ResponseHandlerProvider::okJsonHandler);
        return ContentHandler.handleEntity(content, ProjectRole.class);
    }

    /**
     * The request gets {@link ProjectRole} by ID.
     * The passed key in constructor will be used by default.
     * @param projectId ID of the project.
     * @param roleId ID of the project role.
     * @return project role, if it's available.
     * @throws IOException then the json cannot be parsed correctly
     */
    public ProjectRole getRoleById(@NonNull String projectId,@NonNull String roleId) throws URISyntaxException, IOException {
        if (authKey == null) {
            throw new IllegalArgumentException(noAuthKeyMessage);
        }
        return getRoleById(projectId, roleId, authKey);
    }

    /**
     * The request updates the project role.
     * @param projectId ID of the project.
     * @param roleId ID of the project role.
     * @param body update body with parameters to update.
     * @param authKey yougile key.
     * @return ID of the updated role.
     * @throws IOException then the json cannot be parsed correctly
     */
    public Id updateRole(@NonNull String projectId, @NonNull String roleId, @NonNull ProjectRoleUpdateBody body, @NonNull AuthKey authKey) throws URISyntaxException, IOException {
        Response response = sendPutRequest(configureURI().setPath(getEndpoint(projectId, roleId)).build(), body, authKey);
        Content content = response.handleResponse(ResponseHandlerProvider::okJsonHandler);
        return ContentHandler.handleEntity(content, Id.class);
    }

    /**
     * The request updates the project role.
     * The passed key in constructor will be used by default.
     * @param projectId ID of the project.
     * @param roleId ID of the project role.
     * @param body update body with parameters to update.
     * @return ID of the updated role.
     * @throws IOException then the json cannot be parsed correctly
     */
    public Id updateRole(@NonNull String projectId, @NonNull String roleId, @NonNull ProjectRoleUpdateBody body) throws URISyntaxException, IOException {
        if (authKey == null) {
            throw new NullPointerException(noAuthKeyMessage);
        }
        return updateRole(projectId, roleId, body, authKey);
    }

    /**
     * The request updates the project role by the passed {@link ProjectRole}.
     * @param projectId ID of the project contained project role.
     * @param role project role to update.
     * @param authKey yougile key.
     * @return ID of the updated role.
     * @throws IOException then the json cannot be parsed correctly
     */
    public Id updateRole(@NonNull String projectId, @NonNull ProjectRole role, @NonNull AuthKey authKey) throws URISyntaxException, IOException {
        ProjectRoleUpdateBody body = ProjectRoleUpdateBody.builder()
                .name(role.getName())
                .description(role.getDescription())
                .projectPermissions(role.getProjectPermissions())
                .build();
        return updateRole(projectId, role.getId(), body, authKey);
    }

    /**
     * The request updates the project role by the passed {@link ProjectRole}.
     * The passed key in constructor will be used by default.
     * @param projectId ID of the project contained project role.
     * @param role project role to update.
     * @return ID of the updated role.
     * @throws IOException then the json cannot be parsed correctly
     */
    public Id updateRole(@NonNull String projectId, @NonNull ProjectRole role) throws URISyntaxException, IOException {
        if (authKey == null) {
            throw new NullPointerException(noAuthKeyMessage);
        }
        return updateRole(projectId, role, authKey);
    }

    /**
     * The request deletes the project role.
     * @param projectId ID of the project contained project role.
     * @param roleId ID of the project role.
     * @param authKey yougile key.
     * @return ID of the deleted role.
     * @throws IOException then the json cannot be parsed correctly
     */
    public Id deleteRole(@NonNull String projectId,@NonNull String roleId,@NonNull AuthKey authKey) throws URISyntaxException, IOException {
        Response response = sendDeleteRequest(configureURI().setPath(getEndpoint(projectId, roleId)).build(), authKey);
        Content content = response.handleResponse(ResponseHandlerProvider::okJsonHandler);
        return ContentHandler.handleEntity(content, Id.class);
    }

    /**
     * The request deletes the project role.
     * The passed key in constructor will be used by default.
     * @param projectId ID of the project contained project role.
     * @param roleId ID of the project role.
     * @return ID of the deleted role.
     * @throws IOException then the json cannot be parsed correctly
     */
    public Id deleteRole(@NonNull String projectId,@NonNull String roleId) throws URISyntaxException, IOException {
        if (authKey == null) {
            throw new NullPointerException(noAuthKeyMessage);
        }
        return deleteRole(projectId, roleId, authKey);
    }

    private String getEndpoint(String projectId) {
        return "api-v2/projects/" + projectId + "/roles";
    }

    private String getEndpoint(String projectId, String roleId) {
        return getEndpoint(projectId) + "/" + roleId;
    }
}
