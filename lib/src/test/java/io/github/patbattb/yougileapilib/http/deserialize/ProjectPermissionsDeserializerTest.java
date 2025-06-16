package io.github.patbattb.yougileapilib.http.deserialize;

import com.fasterxml.jackson.core.JsonProcessingException;
import io.github.patbattb.yougileapilib.domain.ProjectPermissions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class ProjectPermissionsDeserializerTest extends AbstractDeserializerTest {

    @Test
    @DisplayName("Deserialize required fields only")
    void deserialize() throws JsonProcessingException {
        boolean editTitle = true;
        boolean delete = true;
        boolean addBoard = true;
        String jsonString = String.format(
                """
                {
                    "editTitle": %s,
                    "delete": %s,
                    "addBoard": %s,
                    "boards": {
                      "editTitle": false,
                      "delete": true,
                      "move": true,
                      "showStickers": true,
                      "editStickers": false,
                      "addColumn": false,
                      "columns": {
                        "editTitle": false,
                        "delete": true,
                        "move": "project",
                        "addTask": true,
                        "allTasks": {
                          "show": true,
                          "delete": true,
                          "editTitle": false,
                          "editDescription": false,
                          "close": true,
                          "assignUsers": "set-self",
                          "connect": false,
                          "editSubtasks": "complete",
                          "editStickers": false,
                          "editPins": true,
                          "move": "board",
                          "complete": true,
                          "sendMessages": true,
                          "sendFiles": false,
                          "editWhoToNotify": "self"
                        }
                      },
                      "settings": true
                    },
                    "children": {}
                }
                """, editTitle, delete, addBoard
        );
        ProjectPermissions permissions = mapper.readValue(jsonString, ProjectPermissions.class);
        assertThat(permissions.isEditTitle()).isEqualTo(editTitle);
        assertThat(permissions.isEditTitle()).isEqualTo(delete);
        assertThat(permissions.isAddBoard()).isEqualTo(addBoard);
    }
}