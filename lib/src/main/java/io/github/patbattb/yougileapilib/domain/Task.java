package io.github.patbattb.yougileapilib.domain;

import com.fasterxml.jackson.annotation.JsonValue;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import io.github.patbattb.yougileapilib.http.deserialize.TaskDeserializer;
import lombok.*;
import lombok.experimental.FieldDefaults;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Map;

@Getter
@FieldDefaults(level = AccessLevel.PRIVATE)
@EqualsAndHashCode
@ToString
@JsonDeserialize(using = TaskDeserializer.class)
public class Task {
    @Setter
    boolean deleted;
    final String id;
    @Setter
    String title;
    final long created;
    @Setter
    String columnId;
    @Setter
    String description;
    @Setter
    boolean archived;
    final Long archivedTimestamp;
    @Setter
    boolean completed;
    final Long completedTimestamp;
    @Setter
    List<String> subtasks;
    @Setter
    List<String> assigned;
    final String createdBy;
    @Setter
    Deadline deadline;
    @Setter
    TimeTracking timeTracking;
    @Setter
    List<Checklist> checklists;
    final Map<String, String> stickers;
    @Setter
    Color color;
    @Setter
    String idTaskCommon;
    @Setter
    String idTaskProject;
    @Setter
    Stopwatch stopwatch;
    @Setter
    Timer timer;

    public Task(boolean deleted, String id, String title, long created, String columnId, String description,
                boolean archived, Long archivedTimestamp, boolean completed, Long completedTimestamp,
                List<String> subtasks, List<String> assigned, String createdBy, Deadline deadline,
                TimeTracking timeTracking, List<Checklist> checklists, Map<String, String> stickers,
                Color color, String idTaskCommon, String idTaskProject, Stopwatch stopwatch, Timer timer) {
        this.deleted = deleted;
        this.id = id;
        this.title = title;
        this.created = created;
        this.columnId = columnId;
        this.description = description;
        this.archived = archived;
        this.archivedTimestamp = archivedTimestamp;
        this.completed = completed;
        this.completedTimestamp = completedTimestamp;
        this.subtasks = subtasks;
        this.assigned = assigned;
        this.createdBy = createdBy;
        this.deadline = deadline;
        this.timeTracking = timeTracking;
        this.checklists = checklists;
        this.stickers = Collections.unmodifiableMap(stickers);
        this.color = color;
        this.idTaskCommon = idTaskCommon;
        this.idTaskProject = idTaskProject;
        this.stopwatch = stopwatch;
        this.timer = timer;
    }

    public enum Color {
        PRIMARY("task-primary"),
        GRAY("task-gray"),
        RED("task-red"),
        PINK("task-pink"),
        YELLOW("task-yellow"),
        GREEN("task-green"),
        TURQUOISE("task-turquoise"),
        BLUE("task-blue"),
        VIOLET("task-violet");

        private static final String API_FIELD_NAME = "color";
        @JsonValue
        @Getter
        private final String value;

        Color(String value) {
            this.value = value;
        }

        public static Color fromValue(String value) {
            for (Color color: Color.values()) {
                if (color.value.equalsIgnoreCase(value)) {
                    return color;
                }
            }
            throw new IllegalArgumentException(API_FIELD_NAME + " value must be one of: " + Arrays.stream(values()).map(elem -> elem.value).toList());
        }
    }
}
