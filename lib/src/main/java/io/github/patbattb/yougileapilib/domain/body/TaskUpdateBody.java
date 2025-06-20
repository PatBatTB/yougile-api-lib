package io.github.patbattb.yougileapilib.domain.body;

import com.fasterxml.jackson.annotation.JsonInclude;
import io.github.patbattb.yougileapilib.domain.Checklist;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.experimental.FieldDefaults;

import java.util.Arrays;
import java.util.List;
import java.util.Map;

@Getter
@FieldDefaults(level = AccessLevel.PRIVATE)
@JsonInclude(JsonInclude.Include.NON_NULL)
public class TaskUpdateBody extends RequestBody {

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
    Map<String, String> stickers;
    String color;
    String idTaskCommon;
    String idTaskProject;
    TimerUpdateBody timer;
    StopwatchUpdateBody stopwatch;

    private TaskUpdateBody() {
    }

    public static TaskUpdateBody.Builder builder() {
        return new Builder(new TaskUpdateBody());
    }

    public static class Builder extends BodyBuilder<TaskUpdateBody> {

        private Builder(TaskUpdateBody body) {
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
            body.subtasks = Arrays.asList(taskId);
            return this;
        }

        public Builder assigned(String... userId) {
            body.assigned = Arrays.asList(userId);
            return this;
        }

        public Builder deadline(DeadlineUpdateBody value) {
            body.deadline = value;
            return this;
        }

        public Builder timeTracking(TimeTrackingUpdateBody value) {
            body.timeTracking = value;
            return this;
        }

        public Builder checklists(Checklist... checklist) {
            body.checklists = Arrays.asList(checklist);
            return this;
        }

        //TODO doesn't work. Error in side of API. Made ticket to yougile techsupport;
//        public Builder stickers(Map<String, String> stickers) {
//            body.stickers = Map.copyOf(stickers);
//            return this;
//        }

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

        public Builder timer(TimerUpdateBody value) {
            body.timer = value;
            return this;
        }

        public Builder stopwatch(StopwatchUpdateBody value) {
            body.stopwatch = value;
            return this;
        }
    }
}
