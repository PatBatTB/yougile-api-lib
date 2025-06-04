package io.github.patbattb.yougileapilib.domain;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import io.github.patbattb.yougileapilib.http.deserialize.TaskPermissionsDeserializer;
import lombok.*;
import lombok.experimental.FieldDefaults;

import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
@FieldDefaults(level = AccessLevel.PRIVATE)
@EqualsAndHashCode
@ToString
@JsonDeserialize(using = TaskPermissionsDeserializer.class)
@JsonInclude(JsonInclude.Include.NON_EMPTY)
public class TaskPermissions {
    boolean show;
    boolean delete;
    boolean editTitle;
    boolean editDescription;
    boolean complete;
    boolean close;
    @NonNull
    String assignUsers;
    boolean connect;
    @NonNull
    String editSubtasks;
    boolean editStickers;
    boolean editPins;
    @NonNull
    String move;
    boolean sendMessages;
    boolean sendFiles;
    @NonNull
    String editWhoToNotify;

    public TaskPermissions(boolean show, boolean delete, boolean editTitle, boolean editDescription, boolean complete,
                           boolean close, String assignUsers, boolean connect, String editSubtasks, boolean editStickers,
                           boolean editPins, String move, boolean sendMessages, boolean sendFiles, String editWhoToNotify) {
        this.show = show;
        this.delete = delete;
        this.editTitle = editTitle;
        this.editDescription = editDescription;
        this.complete = complete;
        this.close = close;
        this.connect = connect;
        this.editStickers = editStickers;
        this.editPins = editPins;
        this.sendMessages = sendMessages;
        this.sendFiles = sendFiles;

        this.assignUsers = AssignUsers.validate(assignUsers);
        this.editSubtasks = EditSubtasks.validate(editSubtasks);
        this.move = Move.validate(move);
        this.editWhoToNotify = EditWhoToNotify.validate(editWhoToNotify);
    }

    private static class AvailableValues {

    }

    private enum AssignUsers {
        NO("no"),
        YES("yes"),
        ADD_SELF("add-self"),
        SET_SELF("set-self"),
        CHANGE_FROM_SELF("change-from-self");

        private final String value;

        AssignUsers(String value) {
            this.value = value;
        }

        private static String validate(String field) {
            List<String> valueList = new ArrayList<>();
            for (AssignUsers assignUsers: AssignUsers.values()) {
                if (assignUsers.value.equals(field)) {
                    return field;
                }
                valueList.add(assignUsers.value);
            }
            throw new IllegalArgumentException("task.assignUsers value must be one of " + String.join(", ", valueList));
        }
    }

    private enum EditSubtasks {
        NO("no"),
        YES("yes"),
        COMPLETE("complete");

        private final String value;

        EditSubtasks(String value) {
            this.value = value;
        }

        private static String validate(String field) {
            List<String> valueList = new ArrayList<>();
            for (EditSubtasks editSubtasks: EditSubtasks.values()) {
                if (editSubtasks.value.equals(field)) {
                    return field;
                }
                valueList.add(editSubtasks.value);
            }
            throw new IllegalArgumentException("task.editSubtasks value must be one of " + String.join(", ", valueList));
        }
    }

    private enum Move {
        NO("no"),
        YES("yes"),
        PROJECT("project"),
        BOARD("board");

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
            throw new IllegalArgumentException("task.move value must be one of " + String.join(", ", valueList));
        }
    }

    private enum EditWhoToNotify {
        NO("no"),
        YES("yes"),
        SELF("self");

        private final String value;

        EditWhoToNotify(String value) {
            this.value = value;
        }

        private static String validate(String field) {
            List<String> valueList = new ArrayList<>();
            for (EditWhoToNotify editWhoToNotify: EditWhoToNotify.values()) {
                if (editWhoToNotify.value.equals(field)) {
                    return field;
                }
                valueList.add(editWhoToNotify.value);
            }
            throw new IllegalArgumentException("task.editWhoToNotify value must be one of " + String.join(", ", valueList));
        }
    }
}
