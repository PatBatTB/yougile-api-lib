package io.github.patbattb.yougileapilib.domain.body;

import com.fasterxml.jackson.annotation.JsonInclude;
import io.github.patbattb.yougileapilib.domain.*;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NonNull;
import lombok.experimental.FieldDefaults;

import java.util.Arrays;
import java.util.List;
import java.util.Map;

/**
 * Implementation of the {@link RequestBody} for POST request creates {@link Task}
 */
@Getter
@FieldDefaults(level = AccessLevel.PRIVATE)
@JsonInclude(JsonInclude.Include.NON_NULL)
public class TaskCreateBody implements RequestBody {

    final String title;

    String columnId;
    String description;
    Boolean archived;
    Boolean completed;
    List<String> subtasks;
    List<String> assigned;
    Deadline deadline;
    TimeTracking timeTracking;
    List<Checklist> checklists;
    Map<String, String> stickers;
    Task.Color color;
    String idTaskCommon;
    String idTaskProject;
    Stopwatch stopwatch;
    Timer timer;

    private TaskCreateBody(String title) {
        this.title = title;
    }

    /**
     * Instantiates the builder for constructing {@link TaskCreateBody}.
     * Required fields of the {@link TaskCreateBody} needs to be passed as the arguments.
     * The remaining fields can be specified using the builder's methods.
     * @param title task title
     * @return the builder
     */
    public static TaskCreateBody.Builder builder(@NonNull String title) {
        return new Builder(new TaskCreateBody(title));
    }

    public static class Builder extends BodyBuilder<TaskCreateBody> {

        private Builder(TaskCreateBody body) {
            super(body);
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
        public Builder archived(Boolean value) {
            body.archived = value;
            return this;
        }

        /**
         *
         * @param value Is the task must be completed?
         * @return the builder itself for continue constructing.
         */
        public Builder completed(Boolean value) {
            body.completed = value;
            return this;
        }

        /**
         *
         * @param subtaskIds ID of subtasks that the task will contain
         * @return the builder itself for continue constructing.
         */
        public Builder subtasks(String... subtaskIds) {
            body.subtasks = Arrays.asList(subtaskIds);
            return this;
        }

        /**
         *
         * @param userIds Assigned user IDs
         * @return the builder itself for continue constructing.
         */
        public Builder assigned(String... userIds) {
            body.assigned = Arrays.asList(userIds);
            return this;
        }

        /**
         * Sticker "Deadline". Indicates the deadline for completing the task.
         * It is possible to specify the time in addition to the date, as well as the start date of the task.
         * @param value deadline sticker.
         * @return the builder itself for continue constructing.
         */
        public Builder deadline(Deadline value) {
            body.deadline = value;
            return this;
        }

        /**
         * Time Tracking Sticker. Used to indicate expected and actual time to complete a task.
         * @param value timeTracking sticker
         * @return the builder itself for continue constructing.
         */
        public Builder timeTracking(TimeTracking value) {
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

        /**
         * Custom stickers. Passed as a key-value object, where key is the sticker ID, value is the state ID.
         * @param stickers custom stickers
         * @return the builder itself for continue constructing.
         */
        public Builder stickers(Map<String, String> stickers) {
            body.stickers = Map.copyOf(stickers);
            return this;
        }

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
         * @param value Stopwatch of the task.
         * @return the builder itself for continue constructing.
         */
        public Builder stopwatch(Stopwatch value) {
            body.stopwatch = value;
            return this;
        }

        /**
         *
         * @param value Timer of the task.
         * @return the builder itself for continue constructing.
         */
        public Builder timer(Timer value) {
            body.timer = value;
            return this;
        }


    }
}
