package io.github.patbattb.yougileapilib.http.deserialize;

import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.JsonDeserializer;
import com.fasterxml.jackson.databind.JsonNode;
import io.github.patbattb.yougileapilib.domain.StringStickerState;

import java.io.IOException;

public class StringStickerStateDeserializer extends JsonDeserializer<StringStickerState> {
    @Override
    public StringStickerState deserialize(JsonParser p, DeserializationContext ctxt) throws IOException {
        JsonNode rootNode = p.readValueAsTree();
        JsonNode deletedNode = rootNode.get("deleted");
        boolean deleted = (deletedNode != null) && deletedNode.asBoolean();
        String id = rootNode.get("id").asText();
        String name = rootNode.get("name").asText();
        String colorValue = rootNode.get("color").asText();
        return new StringStickerState(deleted, id, name, StringStickerState.Color.fromValue(colorValue));
    }
}
