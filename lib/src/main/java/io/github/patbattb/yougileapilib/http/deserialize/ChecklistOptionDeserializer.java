package io.github.patbattb.yougileapilib.http.deserialize;

import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.JsonDeserializer;
import com.fasterxml.jackson.databind.JsonNode;
import io.github.patbattb.yougileapilib.domain.ChecklistOption;

import java.io.IOException;

public class ChecklistOptionDeserializer extends JsonDeserializer<ChecklistOption> {
    @Override
    public ChecklistOption deserialize(JsonParser p, DeserializationContext ctxt) throws IOException {
        JsonNode node = p.readValueAsTree();
        String title = node.get("title").asText();
        boolean isCompleted = node.get("isCompleted").asBoolean();
        return new ChecklistOption(title, isCompleted);
    }
}
