package io.github.patbattb.yougileapilib.http.deserialize;

import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.JsonDeserializer;
import com.fasterxml.jackson.databind.JsonNode;
import io.github.patbattb.yougileapilib.domain.TaskPermissions;

import java.io.IOException;

public class TaskPermissionsDeserializer extends JsonDeserializer<TaskPermissions> {
    @Override
    public TaskPermissions deserialize(JsonParser p, DeserializationContext ctxt) throws IOException {
        JsonNode node = p.readValueAsTree();
        boolean show = node.get("show").asBoolean();
        boolean delete = node.get("delete").asBoolean();
        boolean editTitle = node.get("editTitle").asBoolean();
        boolean editDescription = node.get("editDescription").asBoolean();
        boolean close = node.get("close").asBoolean();
        String assignUsersValue = node.get("assignUsers").asText();
        TaskPermissions.AssignUsers assignUsers = TaskPermissions.AssignUsers.fromValue(assignUsersValue);
        boolean connect = node.get("connect").asBoolean();
        String editSubtasksValue = node.get("editSubtasks").asText();
        TaskPermissions.EditSubtasks editSubtasks = TaskPermissions.EditSubtasks.fromValue(editSubtasksValue);
        boolean editStickers = node.get("editStickers").asBoolean();
        boolean editPins = node.get("editPins").asBoolean();
        String moveValue = node.get("move").asText();
        TaskPermissions.Move move = TaskPermissions.Move.fromValue(moveValue);
        boolean complete = node.get("complete").asBoolean();
        boolean sendMessages = node.get("sendMessages").asBoolean();
        boolean sendFiles = node.get("sendFiles").asBoolean();
        String editWhoToNotifyValue = node.get("editWhoToNotify").asText();
        TaskPermissions.EditWhoToNotify editWhoToNotify = TaskPermissions.EditWhoToNotify.fromValue(editWhoToNotifyValue);
        return new TaskPermissions(show, delete, editTitle, editDescription, complete, close, assignUsers, connect,
                editSubtasks, editStickers, editPins, move, sendMessages, sendFiles, editWhoToNotify);
    }
}
