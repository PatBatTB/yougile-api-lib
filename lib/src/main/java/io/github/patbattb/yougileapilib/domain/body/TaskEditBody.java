package io.github.patbattb.yougileapilib.domain.body;

import com.fasterxml.jackson.annotation.JsonInclude;
import io.github.patbattb.yougileapilib.domain.Checklist;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.experimental.FieldDefaults;

import java.util.*;

@Getter
@FieldDefaults(level = AccessLevel.PRIVATE)
@JsonInclude(JsonInclude.Include.NON_EMPTY)
public class TaskEditBody extends RequestBody {

    Boolean deleted;
    String title;
    String columnId;
    String description;
    Boolean archived;
    Boolean completed;
    final List<String> subtasks;
    final List<String> assigned;
    DeadlineEditBody deadline;
    TimeTrackingEditBody timeTracking;
    final List<Checklist> checklists;
    final Map<String, String> stickers;
    String color;
    String idTaskCommon;
    String idTaskProject;
    TimerEditBody timer;
    StopwatchEditBody stopwatch;

    private TaskEditBody(List<String> subtasks, List<String> assigned, List<Checklist> checklists, Map<String, String> stickers) {
        this.subtasks = subtasks;
        this.assigned = assigned;
        this.checklists = checklists;
        this.stickers = stickers;
    }

    public static TaskEditBody.Builder builder() {
        return new Builder(new TaskEditBody(new ArrayList<>(), new ArrayList<>(), new ArrayList<>(), new HashMap<>()));
    }

    public static class Builder extends BodyBuilder<TaskEditBody> {

        private Builder(TaskEditBody body) {
            super(body);
        }

        public Builder deleted(boolean value) {
            body.deleted = value;
            return this;
        }

        public Builder title(String value) {
            body.title = value;
            return this;
        }

        public Builder columnId(String value) {
            body.columnId = value;
            return this;
        }

        public Builder description(String value) {
            body.description = value;
            return this;
        }

        public Builder archived(boolean value) {
            body.archived = value;
            return this;
        }

        public Builder completed(boolean value) {
            body.completed = value;
            return this;
        }

        public Builder subtasks(String... taskId) {
            body.subtasks.addAll(Arrays.asList(taskId));
            return this;
        }

        public Builder assigned(String... userId) {
            body.assigned.addAll(Arrays.asList(userId));
            return this;
        }

        public Builder deadline(DeadlineEditBody value) {
            body.deadline = value;
            return this;
        }

        public Builder timeTracking(TimeTrackingEditBody value) {
            body.timeTracking = value;
            return this;
        }

        public Builder checklists(Checklist... checklist) {
            body.checklists.addAll(Arrays.asList(checklist));
            return this;
        }

        public Builder stickers(Map<String, String> value) {
            body.stickers.putAll(value);
            return this;
        }

        //TODO добавить проверку на валидность значения
        public Builder color(String value) {
            body.color = value;
            return this;
        }

        public Builder idTaskCommon(String value) {
            body.idTaskCommon = value;
            return this;
        }

        public Builder idTaskProject(String value) {
            body.idTaskProject = value;
            return this;
        }

        public Builder timer(TimerEditBody value) {
            body.timer = value;
            return this;
        }

        public Builder stopwatch(StopwatchEditBody value) {
            body.stopwatch = value;
            return this;
        }
    }
}
