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

/**
 * The service for managing of tasks.
 */
public class TaskService extends AbstractRequestService {

    private final String taskListEndpoint;

    /**
     * If the service constructs without {@link AuthKey}, key must be passed to each method as argument.
     */
    public TaskService() {
        this(null);
    }

    /**
     * If the service constructs with {@link AuthKey}, you can use methods without key in parameters.
     * The passed key in constructor will be used by default.
     * If you want to send request with separate key, but without new service creating,
     * you can also use methods with {@link AuthKey} in parameters.
     * @param authKey yougile key for using by default in the Service instance.
     */
    public TaskService(AuthKey authKey) {
        super("tasks", authKey);
        taskListEndpoint = "api-v2/task-list";
    }

    /**
     * The request gets the container with {@link Task} list.
     * @param params {@link QueryParams} Request parameters<p>
     *                                  Available parameter names:<ul>
     *                                  <li>{@code assignedTo} ({@code string}) - Performer IDs separated by commas
     *                                  <li>{@code columnId} ({@code string}) - ID of column (s? separated by commas)
     *                                  <li>{@code includeDeleted} ({@code boolean}) - Set to {@code true} so that deleted objects are returned.
     *                                  <li>{@code limit} ({@code number}) - The number of elements you want to get. Maximum 1000.
     *                                  <li>{@code offset} ({@code number}) - Index of the first page element
     *                                  <li>{@code title} ({@code string}) - Task title
     *                                  </ul>
     * @param authKey {@link AuthKey} with your YouGile token
     * @return container with {@link Task} list
     * @throws IOException then the json cannot be parsed correctly.
     */
    public PagingContainer<Task> getTaskList(@NonNull QueryParams params, @NonNull AuthKey authKey) throws URISyntaxException, IOException {
        Response response = sendGetRequest(configureURI(params).setPath(taskListEndpoint).build(), authKey);
        Content content = response.handleResponse(ResponseHandlerProvider::okJsonHandler);
        return ContentHandler.handlePagingContent(content, Task.class);
    }

    /**
     * The request gets the container with {@link Task} list.
     * The passed key in constructor will be used by default.
     * @param params {@link QueryParams} Request parameters<p>
     *                                  Available parameter names:<ul>
     *                                  <li>{@code assignedTo} ({@code string}) - Performer IDs separated by commas
     *                                  <li>{@code columnId} ({@code string}) - ID of column (s? separated by commas)
     *                                  <li>{@code includeDeleted} ({@code boolean}) - Set to {@code true} so that deleted objects are returned.
     *                                  <li>{@code limit} ({@code number}) - The number of elements you want to get. Maximum 1000.
     *                                  <li>{@code offset} ({@code number}) - Index of the first page element
     *                                  <li>{@code title} ({@code string}) - Task title
     *                                  </ul>
     * @return container with {@link Task} list.
     * @throws IOException then the json cannot be parsed correctly.
     */
    public PagingContainer<Task> getTaskList(@NonNull QueryParams params) throws URISyntaxException, IOException {
        if (authKey == null) {
            throw new NullPointerException(noAuthKeyMessage);
        }
        return getTaskList(params, authKey);
    }

    /**
     * The request creates new task.
     * @param body body contained parameters of the creating task.
     * @param authKey yougile key.
     * @return ID of the created task.
     * @throws IOException then the json cannot be parsed correctly.
     */
    public Id createTask(@NonNull TaskCreateBody body, @NonNull AuthKey authKey) throws URISyntaxException, IOException {
        Response response = sendPostRequest(configureURI().build(), body, authKey);
        Content content = response.handleResponse(ResponseHandlerProvider::createdJsonHandler);
        return ContentHandler.handleId(content);
    }

    /**
     * The request creates new task.
     * The passed key in constructor will be used by default.
     * @param body body contained parameters of the creating task.
     * @return ID of the created task.
     * @throws IOException then the json cannot be parsed correctly.
     */
    public Id createTask(@NonNull TaskCreateBody body) throws URISyntaxException, IOException {
        if (authKey == null) {
            throw new NullPointerException(noAuthKeyMessage);
        }
        return createTask(body, authKey);
    }

    /**
     * The request gets {@link Task} by ID.
     * @param taskId ID of the task.
     * @param authKey yougile key.
     * @return task, if it's available.
     * @throws IOException then the json cannot be parsed correctly.
     */
    public Task getTaskById(@NonNull String taskId, @NonNull AuthKey authKey) throws URISyntaxException, IOException {
        Response response = sendGetRequest(configureURI(taskId).build(), authKey);
        Content content = response.handleResponse(ResponseHandlerProvider::okJsonHandler);
        return ContentHandler.handleTask(content);
    }

    /**
     * The request gets {@link Task} by ID.
     * The passed key in constructor will be used by default.
     * @param taskId ID of the task.
     * @return task, if it's available.
     * @throws IOException then the json cannot be parsed correctly.
     */
    public Task getTaskById(@NonNull String taskId) throws URISyntaxException, IOException {
        if (authKey == null) {
            throw new NullPointerException(noAuthKeyMessage);
        }
        return getTaskById(taskId, authKey);
    }

    /**
     * The request updates task.
     * @param taskId ID of the task to update.
     * @param body body with parameters to update.
     * @param authKey yougile key.
     * @return ID of the updated task.
     * @throws IOException then the json cannot be parsed correctly.
     */
    public Id updateTask(@NonNull String taskId, @NonNull TaskUpdateBody body, @NonNull AuthKey authKey) throws URISyntaxException, IOException {
        Response response = sendPutRequest(configureURI(taskId).build(), body, authKey);
        Content content = response.handleResponse(ResponseHandlerProvider::okJsonHandler);
        return ContentHandler.handleId(content);
    }

    /**
     * The request updates task.
     * The passed key in constructor will be used by default.
     * @param taskId ID of the task to update.
     * @param body body with parameters to update.
     * @return ID of the updated task.
     * @throws IOException then the json cannot be parsed correctly.
     */
    public Id updateTask(@NonNull String taskId, @NonNull TaskUpdateBody body) throws URISyntaxException, IOException {
        if (authKey == null) {
            throw new NullPointerException(noAuthKeyMessage);
        }
        return updateTask(taskId, body, authKey);
    }

    /**
     * The request updates task by passed entity {@link Task}
     * @param task the instance of the task to update.
     * @param authKey yougile key.
     * @return ID of the updated task.
     * @throws IOException then the json cannot be parsed correctly.
     */
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

    /**
     * The request updates task by passed entity {@link Task}
     * The passed key in constructor will be used by default.
     * @param task the instance of the task to update.
     * @return ID of the updated task.
     * @throws IOException then the json cannot be parsed correctly.
     */
    public Id updateTask(@NonNull Task task) throws URISyntaxException, IOException {
        if (authKey == null) {
            throw new NullPointerException(noAuthKeyMessage);
        }
        return updateTask(task, authKey);
    }

    /**
     * The request gets ID list of chat subscribers of the task.
     * @param taskId ID of the task.
     * @param authKey yougile key.
     * @return List of chat subscribers ID.
     * @throws IOException then the json cannot be parsed correctly.
     */
    public List<Id> getChatSubscribers(@NonNull String taskId, @NonNull AuthKey authKey) throws URISyntaxException, IOException {
        Response response = sendGetRequest(configureURI().setPath(getChatSubscribersEndpoint(taskId)).build(), authKey);
        Content content = response.handleResponse(ResponseHandlerProvider::okJsonHandler);
        return ContentHandler.handleIdList(content);
    }

    /**
     * The request gets ID list of chat subscribers of the task.
     * The passed key in constructor will be used by default.
     * @param taskId ID of the task.
     * @return List of chat subscribers ID.
     * @throws IOException then the json cannot be parsed correctly.
     */
    public List<Id> getChatSubscribers(@NonNull String taskId) throws URISyntaxException, IOException {
        if (authKey == null) {
            throw new NullPointerException(noAuthKeyMessage);
        }
        return getChatSubscribers(taskId, authKey);
    }

    /**
     * The request update chat subscribers list of the task.
     * The request change the current list to the passed list. If you want to add new member to the chat subscribers,
     * you firstly must get current list of chat subscribers, add new member to that list and pass the complete list as
     * {@link ChatSubscribersUpdateBody} to one of this method's argument.
     * @param taskId ID of the task.
     * @param body body with parameters to update.
     * @param authKey yougile key.
     * @return ID of the updated task.
     * @throws IOException then the json cannot be parsed correctly.
     */
    public Id updateChatSubscribers(@NonNull String taskId, @NonNull ChatSubscribersUpdateBody body, @NonNull AuthKey authKey) throws URISyntaxException, IOException {
        Response response = sendPutRequest(configureURI().setPath(getChatSubscribersEndpoint(taskId)).build(), body, authKey);
        Content content = response.handleResponse(ResponseHandlerProvider::okJsonHandler);
        return ContentHandler.handleId(content);
    }

    /**
     * The request update chat subscribers list of the task.
     * The passed key in constructor will be used by default.
     * The request change the current list to the passed list. If you want to add new member to the chat subscribers,
     * you firstly must get current list of chat subscribers, add new member to that list and pass the complete list as
     * {@link ChatSubscribersUpdateBody} to one of this method's argument.
     * @param taskId ID of the task.
     * @param body body with parameters to update.
     * @return ID of the updated task.
     * @throws IOException then the json cannot be parsed correctly.
     */
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
