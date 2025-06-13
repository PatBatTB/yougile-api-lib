package io.github.patbattb.yougileapilib.http.deserialize;

import com.fasterxml.jackson.core.JsonProcessingException;
import io.github.patbattb.yougileapilib.domain.ProjectRole;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class ProjectRoleDeserializerTest extends AbstractDeserializerTest {

    static String id;
    static String name;

    @BeforeAll
    static void beforeAll() {
        id = "67d01350-d2a4-4100-a644-281d4764ffda";
        name = "Custom";
    }

    @Test
    @DisplayName("Deserialize required fields only")
    void deserialize() throws JsonProcessingException {
        String jsonString = String.format(
                """
                {
                  "id": "%s",
                  "name": "%s",
                  "permissions": {
                    "editTitle": false,
                    "delete": true,
                    "addBoard": true,
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
                }
                """, id, name
        );
        ProjectRole role = mapper.readValue(jsonString, ProjectRole.class);
        assertThat(role.getId()).isEqualTo(id);
        assertThat(role.getName()).isEqualTo(name);
        assertThat(role.getDescription()).isNull();
    }

    @Test
    @DisplayName("Deserialize description field")
    void deserializeDescription() throws JsonProcessingException {
        String description = "testDescription";
        String jsonString = String.format(
                """
                {
                  "id": "%s",
                  "name": "%s",
                  "description": "%s",
                  "permissions": {
                    "editTitle": false,
                    "delete": true,
                    "addBoard": true,
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
                }
                """, id, name, description
        );
        ProjectRole role = mapper.readValue(jsonString, ProjectRole.class);
        assertThat(role.getDescription()).isEqualTo(description);
    }
}