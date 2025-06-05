package io.github.patbattb.yougileapilib.domain;

import lombok.*;
import lombok.experimental.FieldDefaults;

import java.util.List;

@Getter
@FieldDefaults(level = AccessLevel.PRIVATE)
@AllArgsConstructor
@EqualsAndHashCode
@ToString
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
    long archivedTimestamp;
    @Setter
    boolean completed;
    long completedTimestamp;
    @Setter
    List<String> subtasks;
    @Setter
    List<String> assigned;
    String cratedBy;
    @Setter
    Deadline deadline;
    @Setter
    TimeTracking timeTracking;
    @Setter
    List<ChecklistContainer> checklists;
    @Setter
    List<CustomSticker> stickers;
    @Setter
    TaskColor color;
    @Setter
    String idTaskCommon;
    @Setter
    String idTaskProject;
    @Setter
    Stopwatch stopwatch;
    @Setter
    Timer timer;
}
