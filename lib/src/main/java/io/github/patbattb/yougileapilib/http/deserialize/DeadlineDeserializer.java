package io.github.patbattb.yougileapilib.http.deserialize;

import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.JsonDeserializer;
import com.fasterxml.jackson.databind.JsonNode;
import io.github.patbattb.yougileapilib.domain.Deadline;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class DeadlineDeserializer extends JsonDeserializer<Deadline> {
    @Override
    public Deadline deserialize(JsonParser p, DeserializationContext ctxt) throws IOException {
        JsonNode rootNode = p.readValueAsTree();
        long deadline = rootNode.get("deadline").asLong();
        JsonNode currentNode = rootNode.get("startDate");
        Long startDate = (currentNode == null) ? null : currentNode.asLong();
        currentNode = rootNode.get("withTime");
        Boolean withTime = (currentNode == null) ? null : currentNode.asBoolean();
        currentNode = rootNode.get("history");
        List<String> historyList = new ArrayList<>();
        if (currentNode != null && currentNode.isArray()) {
            for(JsonNode node: currentNode) {
                historyList.add(currentNode.asText());
            }
        }
        List<String> blockedPoints = new ArrayList<>();
        currentNode = rootNode.get("blockedPoints");
        if (currentNode != null && currentNode.isArray()) {
            for (JsonNode node: currentNode) {
                blockedPoints.add(node.asText());
            }
        }
        List<String> links = new ArrayList<>();
        currentNode = rootNode.get("links");
        if (currentNode != null && currentNode.isArray()) {
            for (JsonNode node: currentNode) {
                links.add(node.asText());
            }
        }
        return new Deadline(deadline, startDate, withTime, historyList, blockedPoints, links);
    }
}
