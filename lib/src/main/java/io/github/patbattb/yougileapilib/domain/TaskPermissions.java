package io.github.patbattb.yougileapilib.domain;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonValue;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import io.github.patbattb.yougileapilib.http.deserialize.TaskPermissionsDeserializer;
import lombok.*;
import lombok.experimental.FieldDefaults;

import java.util.Arrays;

/**
 * Available permissions for the {@link Task} in the {@link ProjectRole}
 *
 * These permissions are part of {@link ColumnPermissions}.
 */
@Getter
@Setter
@FieldDefaults(level = AccessLevel.PRIVATE)
@EqualsAndHashCode
@ToString
@JsonDeserialize(using = TaskPermissionsDeserializer.class)
@JsonInclude(JsonInclude.Include.NON_NULL)
public class TaskPermissions {
    /**
     * Viewing the Task.
     */
    boolean show;
    /**
     * Can the user delete tasks?
     */
    boolean delete;
    /**
     * Can the user edit task titles?
     */
    boolean editTitle;
    /**
     * Can the user edit task descriptions?
     */
    boolean editDescription;
    /**
     * Can the user complete tasks?
     */
    boolean complete;
    /**
     * Can the user close tasks?
     */
    boolean close;
    /**
     * Can the user assign users to any task?
     * This enum represents available values:
     * <ul>
     *     <li> {@link AssignUsers#NO} - assigning any users is forbidden.
     *     <li> {@link AssignUsers#YES} - assigning any users is allowed.
     *     <li> {@link AssignUsers#ADD_SELF} - the user can assign himself only.
     *     <li> {@link AssignUsers#SET_SELF} - the user can assign himself if there are no assigned users yet.
     *     <li> {@link AssignUsers#CHANGE_FROM_SELF} - the user can assign another user from himself only.
     * </ul>
     */
    @NonNull
    AssignUsers assignUsers;
    /**
     * Can the user link tasks to another tasks?
     */
    boolean connect;
    /**
     * Can the user edit checklists and subtasks?
     * This enum represents available values:
     * <ul>
     *     <li> {@link EditSubtasks#NO} - editing subtask list and checklists is forbidden.
     *     <li> {@link EditSubtasks#YES} - editing subtask list and checklists is allowed.
     *     <li> {@link EditSubtasks#COMPLETE} - only completion is allowed.
     * </ul>
     */
    @NonNull
    EditSubtasks editSubtasks;
    /**
     * Can the user edit stickers and change color of the task?
     */
    boolean editStickers;
    /**
     * Can the user edit fast link in the task-chat?
     */
    boolean editPins;
    /**
     * Can the user move the task?
     * This enum represents available values:
     * <ul>
     *     <li>{@link Move#YES} - task moving is allowed.
     *     <li>{@link Move#NO} - task moving is forbidden.
     *     <li>{@link Move#PROJECT} - task moving allowed inside project only.
     *     <li>{@link Move#BOARD} - task moving allowed inside board only.
     * </ul>
     */
    @NonNull
    Move move;
    /**
     * Can the user send messages in the task chat?
     */
    boolean sendMessages;
    /**
     * Can the user send files in the task chat?
     */
    boolean sendFiles;
    /**
     * Changing the list of notification recipients.
     * The enum represents available values:
     * <ul>
     *     <li> {@link EditWhoToNotify#YES} - editing recipient list is allowed.
     *     <li> {@link EditWhoToNotify#NO} - editing recipient list is forbidden.
     *     <li> {@link EditWhoToNotify#SELF} - the user is allowed to add and remove only himself
     * </ul>
     */
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

    /**
     * The enumeration represents available values for {@link TaskPermissions#assignUsers}.
     */
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

        /**
         * Create enum constant from the {@link String} value.
         * If there is no passed value in available list method throws {@link IllegalArgumentException}
         * @param value value of the constant. Available values : no, yes, add-self, set-self, change-from-self
         * @return appropriate enum constant.
         * @throws IllegalArgumentException if passed value is not available.
         */
        public static AssignUsers fromValue(String value) {
            for(AssignUsers assignUsers: AssignUsers.values()) {
                if (assignUsers.value.equalsIgnoreCase(value)) {
                    return assignUsers;
                }
            }
            throw new IllegalArgumentException(apiFieldName + " value must be one of: " + Arrays.stream(values()).map(elem -> elem.value).toList());
        }
    }

    /**
     * The enumeration represents available values for the {@link TaskPermissions#editSubtasks}.
     */
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

        /**
         * Create enum constant from the {@link String} value.
         * If there is no passed value in available list method throws {@link IllegalArgumentException}
         * @param value value of the constant. Available values : no, yes, complete.
         * @return appropriate enum constant.
         * @throws IllegalArgumentException if passed value is not available.
         */
        public static EditSubtasks fromValue(String value) {
            for (EditSubtasks editSubtasks: EditSubtasks.values()) {
                if (editSubtasks.value.equalsIgnoreCase(value)) {
                    return editSubtasks;
                }
            }
            throw new IllegalArgumentException(apiFieldName + " value must be one of: " + Arrays.stream(values()).map(elem -> elem.value).toList());
        }
    }

    /**
     * The enumeration represents available values for the {@link TaskPermissions#move}.
     */
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

        /**
         * Create enum constant from the {@link String} value.
         * If there is no passed value in available list method throws {@link IllegalArgumentException}
         * @param value value of the constant. Available values : no, yes, project, board.
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

    /**
     * The enumeration represents available values for the {@link TaskPermissions#editWhoToNotify}.
     */
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

        /**
         * Create enum constant from the {@link String} value.
         * If there is no passed value in available list method throws {@link IllegalArgumentException}
         * @param value value of the constant. Available values : no, yes, self.
         * @return appropriate enum constant.
         * @throws IllegalArgumentException if passed value is not available.
         */
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
