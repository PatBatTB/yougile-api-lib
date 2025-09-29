package io.github.patbattb.yougileapilib.domain;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonValue;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import io.github.patbattb.yougileapilib.http.deserialize.ColumnPermissionsDeserializer;
import lombok.*;
import lombok.experimental.FieldDefaults;

import java.util.Arrays;

/**
 * Permissions available on the {@link Column}
 * It contains {@link TaskPermissions}.
 * It's part of {@link BoardPermissions}
 * The {@link ColumnPermissions.Move} enumeration is a constraint of the available values for the {@link ColumnPermissions#move} field.
 */
@Getter
@Setter
@FieldDefaults(level = AccessLevel.PRIVATE)
@EqualsAndHashCode
@ToString
@JsonDeserialize(using = ColumnPermissionsDeserializer.class)
@JsonInclude(JsonInclude.Include.NON_NULL)
public class ColumnPermissions {
    /**
     * Can the column title be edited?
     */
    boolean editTitle;
    /**
     * Can the column be deleted?
     */
    boolean delete;
    /**
     * Can the column be moved?
     * This enum represents available values:
     * <ul>
     * <li>{@link Move#YES} - movement is allowed.
     * <li>{@link Move#PROJECT} - movement is allowed only inside the project.
     * <li>{@link Move#NO} - movement restricted.
     * </ul>
     */
    @NonNull
    Move move;
    /**
     * Can be task added to the column?
     */
    boolean addTask;

    /**
     * Default permissions for all tasks.
     */
    @NonNull
    @JsonProperty("allTasks")
    TaskPermissions allTasksPermissions;

    /**
     * Permissions for tasks where the user is added to notifications.
     */
    @JsonProperty("withMeTasks")
    TaskPermissions withMeTasksPermissions;

    /**
     * Permissions for tasks assigned to the user
     */
    @JsonProperty("myTasks")
    TaskPermissions myTasksPermissions;

    /**
     * Task permissions created by the user himself.
     */
    @JsonProperty("createdByMeTasks")
    TaskPermissions createdByMeTasksPermissions;

    public ColumnPermissions(boolean editTitle, boolean delete, Move move, boolean addTask,
                             TaskPermissions allTasksPermissions, TaskPermissions withMeTasksPermissions,
                             TaskPermissions myTasksPermissions, TaskPermissions createdByMeTasksPermissions) {
        this.editTitle = editTitle;
        this.delete = delete;
        this.addTask = addTask;
        this.allTasksPermissions = allTasksPermissions;
        this.withMeTasksPermissions = withMeTasksPermissions;
        this.myTasksPermissions = myTasksPermissions;
        this.createdByMeTasksPermissions = createdByMeTasksPermissions;

        this.move = move;
    }

    /**
     * Enumeration represents available values for the {@link ColumnPermissions#move}
     */
    public enum Move {
        NO("no"),
        YES("yes"),
        PROJECT("project");

        private static final String apiFieldName = "column.move";
        @JsonValue
        private final String value;

        Move(String value) {
            this.value = value;
        }

        /**
         * Create enum constant from the {@link String} value.
         * If there is no passed value in available list method throws {@link IllegalArgumentException}
         * @param value value of the constant. Available values : yes, no, project.
         * @return appropriate enum constant.
         * @throws IllegalArgumentException if passed value is not available.
         */
        public static Move fromValue(String value) {
            for (Move move: Move.values()) {
                if (move.value.equalsIgnoreCase(value)) {
                    return move;
                }
            }
            throw new IllegalArgumentException(apiFieldName + " value must be one of: " + Arrays.stream(values()).map(elem -> elem.value).toList());
        }
    }
}
