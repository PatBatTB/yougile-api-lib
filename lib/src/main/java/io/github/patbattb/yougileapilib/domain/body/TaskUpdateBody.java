package io.github.patbattb.yougileapilib.domain.body;

import com.fasterxml.jackson.annotation.JsonInclude;
import io.github.patbattb.yougileapilib.domain.Checklist;
import io.github.patbattb.yougileapilib.domain.Task;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.experimental.FieldDefaults;

import java.util.Arrays;
import java.util.List;
import java.util.Map;

/**
 * Implementation of the {@link RequestBody} for PUT request updates {@link Task}
 */
@Getter
@FieldDefaults(level = AccessLevel.PRIVATE)
@JsonInclude(JsonInclude.Include.NON_NULL)
public class TaskUpdateBody implements RequestBody {

    Boolean deleted;
    String title;
    String columnId;
    String description;
    Boolean archived;
    Boolean completed;
    List<String> subtasks;
    List<String> assigned;
    DeadlineUpdateBody deadline;
    TimeTrackingUpdateBody timeTracking;
    List<Checklist> checklists;
    //It doesn't work on yougile.
    final Map<String, String> stickers = null;
    Task.Color color;
    String idTaskCommon;
    String idTaskProject;
    TimerUpdateBody timer;
    StopwatchUpdateBody stopwatch;

    private TaskUpdateBody() {
    }

    /**
     * Instantiates the builder for constructing {@link TaskUpdateBody}.
     * This builder has no parameters. All fields of the {@link TaskUpdateBody} can be specified using the builder's methods.
     * @return the builder
     */
    public static TaskUpdateBody.Builder builder() {
        return new Builder(new TaskUpdateBody());
    }

    public static class Builder extends BodyBuilder<TaskUpdateBody> {

        private Builder(TaskUpdateBody body) {
            super(body);
        }

        /**
         *
         * @param value if true, then object will be deleted.
         * @return the builder itself for continue constructing.
         */
        public Builder deleted(boolean value) {
            body.deleted = value;
            return this;
        }

        /**
         *
         * @param value Task title.
         * @return the builder itself for continue constructing.
         */
        public Builder title(String value) {
            body.title = value;
            return this;
        }

        /**
         *
         * @param value ID of the column where the task will be placed.
         * @return the builder itself for continue constructing.
         */
        public Builder columnId(String value) {
            body.columnId = value;
            return this;
        }

        /**
         *
         * @param value Task description.
         * @return the builder itself for continue constructing.
         */
        public Builder description(String value) {
            body.description = value;
            return this;
        }

        /**
         *
         * @param value Is the task must be archived?
         * @return the builder itself for continue constructing.
         */
        public Builder archived(boolean value) {
            body.archived = value;
            return this;
        }

        /**
         *
         * @param value Is the task must be completed?
         * @return the builder itself for continue constructing.
         */
        public Builder completed(boolean value) {
            body.completed = value;
            return this;
        }

        /**
         *
         * @param taskId ID of subtasks that the task will contain
         * @return the builder itself for continue constructing.
         */
        public Builder subtasks(String... taskId) {
            body.subtasks = Arrays.asList(taskId);
            return this;
        }

        /**
         *
         * @param userId Assigned user IDs
         * @return the builder itself for continue constructing.
         */
        public Builder assigned(String... userId) {
            body.assigned = Arrays.asList(userId);
            return this;
        }

        /**
         * Sticker "Deadline". Indicates the deadline for completing the task.
         * It is possible to specify the time in addition to the date, as well as the start date of the task.
         * @param value deadline sticker.
         * @return the builder itself for continue constructing.
         */
        public Builder deadline(DeadlineUpdateBody value) {
            body.deadline = value;
            return this;
        }

        /**
         * Time Tracking Sticker. Used to indicate expected and actual time to complete a task.
         * @param value timeTracking sticker
         * @return the builder itself for continue constructing.
         */
        public Builder timeTracking(TimeTrackingUpdateBody value) {
            body.timeTracking = value;
            return this;
        }

        /**
         *
         * @param checklist checklists of the task.
         * @return the builder itself for continue constructing.
         */
        public Builder checklists(Checklist... checklist) {
            body.checklists = Arrays.asList(checklist);
            return this;
        }

        //TODO doesn't work. Error in side of API. Made ticket to yougile techsupport;
//        public Builder stickers(Map<String, String> stickers) {
//            body.stickers = Map.copyOf(stickers);
//            return this;
//        }

        /**
         * The color of the task.
         * This enum represents available color values:
         * <ul>
         *     <li>{@link Task.Color#PRIMARY} - default color.
         *     <li>{@link Task.Color#GRAY} - gray color.
         *     <li>{@link Task.Color#RED} - red color.
         *     <li>{@link Task.Color#PINK} - pink color.
         *     <li>{@link Task.Color#YELLOW} - yellow color.
         *     <li>{@link Task.Color#GREEN} - green color.
         *     <li>{@link Task.Color#TURQUOISE} - turquoise color.
         *     <li>{@link Task.Color#BLUE} - blue color.
         *     <li>{@link Task.Color#VIOLET} - violet color.
         * </ul>
         * @param value The color of the task.
         * @return the builder itself for continue constructing.
         */
        public Builder color(Task.Color value) {
            body.color = value;
            return this;
        }

        /**
         *
         * @param value The route numbering ID in the company.
         * @return the builder itself for continue constructing.
         */
        public Builder idTaskCommon(String value) {
            body.idTaskCommon = value;
            return this;
        }

        /**
         *
         * @param value The route numbering ID in the project.
         * @return the builder itself for continue constructing.
         */
        public Builder idTaskProject(String value) {
            body.idTaskProject = value;
            return this;
        }

        /**
         *
         * @param value Timer of the task.
         * @return the builder itself for continue constructing.
         */
        public Builder timer(TimerUpdateBody value) {
            body.timer = value;
            return this;
        }

        /**
         *
         * @param value Stopwatch of the task.
         * @return the builder itself for continue constructing.
         */
        public Builder stopwatch(StopwatchUpdateBody value) {
            body.stopwatch = value;
            return this;
        }
    }
}
