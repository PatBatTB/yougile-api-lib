package io.github.patbattb.yougileapilib.service;

import io.github.patbattb.yougileapilib.domain.*;
import io.github.patbattb.yougileapilib.domain.body.ProjectRoleBody;
import io.github.patbattb.yougileapilib.http.ResponseHandlerProvider;
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

    public PagingContainer<ProjectRole> getRoleList(String projectId, QueryParams params, AuthKey authKey) throws URISyntaxException, IOException {
        Response response = sendGetRequest(configureURI(params).setPath(getEndpoint(projectId)).build(), authKey);
        Content content = response.handleResponse(ResponseHandlerProvider::okJsonHandler);
        return ContentHandler.handleProjectRoleList(content);
    }

    public PagingContainer<ProjectRole> getRoleList(String projectId, QueryParams params) throws URISyntaxException, IOException {
        if (authKey == null) {
            throw new NullPointerException(noAuthKeyMessage);
        }
        return getRoleList(projectId, params, authKey);
    }

    public Id createRole(String projectId, ProjectRoleBody body, AuthKey authKey) throws URISyntaxException, IOException {
        Response response = sendPostRequest(configureURI().setPath(getEndpoint(projectId)).build(), body, authKey);
        Content content = response.handleResponse(ResponseHandlerProvider::createdJsonHandler);
        return ContentHandler.handleId(content);
    }

    public Id createRole(String projectId, ProjectRoleBody body) throws URISyntaxException, IOException {
        if (authKey == null) {
            throw new NullPointerException(noAuthKeyMessage);
        }
        return createRole(projectId, body, authKey);
    }

    public ProjectRole getRoleById(String projectId, String roleId, AuthKey authKey) throws URISyntaxException, IOException {
        Response response = sendGetRequest(configureURI().setPath(getEndpoint(projectId, roleId)).build(), authKey);
        Content content = response.handleResponse(ResponseHandlerProvider::okJsonHandler);
        return ContentHandler.handleProjectRole(content);
    }

    public ProjectRole getRoleById(String projectId, String roleId) throws URISyntaxException, IOException {
        if (authKey == null) {
            throw new IllegalArgumentException(noAuthKeyMessage);
        }
        return getRoleById(projectId, roleId, authKey);
    }

    private String getEndpoint(String projectId) {
        return "api-v2/projects/" + projectId + "/roles";
    }

    private String getEndpoint(String projectId, String roleId) {
        return getEndpoint(projectId) + "/" + roleId;
    }
}
