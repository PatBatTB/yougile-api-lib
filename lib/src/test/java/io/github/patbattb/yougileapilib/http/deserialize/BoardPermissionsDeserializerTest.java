package io.github.patbattb.yougileapilib.http.deserialize;

import com.fasterxml.jackson.core.JsonProcessingException;
import io.github.patbattb.yougileapilib.domain.BoardPermissions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class BoardPermissionsDeserializerTest extends AbstractDeserializerTest {



    @Test
    @DisplayName("Deserialize required fields only")
    void deserialize() throws JsonProcessingException {
        boolean editTitle = false;
        boolean delete = true;
        boolean move = true;
        boolean showStickers = true;
        boolean editStickers = false;
        boolean addColumn = false;
        boolean settings = true;
        String jsonString = String.format(
                """
                {
                  "editTitle": %s,
                  "delete": %s,
                  "move": %s,
                  "showStickers": %s,
                  "editStickers": %s,
                  "addColumn": %s,
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
                  "settings": %s
                }
                """, editTitle, delete, move, showStickers, editStickers, addColumn, settings
        );
        BoardPermissions permissions = mapper.readValue(jsonString, BoardPermissions.class);
        assertThat(permissions.isEditTitle()).isEqualTo(editTitle);
        assertThat(permissions.isDelete()).isEqualTo(delete);
        assertThat(permissions.isMove()).isEqualTo(move);
        assertThat(permissions.isShowStickers()).isEqualTo(showStickers);
        assertThat(permissions.isEditStickers()).isEqualTo(editStickers);
        assertThat(permissions.isAddColumn()).isEqualTo(addColumn);
        assertThat(permissions.isSettings()).isEqualTo(settings);
        assertThat(permissions.getColumnPermissions()).isNotNull();
    }
}