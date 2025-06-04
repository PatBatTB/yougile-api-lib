package io.github.patbattb.yougileapilib.domain;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import io.github.patbattb.yougileapilib.http.deserialize.ColumnPermissionsDeserializer;
import lombok.*;
import lombok.experimental.FieldDefaults;

import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
@FieldDefaults(level = AccessLevel.PRIVATE)
@EqualsAndHashCode
@ToString
@JsonDeserialize(using = ColumnPermissionsDeserializer.class)
@JsonInclude(JsonInclude.Include.NON_EMPTY)
public class ColumnPermissions {
    boolean editTitle;
    boolean delete;
    @NonNull
    String move;
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

    public ColumnPermissions(boolean editTitle, boolean delete, String move, boolean addTask,
                             TaskPermissions allTasksPermissions, TaskPermissions withMeTasksPermissions,
                             TaskPermissions myTasksPermissions, TaskPermissions createdByMeTasksPermissions) {
        this.editTitle = editTitle;
        this.delete = delete;
        this.addTask = addTask;
        this.allTasksPermissions = allTasksPermissions;
        this.withMeTasksPermissions = withMeTasksPermissions;
        this.myTasksPermissions = myTasksPermissions;
        this.createdByMeTasksPermissions = createdByMeTasksPermissions;

        this.move = Move.validate(move);
    }

    private enum Move {
        NO("no"),
        YES("yes"),
        PROJECT("project");

        private final String value;

        Move(String value) {
            this.value = value;
        }

        private static String validate(String field) {
            List<String> valueList = new ArrayList<>();
            for (Move move: Move.values()) {
                if (move.value.equals(field)) {
                    return field;
                }
                valueList.add(move.value);
            }
            throw new IllegalArgumentException("column.move value must be one of " + String.join(", ", valueList));
        }
    }
}
