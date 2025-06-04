package io.github.patbattb.yougileapilib.http.deserialize;

import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.JsonDeserializer;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.json.JsonMapper;
import io.github.patbattb.yougileapilib.domain.ColumnPermissions;
import io.github.patbattb.yougileapilib.domain.TaskPermissions;

import java.io.IOException;

public class ColumnPermissionsDeserializer extends JsonDeserializer<ColumnPermissions> {
    @Override
    public ColumnPermissions deserialize(JsonParser p, DeserializationContext ctxt) throws IOException {
        JsonNode node = p.readValueAsTree();
        boolean editTitle = node.get("editTitle").asBoolean();
        boolean delete = node.get("delete").asBoolean();
        String move = node.get("move").asText();
        boolean addTask = node.get("addTask").asBoolean();
        JsonMapper mapper = new JsonMapper();
        TaskPermissions allTaskPermissions = mapper.readValue(node.get("allTasks").toString(), TaskPermissions.class);
        JsonNode withMeTasksNode = node.get("withMeTasks");
        JsonNode myTasks = node.get("myTasks");
        JsonNode createdByMeTasks = node.get("createdByMeTasks");
        TaskPermissions withMeTasksPermissions = (withMeTasksNode == null) ?
                null :
                mapper.readValue(withMeTasksNode.toString(), TaskPermissions.class);
        TaskPermissions myTasksPermissions = (myTasks == null) ?
                null :
                mapper.readValue(myTasks.toString(), TaskPermissions.class);
        TaskPermissions createdByMeTasksPermissions = (createdByMeTasks == null) ?
                null :
                mapper.readValue(createdByMeTasks.toString(), TaskPermissions.class);
        return new ColumnPermissions(editTitle, delete, move, addTask,
                allTaskPermissions, withMeTasksPermissions, myTasksPermissions, createdByMeTasksPermissions);
    }
}
