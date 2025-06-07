package io.github.patbattb.yougileapilib.service;

import io.github.patbattb.yougileapilib.domain.*;
import io.github.patbattb.yougileapilib.domain.body.ChatSubscribersEditBody;
import io.github.patbattb.yougileapilib.domain.body.TaskCreateBody;
import io.github.patbattb.yougileapilib.domain.body.TaskEditBody;
import io.github.patbattb.yougileapilib.http.ResponseHandlerProvider;
import org.apache.http.client.fluent.Content;
import org.apache.http.client.fluent.Response;

import java.io.IOException;
import java.net.URISyntaxException;
import java.util.List;

public class TaskService extends AbstractRequestService {

    private final String taskListEndpoint;

    public TaskService() {
        this(null);
    }

    public TaskService(AuthKey authKey) {
        super("tasks", authKey);
        taskListEndpoint = "api-v2/task-list";
    }

    /**
     * @param params {@link QueryParams} Request parameters<p>
     *                                  Available parameter names:<ul>
     *                                  <li/>{@code assignedTo} (string) - Performer IDs separated by commas
     *                                  <li/>{@code columnId} (string) - ID of column (s? separated by commas)
     *                                  <li>{@code includeDeleted} (boolean) - Set to {@code true} so that deleted objects are returned.
     *                                  <li>{@code limit} (number) - The number of elements you want to get. Maximum 1000.
     *                                  <li>{@code offset} (number) - Index of the first page element
     *                                  <li>{@code title} (string) - Task title
     *                                  </ul>
     * @param authKey {@link AuthKey} with your YouGile token
     *
     * @return list of {@link Task}
     * @throws URISyntaxException
     * @throws IOException
     */
    public PagingContainer<Task> getTaskList(QueryParams params, AuthKey authKey) throws URISyntaxException, IOException {
        Response response = sendGetRequest(configureURI(params).setPath(taskListEndpoint).build(), authKey);
        Content content = response.handleResponse(ResponseHandlerProvider::okJsonHandler);
        return ContentHandler.handleTaskList(content);
    }

    /**
     * @param params {@link QueryParams} Request parameters<p>
     *                                  Available parameter names:<ul>
     *                                  <li/>{@code assignedTo} (string) - Performer IDs separated by commas
     *                                  <li/>{@code columnId} (string) - ID of column (s? separated by commas)
     *                                  <li>{@code includeDeleted} (boolean) - Set to {@code true} so that deleted objects are returned.
     *                                  <li>{@code limit} (number) - The number of elements you want to get. Maximum 1000.
     *                                  <li>{@code offset} (number) - Index of the first page element
     *                                  <li>{@code title} (string) - Task title
     *                                  </ul>
     *
     * @return list of {@link Task}
     * @throws URISyntaxException
     * @throws IOException
     */
    public PagingContainer<Task> getTaskList(QueryParams params) throws URISyntaxException, IOException {
        if (authKey == null) {
            throw new NullPointerException(noAuthKeyMessage);
        }
        return getTaskList(params, authKey);
    }

    public Id createTask(TaskCreateBody body, AuthKey authKey) throws URISyntaxException, IOException {
        Response response = sendPostRequest(configureURI().build(), body, authKey);
        Content content = response.handleResponse(ResponseHandlerProvider::createdJsonHandler);
        return ContentHandler.handleId(content);
    }

    public Id createTask(TaskCreateBody body) throws URISyntaxException, IOException {
        if (authKey == null) {
            throw new NullPointerException(noAuthKeyMessage);
        }
        return createTask(body, authKey);
    }

    public Task getTaskById(String taskId, AuthKey authKey) throws URISyntaxException, IOException {
        Response response = sendGetRequest(configureURI(taskId).build(), authKey);
        Content content = response.handleResponse(ResponseHandlerProvider::okJsonHandler);
        return ContentHandler.handleTask(content);
    }

    public Task getTaskById(String taskId) throws URISyntaxException, IOException {
        if (authKey == null) {
            throw new NullPointerException(noAuthKeyMessage);
        }
        return getTaskById(taskId, authKey);
    }

    public Id editTask(String taskId, TaskEditBody body, AuthKey authKey) throws URISyntaxException, IOException {
        Response response = sendPutRequest(configureURI(taskId).build(), body, authKey);
        Content content = response.handleResponse(ResponseHandlerProvider::okJsonHandler);
        return ContentHandler.handleId(content);
    }

    public Id editTask(String taskId, TaskEditBody body) throws URISyntaxException, IOException {
        if (authKey == null) {
            throw new NullPointerException(noAuthKeyMessage);
        }
        return editTask(taskId, body, authKey);
    }

    public List<Id> getChatSubscribers(String taskId, AuthKey authKey) throws URISyntaxException, IOException {
        Response response = sendGetRequest(configureURI().setPath(getChatSubscribersEndpoint(taskId)).build(), authKey);
        Content content = response.handleResponse(ResponseHandlerProvider::okJsonHandler);
        return ContentHandler.handleIdList(content);
    }

    public List<Id> getChatSubscribers(String taskId) throws URISyntaxException, IOException {
        if (authKey == null) {
            throw new NullPointerException(noAuthKeyMessage);
        }
        return getChatSubscribers(taskId, authKey);
    }

    public Id editChatSubscribers(String taskId, ChatSubscribersEditBody body, AuthKey authKey) throws URISyntaxException, IOException {
        Response response = sendPutRequest(configureURI().setPath(getChatSubscribersEndpoint(taskId)).build(), body, authKey);
        Content content = response.handleResponse(ResponseHandlerProvider::okJsonHandler);
        return ContentHandler.handleId(content);
    }

    public Id editChatSubscribers(String taskId, ChatSubscribersEditBody body) throws URISyntaxException, IOException {
        if (authKey == null) {
            throw new NullPointerException(noAuthKeyMessage);
        }
        return editChatSubscribers(taskId, body, authKey);
    }

    private String getChatSubscribersEndpoint(String taskId) {
        return "api-v2/tasks/" + taskId + "/chat-subscribers";
    }
}
