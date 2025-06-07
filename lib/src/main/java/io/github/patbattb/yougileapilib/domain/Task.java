package io.github.patbattb.yougileapilib.domain;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import io.github.patbattb.yougileapilib.http.deserialize.TaskDeserializer;
import lombok.*;
import lombok.experimental.FieldDefaults;

import java.util.List;
import java.util.Map;

@Getter
@FieldDefaults(level = AccessLevel.PRIVATE)
@AllArgsConstructor
@EqualsAndHashCode
@ToString
@JsonDeserialize(using = TaskDeserializer.class)
public class Task {
    @Setter
    boolean deleted;
    String id;
    @Setter
    String title;
    long created; //timestamp
    @Setter
    String columnId;
    @Setter
    String description;
    @Setter
    boolean archived;
    Long archivedTimestamp;
    @Setter
    boolean completed;
    Long completedTimestamp;
    @Setter
    List<String> subtasks;
    @Setter
    List<String> assigned;
    String createdBy;
    @Setter
    Deadline deadline;
    @Setter
    TimeTracking timeTracking;
    @Setter
    List<Checklist> checklists;
    @Setter
    Map<String, String> stickers;
    @Setter
    String color;
    @Setter
    String idTaskCommon;
    @Setter
    String idTaskProject;
    @Setter
    Stopwatch stopwatch;
    @Setter
    Timer timer;
}
