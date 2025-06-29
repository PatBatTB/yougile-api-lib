package io.github.patbattb.yougileapilib.service;

import io.github.patbattb.yougileapilib.domain.*;
import io.github.patbattb.yougileapilib.domain.body.*;
import io.github.patbattb.yougileapilib.http.ResponseHandlerProvider;
import lombok.NonNull;
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
     *                                  <li>{@code assignedTo} (string) - Performer IDs separated by commas
     *                                  <li>{@code columnId} (string) - ID of column (s? separated by commas)
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
    public PagingContainer<Task> getTaskList(@NonNull QueryParams params, @NonNull AuthKey authKey) throws URISyntaxException, IOException {
        Response response = sendGetRequest(configureURI(params).setPath(taskListEndpoint).build(), authKey);
        Content content = response.handleResponse(ResponseHandlerProvider::okJsonHandler);
        return ContentHandler.handleTaskList(content);
    }

    /**
     * @param params {@link QueryParams} Request parameters<p>
     *                                  Available parameter names:<ul>
     *                                  <li>{@code assignedTo} (string) - Performer IDs separated by commas
     *                                  <li>{@code columnId} (string) - ID of column (s? separated by commas)
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
    public PagingContainer<Task> getTaskList(@NonNull QueryParams params) throws URISyntaxException, IOException {
        if (authKey == null) {
            throw new NullPointerException(noAuthKeyMessage);
        }
        return getTaskList(params, authKey);
    }

    public Id createTask(@NonNull TaskCreateBody body, @NonNull AuthKey authKey) throws URISyntaxException, IOException {
        Response response = sendPostRequest(configureURI().build(), body, authKey);
        Content content = response.handleResponse(ResponseHandlerProvider::createdJsonHandler);
        return ContentHandler.handleId(content);
    }

    public Id createTask(@NonNull TaskCreateBody body) throws URISyntaxException, IOException {
        if (authKey == null) {
            throw new NullPointerException(noAuthKeyMessage);
        }
        return createTask(body, authKey);
    }

    public Task getTaskById(@NonNull String taskId, @NonNull AuthKey authKey) throws URISyntaxException, IOException {
        Response response = sendGetRequest(configureURI(taskId).build(), authKey);
        Content content = response.handleResponse(ResponseHandlerProvider::okJsonHandler);
        return ContentHandler.handleTask(content);
    }

    public Task getTaskById(@NonNull String taskId) throws URISyntaxException, IOException {
        if (authKey == null) {
            throw new NullPointerException(noAuthKeyMessage);
        }
        return getTaskById(taskId, authKey);
    }

    public Id updateTask(@NonNull String taskId, @NonNull TaskUpdateBody body, @NonNull AuthKey authKey) throws URISyntaxException, IOException {
        Response response = sendPutRequest(configureURI(taskId).build(), body, authKey);
        Content content = response.handleResponse(ResponseHandlerProvider::okJsonHandler);
        return ContentHandler.handleId(content);
    }

    public Id updateTask(@NonNull String taskId, @NonNull TaskUpdateBody body) throws URISyntaxException, IOException {
        if (authKey == null) {
            throw new NullPointerException(noAuthKeyMessage);
        }
        return updateTask(taskId, body, authKey);
    }

    public Id updateTask(@NonNull Task task, @NonNull AuthKey authKey) throws URISyntaxException, IOException {
        TaskUpdateBody body = TaskUpdateBody.builder()
                .deleted(task.isDeleted())
                .title(task.getTitle())
                .columnId(task.getColumnId())
                .description(task.getDescription())
                .archived(task.isArchived())
                .completed(task.isCompleted())
                .subtasks(task.getSubtasks().toArray(String[]::new))
                .assigned(task.getAssigned().toArray(String[]::new))
                .deadline(getUpdateBody(task.getDeadline()))
                .timeTracking(getUpdateBody(task.getTimeTracking()))
                .checklists(task.getChecklists().toArray(Checklist[]::new))
                //.stickers(task.getStickers())
                .color(task.getColor())
                .idTaskCommon(task.getIdTaskCommon())
                .idTaskProject(task.getIdTaskProject())
                .timer(getUpdateBody(task.getTimer()))
                .stopwatch(getUpdateBody(task.getStopwatch()))
                .build();
        return updateTask(task.getId(), body, authKey);
    }

    public Id updateTask(@NonNull Task task) throws URISyntaxException, IOException {
        if (authKey == null) {
            throw new NullPointerException(noAuthKeyMessage);
        }
        return updateTask(task, authKey);
    }

    public List<Id> getChatSubscribers(@NonNull String taskId, @NonNull AuthKey authKey) throws URISyntaxException, IOException {
        Response response = sendGetRequest(configureURI().setPath(getChatSubscribersEndpoint(taskId)).build(), authKey);
        Content content = response.handleResponse(ResponseHandlerProvider::okJsonHandler);
        return ContentHandler.handleIdList(content);
    }

    public List<Id> getChatSubscribers(@NonNull String taskId) throws URISyntaxException, IOException {
        if (authKey == null) {
            throw new NullPointerException(noAuthKeyMessage);
        }
        return getChatSubscribers(taskId, authKey);
    }

    public Id updateChatSubscribers(@NonNull String taskId, @NonNull ChatSubscribersUpdateBody body, @NonNull AuthKey authKey) throws URISyntaxException, IOException {
        Response response = sendPutRequest(configureURI().setPath(getChatSubscribersEndpoint(taskId)).build(), body, authKey);
        Content content = response.handleResponse(ResponseHandlerProvider::okJsonHandler);
        return ContentHandler.handleId(content);
    }

    public Id updateChatSubscribers(@NonNull String taskId, @NonNull ChatSubscribersUpdateBody body) throws URISyntaxException, IOException {
        if (authKey == null) {
            throw new NullPointerException(noAuthKeyMessage);
        }
        return updateChatSubscribers(taskId, body, authKey);
    }

    private String getChatSubscribersEndpoint(String taskId) {
        return "api-v2/tasks/" + taskId + "/chat-subscribers";
    }

    private DeadlineUpdateBody getUpdateBody(Deadline deadline) {
        if (deadline == null) {
            return DeadlineUpdateBody.builder().deleted(true).build();
        }
        return DeadlineUpdateBody.builder()
                .deadline(deadline.getDeadline())
                .startDate(deadline.getStartDate())
                .withTime(deadline.getWithTime())
                .build();
    }

    private TimeTrackingUpdateBody getUpdateBody(TimeTracking timeTracking) {
        if (timeTracking == null) {
            return TimeTrackingUpdateBody.builder().deleted(true).build();
        }
        return TimeTrackingUpdateBody.builder()
                .plan(timeTracking.getPlan())
                .work(timeTracking.getWork())
                .build();
    }

    private TimerUpdateBody getUpdateBody(Timer timer) {
        if (timer == null) {
            return TimerUpdateBody.builder().deleted(true).build();
        }
        return TimerUpdateBody.builder()
                .seconds(timer.getSeconds())
                .running(timer.isRunning())
                .build();
    }

    private StopwatchUpdateBody getUpdateBody(Stopwatch stopwatch) {
        if (stopwatch == null) {
            return StopwatchUpdateBody.builder().deleted(true).build();
        }
        return StopwatchUpdateBody.builder()
                .running(stopwatch.isRunning())
                .build();
    }
}
