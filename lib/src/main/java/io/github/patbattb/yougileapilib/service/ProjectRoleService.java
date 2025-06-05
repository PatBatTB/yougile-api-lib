package io.github.patbattb.yougileapilib.service;

import io.github.patbattb.yougileapilib.domain.*;
import io.github.patbattb.yougileapilib.domain.body.ProjectRoleCreateBody;
import io.github.patbattb.yougileapilib.domain.body.ProjectRoleEditBody;
import io.github.patbattb.yougileapilib.http.ResponseHandlerProvider;
import lombok.NonNull;
import org.apache.http.client.fluent.Content;
import org.apache.http.client.fluent.Response;

import java.io.IOException;
import java.net.URISyntaxException;

public class ProjectRoleService extends AbstractRequestService {

    public ProjectRoleService() {
        this(null);
    }

    public ProjectRoleService(AuthKey authKey) {
        super("", authKey);
    }

    public PagingContainer<ProjectRole> getRoleList(@NonNull String projectId,@NonNull QueryParams params,@NonNull AuthKey authKey) throws URISyntaxException, IOException {
        Response response = sendGetRequest(configureURI(params).setPath(getEndpoint(projectId)).build(), authKey);
        Content content = response.handleResponse(ResponseHandlerProvider::okJsonHandler);
        return ContentHandler.handleProjectRoleList(content);
    }

    public PagingContainer<ProjectRole> getRoleList(@NonNull String projectId,@NonNull QueryParams params) throws URISyntaxException, IOException {
        if (authKey == null) {
            throw new NullPointerException(noAuthKeyMessage);
        }
        return getRoleList(projectId, params, authKey);
    }

    public Id createRole(@NonNull String projectId,@NonNull ProjectRoleCreateBody body,@NonNull AuthKey authKey) throws URISyntaxException, IOException {
        Response response = sendPostRequest(configureURI().setPath(getEndpoint(projectId)).build(), body, authKey);
        Content content = response.handleResponse(ResponseHandlerProvider::createdJsonHandler);
        return ContentHandler.handleId(content);
    }

    public Id createRole(@NonNull String projectId,@NonNull ProjectRoleCreateBody body) throws URISyntaxException, IOException {
        if (authKey == null) {
            throw new NullPointerException(noAuthKeyMessage);
        }
        return createRole(projectId, body, authKey);
    }

    public ProjectRole getRoleById(@NonNull String projectId,@NonNull String roleId,@NonNull AuthKey authKey) throws URISyntaxException, IOException {
        Response response = sendGetRequest(configureURI().setPath(getEndpoint(projectId, roleId)).build(), authKey);
        Content content = response.handleResponse(ResponseHandlerProvider::okJsonHandler);
        return ContentHandler.handleProjectRole(content);
    }

    public ProjectRole getRoleById(@NonNull String projectId,@NonNull String roleId) throws URISyntaxException, IOException {
        if (authKey == null) {
            throw new IllegalArgumentException(noAuthKeyMessage);
        }
        return getRoleById(projectId, roleId, authKey);
    }

    public Id editRole(@NonNull String projectId,@NonNull String roleId,@NonNull ProjectRoleEditBody body,@NonNull AuthKey authKey) throws URISyntaxException, IOException {
        Response response = sendPutRequest(configureURI().setPath(getEndpoint(projectId, roleId)).build(), body, authKey);
        Content content = response.handleResponse(ResponseHandlerProvider::okJsonHandler);
        return ContentHandler.handleId(content);
    }

    public Id editRole(@NonNull String projectId,@NonNull String roleId,@NonNull ProjectRoleEditBody body) throws URISyntaxException, IOException {
        if (authKey == null) {
            throw new NullPointerException(noAuthKeyMessage);
        }
        return editRole(projectId, roleId, body, authKey);
    }

    public Id deleteRole(@NonNull String projectId,@NonNull String roleId,@NonNull AuthKey authKey) throws URISyntaxException, IOException {
        Response response = sendDeleteRequest(configureURI().setPath(getEndpoint(projectId, roleId)).build(), authKey);
        Content content = response.handleResponse(ResponseHandlerProvider::okJsonHandler);
        return ContentHandler.handleId(content);
    }

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
