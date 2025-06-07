package io.github.patbattb.yougileapilib.http.deserialize;

import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.JsonDeserializer;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.json.JsonMapper;
import io.github.patbattb.yougileapilib.domain.Checklist;
import io.github.patbattb.yougileapilib.domain.Checkpoint;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class ChecklistDeserializer extends JsonDeserializer<Checklist> {
    @Override
    public Checklist deserialize(JsonParser p, DeserializationContext ctxt) throws IOException {
        JsonNode rootNode = p.readValueAsTree();
        String title = rootNode.get("title").asText();
        JsonNode currentNode = rootNode.get("items");
        List<Checkpoint> checkpoints = new ArrayList<>();
        if (currentNode != null && currentNode.isArray()) {
            JsonMapper mapper = new JsonMapper();
            for (JsonNode node: currentNode) {
                checkpoints.add(mapper.readValue(node.toString(), Checkpoint.class));
            }
        }
        return new Checklist(title, checkpoints);
    }
}
