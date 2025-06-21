package io.github.patbattb.yougileapilib.domain;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonValue;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import io.github.patbattb.yougileapilib.http.deserialize.ColumnPermissionsDeserializer;
import lombok.*;
import lombok.experimental.FieldDefaults;

import java.util.Arrays;

@Getter
@Setter
@FieldDefaults(level = AccessLevel.PRIVATE)
@EqualsAndHashCode
@ToString
@JsonDeserialize(using = ColumnPermissionsDeserializer.class)
@JsonInclude(JsonInclude.Include.NON_NULL)
public class ColumnPermissions {
    boolean editTitle;
    boolean delete;
    @NonNull
    Move move;
    boolean addTask;

    @NonNull
    @JsonProperty("allTasks")
    TaskPermissions allTasksPermissions;

    @JsonProperty("withMeTasks")
    TaskPermissions withMeTasksPermissions; //may be null

    @JsonProperty("myTasks")
    TaskPermissions myTasksPermissions; //may be null

    @JsonProperty("createdByMeTasks")
    TaskPermissions createdByMeTasksPermissions; //may be null

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
