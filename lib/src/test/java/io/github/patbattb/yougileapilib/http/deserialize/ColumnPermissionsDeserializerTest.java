package io.github.patbattb.yougileapilib.http.deserialize;

import com.fasterxml.jackson.core.JsonProcessingException;
import io.github.patbattb.yougileapilib.domain.ColumnPermissions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class ColumnPermissionsDeserializerTest extends AbstractDeserializerTest {

    static boolean editTitle;
    static boolean delete;
    static String move;
    static boolean addTask;

    @BeforeAll
    static void beforeAll() {
        editTitle = true;
        delete = true;
        move = "no";
        addTask = true;
    }

    @Test
    @DisplayName("Deserialize required fields only")
    void deserialize() throws JsonProcessingException {
        String jsonString = String.format(
                """
                {
                    "editTitle": %s,
                    "delete": %s,
                    "move": "%s",
                    "addTask": %s,
                    "allTasks": {
                      "show": true,
                      "delete": true,
                      "editTitle": true,
                      "editDescription": true,
                      "complete": true,
                      "close": true,
                      "assignUsers": "no",
                      "connect": true,
                      "editSubtasks": "no",
                      "editStickers": true,
                      "editPins": true,
                      "move": "no",
                      "sendMessages": true,
                      "sendFiles": true,
                      "editWhoToNotify": "no"
                    }
                }
                """, editTitle, delete, move, addTask
        );
        ColumnPermissions columnPermissions = mapper.readValue(jsonString, ColumnPermissions.class);
        assertThat(columnPermissions.isEditTitle()).isEqualTo(editTitle);
        assertThat(columnPermissions.isDelete()).isEqualTo(delete);
        assertThat(columnPermissions.getMove()).isEqualTo(move);
        assertThat(columnPermissions.isAddTask()).isEqualTo(addTask);
        assertThat(columnPermissions.getAllTasksPermissions()).isNotNull();
    }

    @Test
    @DisplayName("Deserialize withMeTasks field")
    void deserializeWithMeTasks() throws JsonProcessingException {
        String jsonString =
                """
                {
                    "editTitle": true,
                    "delete": true,
                    "move": "no",
                    "addTask": true,
                    "allTasks": {
                      "show": true,
                      "delete": true,
                      "editTitle": true,
                      "editDescription": true,
                      "complete": true,
                      "close": true,
                      "assignUsers": "no",
                      "connect": true,
                      "editSubtasks": "no",
                      "editStickers": true,
                      "editPins": true,
                      "move": "no",
                      "sendMessages": true,
                      "sendFiles": true,
                      "editWhoToNotify": "no"
                    },
                    "withMeTasks": {
                      "show": true,
                      "delete": true,
                      "editTitle": true,
                      "editDescription": true,
                      "complete": true,
                      "close": true,
                      "assignUsers": "no",
                      "connect": true,
                      "editSubtasks": "no",
                      "editStickers": true,
                      "editPins": true,
                      "move": "no",
                      "sendMessages": true,
                      "sendFiles": true,
                      "editWhoToNotify": "no"
                    }
                }
                """;
        ColumnPermissions permissions = mapper.readValue(jsonString, ColumnPermissions.class);
        assertThat(permissions.getWithMeTasksPermissions()).isNotNull();
    }

    @Test
    @DisplayName("Deserialize myTasks field")
    void deserializeMyTasks() throws JsonProcessingException {
        String jsonString =
                """
                {
                    "editTitle": true,
                    "delete": true,
                    "move": "no",
                    "addTask": true,
                    "allTasks": {
                      "show": true,
                      "delete": true,
                      "editTitle": true,
                      "editDescription": true,
                      "complete": true,
                      "close": true,
                      "assignUsers": "no",
                      "connect": true,
                      "editSubtasks": "no",
                      "editStickers": true,
                      "editPins": true,
                      "move": "no",
                      "sendMessages": true,
                      "sendFiles": true,
                      "editWhoToNotify": "no"
                    },
                    "myTasks": {
                      "show": true,
                      "delete": true,
                      "editTitle": true,
                      "editDescription": true,
                      "complete": true,
                      "close": true,
                      "assignUsers": "no",
                      "connect": true,
                      "editSubtasks": "no",
                      "editStickers": true,
                      "editPins": true,
                      "move": "no",
                      "sendMessages": true,
                      "sendFiles": true,
                      "editWhoToNotify": "no"
                    }
                }
                """;
        ColumnPermissions permissions = mapper.readValue(jsonString, ColumnPermissions.class);
        assertThat(permissions.getMyTasksPermissions()).isNotNull();
    }

    @Test
    @DisplayName("Deserialize createdByMeTasks field")
    void deserializeCreatedByMeTasks() throws JsonProcessingException {
        String jsonString =
                """
                {
                    "editTitle": true,
                    "delete": true,
                    "move": "no",
                    "addTask": true,
                    "allTasks": {
                      "show": true,
                      "delete": true,
                      "editTitle": true,
                      "editDescription": true,
                      "complete": true,
                      "close": true,
                      "assignUsers": "no",
                      "connect": true,
                      "editSubtasks": "no",
                      "editStickers": true,
                      "editPins": true,
                      "move": "no",
                      "sendMessages": true,
                      "sendFiles": true,
                      "editWhoToNotify": "no"
                    },
                    "createdByMeTasks": {
                      "show": true,
                      "delete": true,
                      "editTitle": true,
                      "editDescription": true,
                      "complete": true,
                      "close": true,
                      "assignUsers": "no",
                      "connect": true,
                      "editSubtasks": "no",
                      "editStickers": true,
                      "editPins": true,
                      "move": "no",
                      "sendMessages": true,
                      "sendFiles": true,
                      "editWhoToNotify": "no"
                    }
                }
                """;
        ColumnPermissions permissions = mapper.readValue(jsonString, ColumnPermissions.class);
        assertThat(permissions.getCreatedByMeTasksPermissions()).isNotNull();
    }
}