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

@Getter
@FieldDefaults(level = AccessLevel.PRIVATE)
@JsonInclude(JsonInclude.Include.NON_NULL)
public class TaskCreateBody extends RequestBody {

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
    String color;
    String idTaskCommon;
    String idTaskProject;
    Stopwatch stopwatch;
    Timer timer;

    private TaskCreateBody(String title) {
        this.title = title;
    }

    public static TaskCreateBody.Builder builder(@NonNull String title) {
        return new Builder(new TaskCreateBody(title));
    }

    public static class Builder extends BodyBuilder<TaskCreateBody> {

        private Builder(TaskCreateBody body) {
            super(body);
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

        public Builder subtasks(String... subtaskIds) {
            body.subtasks = Arrays.asList(subtaskIds);
            return this;
        }

        public Builder assigned(String... userIds) {
            body.assigned = Arrays.asList(userIds);
            return this;
        }

        public Builder deadline(Deadline value) {
            body.deadline = value;
            return this;
        }

        public Builder timeTracking(TimeTracking value) {
            body.timeTracking = value;
            return this;
        }

        public Builder checklists(Checklist... checklist) {
            body.checklists = Arrays.asList(checklist);
            return this;
        }

        public Builder stickers(Map<String, String> stickers) {
            body.stickers = Map.copyOf(stickers);
            return this;
        }

        public Builder color(String value) {
            //TODO Проверка на валидность переданного значения
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

        public Builder stopwatch(Stopwatch value) {
            body.stopwatch = value;
            return this;
        }

        public Builder timer(Timer value) {
            body.timer = value;
            return this;
        }


    }
}
