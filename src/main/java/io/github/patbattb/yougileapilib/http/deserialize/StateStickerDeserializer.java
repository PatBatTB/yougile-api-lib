package io.github.patbattb.yougileapilib.http.deserialize;

import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.JsonDeserializer;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.json.JsonMapper;
import io.github.patbattb.yougileapilib.domain.StateSticker;
import io.github.patbattb.yougileapilib.domain.StateStickerState;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class StateStickerDeserializer extends JsonDeserializer<StateSticker> {
    @Override
    public StateSticker deserialize(JsonParser p, DeserializationContext ctxt) throws IOException {
        JsonNode rootNode = p.readValueAsTree();
        String id = rootNode.get("id").asText();
        JsonNode deletedNode = rootNode.get("deleted");
        boolean deleted = (deletedNode != null) && deletedNode.asBoolean();
        String name = rootNode.get("name").asText();
        String iconValue = rootNode.get("icon").asText();
        StateSticker.Icon icon = StateSticker.Icon.fromValue(iconValue);
        List<StateStickerState> states = new ArrayList<>();
        JsonNode statesNode = rootNode.get("states");
        JsonMapper mapper = new JsonMapper();
        if (statesNode != null) {
            for (JsonNode node: statesNode) {
                states.add(mapper.readValue(node.toString(), StateStickerState.class));
            }
        }
        return new StateSticker(id, deleted, name, icon, states);
    }
}
