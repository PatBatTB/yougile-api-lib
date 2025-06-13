package io.github.patbattb.yougileapilib.http.deserialize;

import com.fasterxml.jackson.core.JsonProcessingException;
import io.github.patbattb.yougileapilib.domain.TaskPermissions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class TaskPermissionsDeserializerTest extends AbstractDeserializerTest {

    @Test
    @DisplayName("Deserialize required fields only")
    void deserialize() throws JsonProcessingException {
        boolean show = true;
        boolean delete = true;
        boolean editTitle = true;
        boolean editDescription = true;
        boolean complete = true;
        boolean close = true;
        String assignUsers = "no";
        boolean connect = true;
        String editSubtasks = "no";
        boolean editStickers = true;
        boolean editPins = true;
        String move = "no";
        boolean sendMessages = true;
        boolean sendFiles = true;
        String editWhoToNotify = "no";
        String jsonString = String.format(
                """
                {
                      "show": %s,
                      "delete": %s,
                      "editTitle": %s,
                      "editDescription": %s,
                      "complete": %s,
                      "close": %s,
                      "assignUsers": "%s",
                      "connect": %s,
                      "editSubtasks": "%s",
                      "editStickers": %s,
                      "editPins": %s,
                      "move": "%s",
                      "sendMessages": %s,
                      "sendFiles": %s,
                      "editWhoToNotify": "%s"
                }
                """, show, delete, editTitle, editDescription, complete, close, assignUsers, connect,
                editSubtasks, editStickers, editPins, move, sendMessages, sendFiles, editWhoToNotify
        );
        TaskPermissions permissions = mapper.readValue(jsonString, TaskPermissions.class);
        assertThat(permissions.isShow()).isEqualTo(show);
        assertThat(permissions.isDelete()).isEqualTo(delete);
        assertThat(permissions.isEditTitle()).isEqualTo(editTitle);
        assertThat(permissions.isEditDescription()).isEqualTo(editDescription);
        assertThat(permissions.isComplete()).isEqualTo(complete);
        assertThat(permissions.isClose()).isEqualTo(close);
        assertThat(permissions.getAssignUsers()).isEqualTo(assignUsers);
        assertThat(permissions.isConnect()).isEqualTo(connect);
        assertThat(permissions.getEditSubtasks()).isEqualTo(editSubtasks);
        assertThat(permissions.isEditStickers()).isEqualTo(editStickers);
        assertThat(permissions.isEditPins()).isEqualTo(editPins);
        assertThat(permissions.getMove()).isEqualTo(move);
        assertThat(permissions.isSendMessages()).isEqualTo(sendMessages);
        assertThat(permissions.isSendFiles()).isEqualTo(sendFiles);
        assertThat(permissions.getEditWhoToNotify()).isEqualTo(editWhoToNotify);
    }
}