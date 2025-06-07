package io.github.patbattb.yougileapilib.domain.body;

import com.fasterxml.jackson.annotation.JsonInclude;
import io.github.patbattb.yougileapilib.domain.*;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.experimental.FieldDefaults;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Getter
@FieldDefaults(level = AccessLevel.PRIVATE)
@JsonInclude(JsonInclude.Include.NON_EMPTY)
public class TaskCreateBody extends RequestBody {

    final String title;

    String columnId;
    String description;
    Boolean archived;
    Boolean completed;
    final List<String> subtasks;
    final List<String> assigned;
    Deadline deadline;
    TimeTracking timeTracking;
    final List<Checklist> checklists;
    final Map<String, String> stickers;
    String color;
    String idTaskCommon;
    String idTaskProject;
    Stopwatch stopwatch;
    Timer timer;

    private TaskCreateBody(String title, List<String> subtasks, List<String> assigned,
                           List<Checklist> checklists, Map<String, String> stickers) {
        this.title = title;
        this.subtasks = subtasks;
        this.assigned = assigned;
        this.checklists = checklists;
        this.stickers = stickers;
    }

    public static TaskCreateBody.Builder builder(String title) {
        return new Builder(
                new TaskCreateBody(title, new ArrayList<>(), new ArrayList<>(), new ArrayList<>(), new HashMap<>())
        );
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

        public Builder addSubtask(String subtaskId) {
            body.subtasks.add(subtaskId);
            return this;
        }

        public Builder addAssigned(String userId) {
            body.assigned.add(userId);
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

        public Builder addChecklist(Checklist checklist) {
            body.checklists.add(checklist);
            return this;
        }

        public Builder addSticker(String stickerId, String stateId) {
            body.stickers.put(stickerId, stateId);
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
