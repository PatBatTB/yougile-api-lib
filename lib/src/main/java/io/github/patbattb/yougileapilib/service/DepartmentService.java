package io.github.patbattb.yougileapilib.service;


import io.github.patbattb.yougileapilib.domain.*;
import io.github.patbattb.yougileapilib.domain.body.DepartmentCreateBody;
import io.github.patbattb.yougileapilib.domain.body.DepartmentEditBody;
import io.github.patbattb.yougileapilib.http.ResponseHandlerProvider;
import lombok.NonNull;
import org.apache.http.client.fluent.Content;
import org.apache.http.client.fluent.Response;

import java.io.IOException;
import java.net.URISyntaxException;

public class DepartmentService extends AbstractRequestService {

    public DepartmentService() {
        this(null);
    }

    public DepartmentService(AuthKey authKey) {
        super("departments", authKey);
    }

    /**
     * @param params {@link QueryParams} Request parameters<p>
     *                                  Available parameter names:<ul>
     *                                  <li>{@code includeDeleted} - boolean
     *                                  <li>{@code limit} - number
     *                                  <li>{@code offset} - number
     *                                  <li>{@code parentId} - string
     *                                  <li>{@code title} - string
     *                                  </ul>
     * @param authKey {@link AuthKey} with your YouGile token.
     *
     * @return list of {@link Department}
     * @throws URISyntaxException
     * @throws IOException
     */
    public PagingContainer<Department> getDepartmentList(@NonNull QueryParams params,@NonNull AuthKey authKey) throws URISyntaxException, IOException {
        Response response = sendGetRequest(configureURI(params).build(), authKey);
        Content content = response.handleResponse(ResponseHandlerProvider::okJsonHandler);
        return ContentHandler.handleDepartmentList(content);
    }

    /**
     * @param params {@link QueryParams} Request parameters<p>
     *                                  Available parameter names:<ul>
     *                                  <li>{@code includeDeleted} - boolean
     *                                  <li>{@code limit} - number
     *                                  <li>{@code offset} - number
     *                                  <li>{@code parentId} - string
     *                                  <li>{@code title} - string
     *                                  </ul>
     *
     * @return list of {@link Department}
     * @throws URISyntaxException
     * @throws IOException
     */
    public PagingContainer<Department> getDepartmentList(@NonNull QueryParams params) throws URISyntaxException, IOException {
        if (authKey == null) {
            throw new NullPointerException(noAuthKeyMessage);
        }
        return getDepartmentList(params, authKey);
    }

    public Id createDepartment(@NonNull DepartmentCreateBody body,@NonNull AuthKey authKey) throws URISyntaxException, IOException {
        Response response = sendPostRequest(configureURI().build(), body, authKey);
        Content content = response.handleResponse(ResponseHandlerProvider::createdJsonHandler);
        return ContentHandler.handleId(content);
    }

    public Id createDepartment(@NonNull DepartmentCreateBody body) throws URISyntaxException, IOException {
        if (authKey == null) {
            throw new NullPointerException(noAuthKeyMessage);
        }
        return createDepartment(body, authKey);
    }

    public Department getDepartmentById(@NonNull String departmentId,@NonNull AuthKey authKey) throws URISyntaxException, IOException {
        Response response = sendGetRequest(configureURI(departmentId).build(), authKey);
        Content content = response.handleResponse(ResponseHandlerProvider::okJsonHandler);
        return ContentHandler.handleDepartment(content);
    }

    public Department getDepartmentById(@NonNull String departmentId) throws URISyntaxException, IOException {
        if (authKey == null) {
            throw new NullPointerException(noAuthKeyMessage);
        }
        return getDepartmentById(departmentId, authKey);
    }

    public Id editDepartment(@NonNull String departmentId,@NonNull DepartmentEditBody body,@NonNull AuthKey authKey) throws URISyntaxException, IOException {
        Response response = sendPutRequest(configureURI(departmentId).build(), body, authKey);
        Content content = response.handleResponse(ResponseHandlerProvider::okJsonHandler);
        return ContentHandler.handleId(content);
    }

    public Id editDepartment(@NonNull String departmentId,@NonNull DepartmentEditBody body) throws URISyntaxException, IOException {
        if (authKey == null) {
            throw new NullPointerException(noAuthKeyMessage);
        }
        return editDepartment(departmentId, body, authKey);
    }
}
