package io.github.patbattb.yougileapilib.http.deserialize;

import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.JsonDeserializer;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.json.JsonMapper;
import io.github.patbattb.yougileapilib.domain.Deadline;
import io.github.patbattb.yougileapilib.domain.DeadlineHistory;

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
        List<DeadlineHistory> historyList = new ArrayList<>();
        JsonMapper mapper = new JsonMapper();
        if (currentNode != null && currentNode.isArray()) {
            for(JsonNode node: currentNode) {
                historyList.add(mapper.readValue(node.toString(), DeadlineHistory.class));
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
