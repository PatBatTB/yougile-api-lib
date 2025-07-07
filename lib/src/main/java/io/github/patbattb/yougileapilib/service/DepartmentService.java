package io.github.patbattb.yougileapilib.service;


import io.github.patbattb.yougileapilib.domain.*;
import io.github.patbattb.yougileapilib.domain.body.DepartmentCreateBody;
import io.github.patbattb.yougileapilib.domain.body.DepartmentUpdateBody;
import io.github.patbattb.yougileapilib.http.ResponseHandlerProvider;
import lombok.NonNull;
import org.apache.http.client.fluent.Content;
import org.apache.http.client.fluent.Response;

import java.io.IOException;
import java.net.URISyntaxException;

/**
 * The service for managing of departments.
 */
public class DepartmentService extends AbstractRequestService {

    /**
     * If the service constructs without {@link AuthKey}, key must be passed to each method as argument.
     */
    public DepartmentService() {
        this(null);
    }

    /**
     * If the service constructs with {@link AuthKey}, you can use methods without key in parameters.
     * The passed key in constructor will be used by default.
     * If you want to send request with separate key, but without new service creating,
     * you can also use methods with {@link AuthKey} in parameters.
     * @param authKey yougile key for using by default in the Service instance.
     */
    public DepartmentService(AuthKey authKey) {
        super("departments", authKey);
    }

    /**
     * The request gets container with {@link Department} list
     * @param params {@link QueryParams} Request parameters<p>
     *                                  Available parameter names:<ul>
     *                                  <li>{@code includeDeleted} ({@code boolean}) - By default,
     *                                  if an object has been marked as deleted, it will not be found.
     *                                  Set true so that deleted objects are returned.
     *                                  <li>{@code limit} ({@code number}) - The number of items you want to receive. Maximum 1000.
     *                                  <li>{@code offset} ({@code number}) - The index of the first element.
     *                                  <li>{@code parentId} ({@code String}) - ID of the parent department.
     *                                  <li>{@code title} ({@code String}) - Department title.
     *                                  </ul>
     * @param authKey {@link AuthKey} with your YouGile token.
     *
     * @return container with {@link Department} list.
     * @throws IOException then the json cannot be parsed correctly.
     */
    public PagingContainer<Department> getDepartmentList(@NonNull QueryParams params,@NonNull AuthKey authKey) throws URISyntaxException, IOException {
        Response response = sendGetRequest(configureURI(params).build(), authKey);
        Content content = response.handleResponse(ResponseHandlerProvider::okJsonHandler);
        return ContentHandler.handleDepartmentList(content);
    }

    /**
     * The request gets container with {@link Department} list
     * The passed key in constructor will be used by default.
     * @param params {@link QueryParams} Request parameters<p>
     *                                  Available parameter names:<ul>
     *                                  <li>{@code includeDeleted} ({@code boolean}) - By default,
     *                                  if an object has been marked as deleted, it will not be found.
     *                                  Set true so that deleted objects are returned.
     *                                  <li>{@code limit} ({@code number}) - The number of items you want to receive. Maximum 1000.
     *                                  <li>{@code offset} ({@code number}) - The index of the first element.
     *                                  <li>{@code parentId} ({@code String}) - ID of the parent department.
     *                                  <li>{@code title} ({@code String}) - Department title.
     *                                  </ul>
     *
     * @return container with {@link Department} list.
     * @throws IOException then the json cannot be parsed correctly.
     */
    public PagingContainer<Department> getDepartmentList(@NonNull QueryParams params) throws URISyntaxException, IOException {
        if (authKey == null) {
            throw new NullPointerException(noAuthKeyMessage);
        }
        return getDepartmentList(params, authKey);
    }

    /**
     * The request creates new department.
     * @param body - body with parameters for creating a department.
     * @param authKey yougile key.
     * @return ID of the created department.
     * @throws IOException then the json cannot be parsed correctly.
     */
    public Id createDepartment(@NonNull DepartmentCreateBody body,@NonNull AuthKey authKey) throws URISyntaxException, IOException {
        Response response = sendPostRequest(configureURI().build(), body, authKey);
        Content content = response.handleResponse(ResponseHandlerProvider::createdJsonHandler);
        return ContentHandler.handleId(content);
    }

    /**
     * The request creates new department.
     * The passed key in constructor will be used by default.
     * @param body - body with parameters for creating a department.
     * @return ID of the created department.
     * @throws IOException then the json cannot be parsed correctly.
     */
    public Id createDepartment(@NonNull DepartmentCreateBody body) throws URISyntaxException, IOException {
        if (authKey == null) {
            throw new NullPointerException(noAuthKeyMessage);
        }
        return createDepartment(body, authKey);
    }

    /**
     * The request gets {@link Department} by ID.
     * @param departmentId ID of the department.
     * @param authKey yougile key.
     * @return the department, if it's available.
     * @throws IOException then the json cannot be parsed correctly.
     */
    public Department getDepartmentById(@NonNull String departmentId,@NonNull AuthKey authKey) throws URISyntaxException, IOException {
        Response response = sendGetRequest(configureURI(departmentId).build(), authKey);
        Content content = response.handleResponse(ResponseHandlerProvider::okJsonHandler);
        return ContentHandler.handleDepartment(content);
    }

    /**
     * The request gets {@link Department} by ID.
     * The passed key in constructor will be used by default.
     * @param departmentId ID of the department.
     * @return the department, if it's available.
     * @throws IOException then the json cannot be parsed correctly.
     */
    public Department getDepartmentById(@NonNull String departmentId) throws URISyntaxException, IOException {
        if (authKey == null) {
            throw new NullPointerException(noAuthKeyMessage);
        }
        return getDepartmentById(departmentId, authKey);
    }

    /**
     * The request updates department by ID.
     * The method requires update body with parameters to updates.
     * @param departmentId ID of the updating department.
     * @param body body with parameters for updating a department.
     * @param authKey yougile key.
     * @return ID of the updated department.
     * @throws IOException then the json cannot be parsed correctly.
     */
    public Id updateDepartment(@NonNull String departmentId, @NonNull DepartmentUpdateBody body, @NonNull AuthKey authKey) throws URISyntaxException, IOException {
        Response response = sendPutRequest(configureURI(departmentId).build(), body, authKey);
        Content content = response.handleResponse(ResponseHandlerProvider::okJsonHandler);
        return ContentHandler.handleId(content);
    }

    /**
     * The request updates department by ID.
     * The method requires update body with parameters to updates.
     * The passed key in constructor will be used by default.
     * @param departmentId ID of the updating department.
     * @param body body with parameters for updating a department.
     * @return ID of the updated department.
     * @throws IOException then the json cannot be parsed correctly.
     */
    public Id updateDepartment(@NonNull String departmentId, @NonNull DepartmentUpdateBody body) throws URISyntaxException, IOException {
        if (authKey == null) {
            throw new NullPointerException(noAuthKeyMessage);
        }
        return updateDepartment(departmentId, body, authKey);
    }

    /**
     * The request updates department by the passed {@link Department}.
     * @param department department to update.
     * @param authkey yougile key.
     * @return ID of the updated department.
     * @throws IOException then the json cannot be parsed correctly.
     */
    public Id updateDepartment(@NonNull Department department, @NonNull AuthKey authkey) throws URISyntaxException, IOException {
        DepartmentUpdateBody body = DepartmentUpdateBody.builder()
                .deleted(department.isDeleted())
                .title(department.getTitle())
                .parentId(department.getParentId())
                .users(department.getUsers().toArray(DepartmentUser[]::new))
                .build();
        return updateDepartment(department.getId(), body, authKey);
    }

    /**
     * The request updates department by the passed {@link Department}.
     * The passed key in constructor will be used by default.
     * @param department department to update.
     * @return ID of the updated department.
     * @throws IOException then the json cannot be parsed correctly.
     */
    public Id updateDepartment(@NonNull Department department) throws URISyntaxException, IOException {
        if (authKey == null) {
            throw new NullPointerException(noAuthKeyMessage);
        }
        return updateDepartment(department, authKey);
    }
}
