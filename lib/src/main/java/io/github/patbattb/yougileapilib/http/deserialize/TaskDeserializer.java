package io.github.patbattb.yougileapilib.http.deserialize;

import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.JsonDeserializer;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.json.JsonMapper;
import io.github.patbattb.yougileapilib.domain.*;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class TaskDeserializer extends JsonDeserializer<Task> {
    @Override
    public Task deserialize(JsonParser p, DeserializationContext ctxt) throws IOException {
        JsonNode rootNode = p.readValueAsTree();
        JsonNode currentNode = rootNode.get("deleted");
        boolean deleted = (currentNode != null) && currentNode.asBoolean();
        String id = rootNode.get("id").asText();
        String title = rootNode.get("title").asText();
        long created = rootNode.get("timestamp").asLong();
        currentNode = rootNode.get("columnId");
        String columnId = (currentNode == null) ? null : currentNode.asText();
        currentNode = rootNode.get("description");
        String description = (currentNode == null) ? null : currentNode.asText();
        currentNode = rootNode.get("archived");
        boolean archived = (currentNode != null) && currentNode.asBoolean();
        currentNode = rootNode.get("archivedTimestamp");
        Long archivedTimestamp = (currentNode == null) ? null : currentNode.asLong();
        currentNode = rootNode.get("completed");
        boolean completed = (currentNode != null) && currentNode.asBoolean();
        currentNode = rootNode.get("completedTimestamp");
        Long completedTimestamp = (currentNode == null) ? null : currentNode.asLong();
        currentNode = rootNode.get("subtasks");
        List<String> subtaskList = new ArrayList<>();
        if (currentNode != null && currentNode.isArray()) {
            for (JsonNode node: currentNode) {
                subtaskList.add(node.asText());
            }
        }
        currentNode = rootNode.get("assigned");
        List<String> assignedList = new ArrayList<>();
        if (currentNode != null && currentNode.isArray()) {
            for (JsonNode node: currentNode) {
                assignedList.add(node.asText());
            }
        }
        currentNode = rootNode.get("createdBy");
        String createdBy = (currentNode == null) ? null : currentNode.asText();
        JsonMapper mapper = new JsonMapper();
        currentNode = rootNode.get("deadline");
        Deadline deadline = (currentNode == null) ? null : mapper.readValue(currentNode.toString(), Deadline.class);
        currentNode = rootNode.get("timeTracking");
        TimeTracking timeTracking = (currentNode == null) ? null : mapper.readValue(currentNode.toString(), TimeTracking.class);
        currentNode = rootNode.get("checklists");
        List<Checklist> checklists = new ArrayList<>();
        if (currentNode != null && currentNode.isArray()) {
            for (JsonNode node: currentNode) {
                checklists.add(mapper.readValue(node.toString(), Checklist.class));
            }
        }
        currentNode = rootNode.get("stickers");
        Map<String, String> stickers = new HashMap<>();
        if (currentNode != null && currentNode.isContainerNode()) {
            for (Map.Entry<String, JsonNode> entry: currentNode.properties()) {
                stickers.put(entry.getKey(), entry.getValue().asText());
            }
        }
        currentNode = rootNode.get("color");
        String color = (currentNode == null) ? null : currentNode.asText();
        currentNode = rootNode.get("idTaskCommon");
        String idTaskCommon = (currentNode == null) ? null : currentNode.asText();
        currentNode = rootNode.get("idTaskProject");
        String idTaskProject = (currentNode == null) ? null : currentNode.asText();
        currentNode = rootNode.get("stopwatch");
        Stopwatch stopwatch = (currentNode == null) ? null : mapper.readValue(currentNode.toString(), Stopwatch.class);
        currentNode = rootNode.get("timer");
        Timer timer = (currentNode == null) ? null : mapper.readValue(currentNode.toString(), Timer.class);
        return new Task(deleted, id, title,created, columnId, description, archived, archivedTimestamp, completed,
                completedTimestamp, subtaskList, assignedList, createdBy, deadline, timeTracking, checklists, stickers,
                color, idTaskCommon, idTaskProject, stopwatch, timer);
    }
}
