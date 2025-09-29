package io.github.patbattb.yougileapilib.domain;

import com.fasterxml.jackson.annotation.JsonValue;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import io.github.patbattb.yougileapilib.http.deserialize.TaskDeserializer;
import lombok.*;
import lombok.experimental.FieldDefaults;

import java.util.*;

/**
 * This is the basic unit used in the system.
 * A task is a ticket in a  {@link Column} on the {@link Board} and stores all the basic information on a single task,
 * including stickers, checklists related to this task, and a list of responsible users.
 * A task can be a subtask of another task - in this case,
 * the parent task stores a list of IDs of its subtasks.
 */
@Getter
@FieldDefaults(level = AccessLevel.PRIVATE)
@EqualsAndHashCode
@ToString
@JsonDeserialize(using = TaskDeserializer.class)
public class Task {
    /**
     * If true, then Task has been deleted.
     */
    @Setter
    boolean deleted;
    /**
     * Task ID.
     */
    final String id;
    /**
     * Task title.
     */
    @Setter
    String title;
    /**
     * Timestamp of task's creation.
     */
    final long created;
    /**
     * ID of the column where the task is placed.
     */
    @Setter
    String columnId;
    /**
     * Task description.
     */
    @Setter
    String description;
    /**
     * Is the task archived?
     */
    @Setter
    boolean archived;
    /**
     * If the task is archived, there is timestamp specified archived date.
     */
    final Long archivedTimestamp;
    /**
     * Is the task completed?
     */
    @Setter
    boolean completed;
    /**
     * If the task is completed, there is timestamp specified completed date.
     */
    final Long completedTimestamp;
    /**
     * List of the subtasks.
     */
    @Setter
    List<String> subtasks;
    /**
     * List of assigned user IDs.
     */
    @Setter
    List<String> assigned;
    /**
     * User ID of the creator the task.
     */
    final String createdBy;
    /**
     * Sticker "Deadline". Indicates the deadline for completing the task.
     * It is possible to specify the time in addition to the date, as well as the start date of the task.
     */
    @Setter
    Deadline deadline;
    /**
     * Time Tracking Sticker. Used to indicate expected and actual time to complete a task.
     */
    @Setter
    TimeTracking timeTracking;
    /**
     * Checklists. The transferred object will always be assigned to the task.
     * If changes need to be made, you must first receive the checklists, then make the adjustment,
     * and then write it back to the task.
     */
    @Setter
    List<Checklist> checklists;
    /**
     * Custom stickers. Passed as a key-value object.
     * Where key is the sticker ID, value is the state ID.
     * To unpin a sticker from a task, use "-" as the state value.
     */
    final Map<String, String> stickers;
    /**
     * The color of the task.
     * This enum represents available color values:
     * <ul>
     *     <li>{@link Color#PRIMARY} - default color.
     *     <li>{@link Color#GRAY} - gray color.
     *     <li>{@link Color#RED} - red color.
     *     <li>{@link Color#PINK} - pink color.
     *     <li>{@link Color#YELLOW} - yellow color.
     *     <li>{@link Color#GREEN} - green color.
     *     <li>{@link Color#TURQUOISE} - turquoise color.
     *     <li>{@link Color#BLUE} - blue color.
     *     <li>{@link Color#VIOLET} - violet color.
     * </ul>
     */
    @Setter
    Color color;
    /**
     * The route numbering ID in the company.
     */
    @Setter
    String idTaskCommon;
    /**
     * The route numbering ID in the project.
     */
    @Setter
    String idTaskProject;
    /**
     * Stopwatch of the task.
     */
    @Setter
    Stopwatch stopwatch;
    /**
     * Timer of the task.
     */
    @Setter
    Timer timer;

    public Task(boolean deleted, String id, String title, long created, String columnId, String description,
                boolean archived, Long archivedTimestamp, boolean completed, Long completedTimestamp,
                List<String> subtasks, List<String> assigned, String createdBy, Deadline deadline,
                TimeTracking timeTracking, List<Checklist> checklists, Map<String, String> stickers,
                Color color, String idTaskCommon, String idTaskProject, Stopwatch stopwatch, Timer timer) {
        this.deleted = deleted;
        this.id = id;
        this.title = title;
        this.created = created;
        this.columnId = columnId;
        this.description = description;
        this.archived = archived;
        this.archivedTimestamp = archivedTimestamp;
        this.completed = completed;
        this.completedTimestamp = completedTimestamp;
        this.subtasks = subtasks;
        this.assigned = assigned;
        this.createdBy = createdBy;
        this.deadline = deadline;
        this.timeTracking = timeTracking;
        this.checklists = checklists;
        this.stickers = new HashMap<>(stickers);
        this.color = color;
        this.idTaskCommon = idTaskCommon;
        this.idTaskProject = idTaskProject;
        this.stopwatch = stopwatch;
        this.timer = timer;
    }

    /**
     * Enumeration represents available values for the {@link Task#color}.
     */
    public enum Color {
        PRIMARY("task-primary"),
        GRAY("task-gray"),
        RED("task-red"),
        PINK("task-pink"),
        YELLOW("task-yellow"),
        GREEN("task-green"),
        TURQUOISE("task-turquoise"),
        BLUE("task-blue"),
        VIOLET("task-violet");

        private static final String API_FIELD_NAME = "color";
        @JsonValue
        @Getter
        private final String value;

        Color(String value) {
            this.value = value;
        }

        /**
         * Create enum constant from the {@link String} value.
         * If there is no passed value in available list method throws {@link IllegalArgumentException}
         * @param value value of the constant. Available values : task-primary, task-gray, task-red, task-pink,
         *              task-yellow, task-green, task-turquoise, task-blue, task-violet.
         * @return appropriate enum constant.
         * @throws IllegalArgumentException if passed value is not available.
         */
        public static Color fromValue(String value) {
            for (Color color: Color.values()) {
                if (color.value.equalsIgnoreCase(value)) {
                    return color;
                }
            }
            throw new IllegalArgumentException(API_FIELD_NAME + " value must be one of: " + Arrays.stream(values()).map(elem -> elem.value).toList());
        }
    }
}
