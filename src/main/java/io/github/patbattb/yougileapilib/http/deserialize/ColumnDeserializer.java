package io.github.patbattb.yougileapilib.http.deserialize;

import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.JsonDeserializer;
import com.fasterxml.jackson.databind.JsonNode;
import io.github.patbattb.yougileapilib.domain.Column;

import java.io.IOException;

public class ColumnDeserializer extends JsonDeserializer<Column> {
    @Override
    public Column deserialize(JsonParser p, DeserializationContext ctxt) throws IOException {
        JsonNode node = p.readValueAsTree();
        String id = node.get("id").asText();
        JsonNode deletedNode = node.get("deleted");
        boolean deleted = deletedNode != null && deletedNode.asBoolean();
        String title = node.get("title").asText();
        JsonNode colorNode = node.get("color");
        Integer color = colorNode == null ? null : colorNode.asInt();
        String boardId = node.get("boardId").asText();
        return new Column(deleted, id, title, color, boardId);
    }
}
