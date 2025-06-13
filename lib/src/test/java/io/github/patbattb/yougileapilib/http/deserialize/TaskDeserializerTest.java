package io.github.patbattb.yougileapilib.http.deserialize;

import com.fasterxml.jackson.core.JsonProcessingException;
import io.github.patbattb.yougileapilib.domain.Checklist;
import io.github.patbattb.yougileapilib.domain.Checkpoint;
import io.github.patbattb.yougileapilib.domain.Task;
import io.github.patbattb.yougileapilib.domain.TimeTracking;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Collections;
import java.util.List;
import java.util.Map;

import static org.assertj.core.api.Assertions.assertThat;

class TaskDeserializerTest extends AbstractDeserializerTest {
    static String title;
    static long created;
    static String id;

    @BeforeAll
    static void beforeAll() {
        title = "dsfsd";
        created = 1749222971002L;
        id = "6bd6f6dd-dc13-4c35-bb2b-2c3303bb70d8";
    }

    @Test
    @DisplayName("Deserialize required fields only")
    void deserialize() throws JsonProcessingException {
        String jsonString = String.format(
                """
                {
                  "title": "%s",
                  "timestamp": %s,
                  "id": "%s"
                }
                """, title, created, id
        );
        Task task = mapper.readValue(jsonString, Task.class);
        assertThat(task.getTitle()).isEqualTo(title);
        assertThat(task.getCreated()).isEqualTo(created);
        assertThat(task.getId()).isEqualTo(id);
        assertThat(task.isDeleted()).isEqualTo(false);
        assertThat(task.getColumnId()).isNull();
        assertThat(task.getDescription()).isNull();
        assertThat(task.isArchived()).isEqualTo(false);
        assertThat(task.getArchivedTimestamp()).isNull();
        assertThat(task.isCompleted()).isEqualTo(false);
        assertThat(task.getCompletedTimestamp()).isNull();
        assertThat(task.getSubtasks()).isEqualTo(Collections.EMPTY_LIST);
        assertThat(task.getAssigned()).isEqualTo(Collections.EMPTY_LIST);
        assertThat(task.getCreatedBy()).isNull();
        assertThat(task.getDeadline()).isNull();
        assertThat(task.getTimeTracking()).isNull();
        assertThat(task.getChecklists()).isEqualTo(Collections.EMPTY_LIST);
        assertThat(task.getStickers()).isEqualTo(Collections.EMPTY_MAP);
        assertThat(task.getColor()).isNull();
        assertThat(task.getIdTaskCommon()).isNull();
        assertThat(task.getIdTaskProject()).isNull();
        assertThat(task.getStopwatch()).isNull();
        assertThat(task.getTimer()).isNull();
    }

    @Test
    @DisplayName("Deserialize deleted field")
    void deserializeDeleted() throws JsonProcessingException {
        boolean deleted = true;
        String jsonString = String.format(
                """
                {
                  "title": "%s",
                  "timestamp": %s,
                  "id": "%s",
                  "deleted": %s
                }
                """, title, created, id, deleted
        );
        Task task = mapper.readValue(jsonString, Task.class);
        assertThat(task.isDeleted()).isEqualTo(deleted);
    }

    @Test
    @DisplayName("Deserialize columnId field")
    void deserializeColumnId() throws JsonProcessingException {
        String columnId = "b3708ae1-3f98-4beb-b060-506f8b0640b0";
        String jsonString = String.format(
                """
                {
                  "title": "%s",
                  "timestamp": %s,
                  "id": "%s",
                  "columnId": "%s"
                }
                """, title, created, id, columnId
        );
        Task task = mapper.readValue(jsonString, Task.class);
        assertThat(task.getColumnId()).isEqualTo(columnId);
    }

    @Test
    @DisplayName("Deserialize description field")
    void deserializeDescription() throws JsonProcessingException {
        String description = "testDescr";
        String jsonString = String.format(
                """
                {
                  "title": "%s",
                  "timestamp": %s,
                  "id": "%s",
                  "description": "%s"
                }
                """, title, created, id, description
        );
        Task task = mapper.readValue(jsonString, Task.class);
        assertThat(task.getDescription()).isEqualTo(description);
    }

    @Test
    @DisplayName("Deserialize archived fields")
    void deserializeArchived() throws JsonProcessingException {
        boolean archived = true;
        long archivedTimestamp = 1749575998525L;
        String jsonString = String.format(
                """
                {
                  "title": "%s",
                  "timestamp": %s,
                  "id": "%s",
                  "archived": %s,
                  "archivedTimestamp": %s
                }
                """, title, created, id, archived, archivedTimestamp
        );
        Task task = mapper.readValue(jsonString, Task.class);
        assertThat(task.isArchived()).isEqualTo(archived);
        assertThat(task.getArchivedTimestamp()).isEqualTo(archivedTimestamp);
    }

    @Test
    @DisplayName("Deserialize completed fields")
    void deserializeCompleted() throws JsonProcessingException {
        boolean completed = true;
        long completedTimestamp = 1749575998525L;
        String jsonString = String.format(
                """
                {
                  "title": "%s",
                  "timestamp": %s,
                  "id": "%s",
                  "archived": %s,
                  "archivedTimestamp": %s
                }
                """, title, created, id, completed, completedTimestamp
        );
        Task task = mapper.readValue(jsonString, Task.class);
        assertThat(task.isArchived()).isEqualTo(completed);
        assertThat(task.getArchivedTimestamp()).isEqualTo(completedTimestamp);
    }

    @Test
    @DisplayName("Deserialize subtasks field")
    void deserializeSubtasks() throws JsonProcessingException {
        String subtaskOne = "8a09e21e-d07e-4777-8d34-f18cf2ce2c5f";
        String subtaskTwo = "92e6ad89-eb24-4756-bbae-0a327f06604c";
        String jsonString = String.format(
                """
                {
                  "title": "%s",
                  "timestamp": %s,
                  "id": "%s",
                  "subtasks": [
                      "%s",
                      "%s"
                  ]
                }
                """, title, created, id, subtaskOne, subtaskTwo
        );
        Task task = mapper.readValue(jsonString, Task.class);
        assertThat(task.getSubtasks()).isEqualTo(List.of(subtaskOne, subtaskTwo));
    }

    @Test
    @DisplayName("Deserialize assigned field")
    void deserializeAssigned() throws JsonProcessingException {
        String userOne = "9c685a12-4450-4764-8ba3-f49a73d00b10";
        String userTwo = "f3d012b6-0498-4012-bef7-70d6939b0f00";
        String jsonString = String.format(
                """
                {
                  "title": "%s",
                  "timestamp": %s,
                  "id": "%s",
                  "assigned": [
                      "%s",
                      "%s"
                  ]
                }
                """, title, created, id, userOne, userTwo
        );
        Task task = mapper.readValue(jsonString, Task.class);
        assertThat(task.getAssigned()).isEqualTo(List.of(userOne, userTwo));
    }

    @Test
    @DisplayName("Deserialize createdBy field")
    void deserializeCreatedBy() throws JsonProcessingException {
        String createdBy = "80eed1bd-eda3-4991-ac17-09d28566749d";
        String jsonString = String.format(
                """
                {
                  "title": "%s",
                  "timestamp": %s,
                  "id": "%s",
                  "createdBy": "%s"
                }
                """, title, created, id, createdBy
        );
        Task task = mapper.readValue(jsonString, Task.class);
        assertThat(task.getCreatedBy()).isEqualTo(createdBy);
    }

    @Test
    @DisplayName("Deserialize deadline field")
    void deserializeDeadline() throws JsonProcessingException {
        String jsonString = String.format(
                """
                {
                  "title": "%s",
                  "timestamp": %s,
                  "id": "%s",
                  "deadline": {
                      "deadline": 1653029146646,
                      "startDate": 1653028146646,
                      "withTime": true,
                      "history": [
                        "string"
                      ],
                      "blockedPoints": [
                        "string"
                      ],
                      "links": [
                        "string"
                      ]
                    }
                }
                """, title, created, id
        );
        Task task = mapper.readValue(jsonString, Task.class);
        //TODO wrong example for deadline in API docs
    }

    @Test
    @DisplayName("Deserialize timeTracking field")
    void deserializeTimeTracking() throws JsonProcessingException {
        TimeTracking timeTracking = new TimeTracking(10, 5);
        String jsonString = String.format(
                """
                {
                  "title": "%s",
                  "timestamp": %s,
                  "id": "%s",
                  "timeTracking": {
                      "plan": %s,
                      "work": %s
                  }
                }
                """, title, created, id, timeTracking.getPlan(), timeTracking.getWork()
        );
        Task task = mapper.readValue(jsonString, Task.class);
        assertThat(task.getTimeTracking()).isEqualTo(timeTracking);
    }

    @Test
    @DisplayName("Deserialize checklists field")
    void deserializeChecklists() throws JsonProcessingException {
        Checkpoint checkpointOne = new Checkpoint("oneTitle", true);
        Checkpoint checkpointTwo = new Checkpoint("twoTitle", false);
        Checklist checklist = new Checklist("testChecklist", List.of(checkpointOne, checkpointTwo));
        List<Checklist> checklists = List.of(checklist);
        String jsonString = String.format(
                """
                {
                  "title": "%s",
                  "timestamp": %s,
                  "id": "%s",
                  "checklists": [
                      {
                        "title": "%s",
                        "items": [
                          {
                            "isCompleted": %s,
                            "title": "%s"
                          },
                          {
                            "isCompleted": %s,
                            "title": "%s"
                          }
                        ]
                      }
                  ]
                }
                """, title, created, id, checklist.getTitle(),
                checkpointOne.isCompleted(), checkpointOne.getTitle(),
                checkpointTwo.isCompleted(), checkpointTwo.getTitle()
        );
        Task task = mapper.readValue(jsonString, Task.class);
        assertThat(task.getChecklists()).isEqualTo(checklists);
    }

    @Test
    @DisplayName("Deserialize stickers field")
    void deserializeStickers() throws JsonProcessingException {
        String keyOne = "a658df0b-ee0d-438a-a339-222968d97b2c";
        String valueOne = "";
        String keyTwo = "ec98e857-592f-4200-b2a1-5404c07f4802";
        String valueTwo = "2f3c0b29710e";
        Map<String, String> stickers = Map.of(
                keyOne, valueOne,
                keyTwo, valueTwo
        );
        String jsonString = String.format(
                """
                {
                  "title": "%s",
                  "timestamp": %s,
                  "id": "%s",
                    "stickers": {
                      "%s": "%s",
                      "%s": "%s"
                    }
                }
                """, title, created, id, keyOne, valueOne, keyTwo, valueTwo
        );
        Task task = mapper.readValue(jsonString, Task.class);
        assertThat(task.getStickers()).isEqualTo(stickers);
    }

    @Test
    @DisplayName("Deserialize color field")
    void deserializeColor() throws JsonProcessingException {
        String color = "task-red";
        String jsonString = String.format(
                """
                {
                  "title": "%s",
                  "timestamp": %s,
                  "id": "%s",
                  "color": "%s"
                }
                """, title, created, id, color
        );
        Task task = mapper.readValue(jsonString, Task.class);
        assertThat(task.getColor()).isEqualTo(color);
    }

    @Test
    @DisplayName("Deserialize idTaskCommon field")
    void deserializeIdTaskCommon() throws JsonProcessingException {
        String idTaskCommon = "ID-2";
        String jsonString = String.format(
                """
                {
                  "title": "%s",
                  "timestamp": %s,
                  "id": "%s",
                  "idTaskCommon": "%s"
                }
                """, title, created, id, idTaskCommon
        );
        Task task = mapper.readValue(jsonString, Task.class);
        assertThat(task.getIdTaskCommon()).isEqualTo(idTaskCommon);
    }

    @Test
    @DisplayName("Deserialize idTaskProject field")
    void deserializeIdTaskProject() throws JsonProcessingException {
        String idTaskProject = "NEWT-1";
        String jsonString = String.format(
                """
                {
                  "title": "%s",
                  "timestamp": %s,
                  "id": "%s",
                  "idTaskProject": "%s"
                }
                """, title, created, id, idTaskProject
        );
        Task task = mapper.readValue(jsonString, Task.class);
        assertThat(task.getIdTaskProject()).isEqualTo(idTaskProject);
    }

    @Test
    @DisplayName("Deserialize stopwatch field")
    void deserializeStopwatch() throws JsonProcessingException {
        String jsonString = String.format(
                """
                {
                  "title": "%s",
                  "timestamp": %s,
                  "id": "%s",
                  "stopwatch": {
                      "running": true,
                      "seconds": 1706,
                      "atMoment": 1749576005205
                    }
                }
                """, title, created, id
        );
        Task task = mapper.readValue(jsonString, Task.class);
        assertThat(task.getStopwatch()).isNotNull();
    }

    @Test
    @DisplayName("Deserialize timer field")
    void deserializeTimer() throws JsonProcessingException {
        String jsonString = String.format(
                """
                {
                  "title": "%s",
                  "timestamp": %s,
                  "id": "%s",
                  "timer": {
                      "running": true,
                      "seconds": -177427,
                      "since": 1749576005205
                    }
                }
                """, title, created, id
        );
        Task task = mapper.readValue(jsonString, Task.class);
        assertThat(task.getTimer()).isNotNull();
    }
}