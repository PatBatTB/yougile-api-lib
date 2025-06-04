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
        String assignUsers = node.get("assignUsers").asText();
        boolean connect = node.get("connect").asBoolean();
        String editSubtasks = node.get("editSubtasks").asText();
        boolean editStickers = node.get("editStickers").asBoolean();
        boolean editPins = node.get("editPins").asBoolean();
        String move = node.get("move").asText();
        boolean complete = node.get("complete").asBoolean();
        boolean sendMessages = node.get("sendMessages").asBoolean();
        boolean sendFiles = node.get("sendFiles").asBoolean();
        String editWhoToNotify = node.get("editWhoToNotify").asText();
        return new TaskPermissions(show, delete, editTitle, editDescription, complete, close, assignUsers, connect,
                editSubtasks, editStickers, editPins, move, sendMessages, sendFiles, editWhoToNotify);
    }
}
