package io.github.patbattb.yougileapilib.domain;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonValue;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import io.github.patbattb.yougileapilib.http.deserialize.TaskPermissionsDeserializer;
import lombok.*;
import lombok.experimental.FieldDefaults;

import java.util.Arrays;

@Getter
@Setter
@FieldDefaults(level = AccessLevel.PRIVATE)
@EqualsAndHashCode
@ToString
@JsonDeserialize(using = TaskPermissionsDeserializer.class)
@JsonInclude(JsonInclude.Include.NON_NULL)
public class TaskPermissions {
    boolean show;
    boolean delete;
    boolean editTitle;
    boolean editDescription;
    boolean complete;
    boolean close;
    @NonNull
    AssignUsers assignUsers;
    boolean connect;
    @NonNull
    EditSubtasks editSubtasks;
    boolean editStickers;
    boolean editPins;
    @NonNull
    Move move;
    boolean sendMessages;
    boolean sendFiles;
    @NonNull
    EditWhoToNotify editWhoToNotify;

    public TaskPermissions(boolean show, boolean delete, boolean editTitle, boolean editDescription, boolean complete,
                           boolean close, AssignUsers assignUsers, boolean connect, EditSubtasks editSubtasks, boolean editStickers,
                           boolean editPins, Move move, boolean sendMessages, boolean sendFiles, EditWhoToNotify editWhoToNotify) {
        this.show = show;
        this.delete = delete;
        this.editTitle = editTitle;
        this.editDescription = editDescription;
        this.complete = complete;
        this.close = close;
        this.assignUsers = assignUsers;
        this.connect = connect;
        this.editSubtasks = editSubtasks;
        this.editStickers = editStickers;
        this.editPins = editPins;
        this.move = move;
        this.sendMessages = sendMessages;
        this.sendFiles = sendFiles;
        this.editWhoToNotify = editWhoToNotify;
    }

    public enum AssignUsers {
        NO("no"),
        YES("yes"),
        ADD_SELF("add-self"),
        SET_SELF("set-self"),
        CHANGE_FROM_SELF("change-from-self");

        private static final String apiFieldName = "tasks.assignUsers";
        @JsonValue
        private final String value;

        AssignUsers(String value) {
            this.value = value;
        }

        public static AssignUsers fromValue(String value) {
            for(AssignUsers assignUsers: AssignUsers.values()) {
                if (assignUsers.value.equalsIgnoreCase(value)) {
                    return assignUsers;
                }
            }
            throw new IllegalArgumentException(apiFieldName + " value must be one of: " + Arrays.stream(values()).map(elem -> elem.value).toList());
        }
    }

    public enum EditSubtasks {
        NO("no"),
        YES("yes"),
        COMPLETE("complete");

        private static final String apiFieldName = "tasks.editSubtasks";
        @JsonValue
        private final String value;

        EditSubtasks(String value) {
            this.value = value;
        }

        public static EditSubtasks fromValue(String value) {
            for (EditSubtasks editSubtasks: EditSubtasks.values()) {
                if (editSubtasks.value.equalsIgnoreCase(value)) {
                    return editSubtasks;
                }
            }
            throw new IllegalArgumentException(apiFieldName + " value must be one of: " + Arrays.stream(values()).map(elem -> elem.value).toList());
        }
    }

    public enum Move {
        NO("no"),
        YES("yes"),
        PROJECT("project"),
        BOARD("board");

        private static final String apiFieldName = "tasks.move";
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

    public enum EditWhoToNotify {
        NO("no"),
        YES("yes"),
        SELF("self");

        private static final String apiFieldName = "tasks.editWhoToNotify";
        @JsonValue
        private final String value;

        EditWhoToNotify(String value) {
            this.value = value;
        }

        public static EditWhoToNotify fromValue(String value) {
            for (EditWhoToNotify editWhoToNotify: EditWhoToNotify.values()) {
                if (editWhoToNotify.value.equalsIgnoreCase(value)) {
                    return editWhoToNotify;
                }
            }
            throw new IllegalArgumentException(apiFieldName + " value must be one of: " + Arrays.stream(values()).map(elem -> elem.value).toList());
        }
    }
}
