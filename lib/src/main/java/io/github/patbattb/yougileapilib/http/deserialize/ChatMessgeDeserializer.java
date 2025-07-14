package io.github.patbattb.yougileapilib.http.deserialize;

import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.JsonDeserializer;
import com.fasterxml.jackson.databind.JsonNode;
import io.github.patbattb.yougileapilib.domain.ChatMessage;
import io.github.patbattb.yougileapilib.domain.Reaction;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class ChatMessgeDeserializer extends JsonDeserializer<ChatMessage> {
    @Override
    public ChatMessage deserialize(JsonParser p, DeserializationContext ctxt) throws IOException {
        JsonNode rootNode = p.readValueAsTree();
        JsonNode deletedNode = rootNode.get("deleted");
        boolean deleted = (deletedNode != null) && deletedNode.asBoolean();
        String id = rootNode.get("id").asText();
        String fromUserId = rootNode.get("fromUserId").asText();
        String text = rootNode.get("text").asText();
        JsonNode labelNode = rootNode.get("label");
        String label = labelNode == null ? null : labelNode.asText();
        JsonNode editTimestampNode = rootNode.get("editTimestamp");
        Long editTimestamp = editTimestampNode == null ? null : editTimestampNode.asLong();
        String textHtml = null;
        JsonNode propertiesNode = rootNode.get("properties");
        if (propertiesNode != null) {
            JsonNode textHtmlNode = propertiesNode.get("textHtml");
            if (textHtmlNode != null) {
                textHtml = textHtmlNode.asText();
            }
        }
        List<Reaction> reactions = new ArrayList<>();
        JsonNode reactionsNode = rootNode.get("reactions");
        if (reactionsNode != null) {
            reactionsNode.propertyStream().forEach( entry -> {
                for (JsonNode node: entry.getValue()) {
                    Reaction reaction = new Reaction(
                            entry.getKey(),
                            node.get("smiley").asText(),
                            node.get("timestamp").asLong()
                    );
                    reactions.add(reaction);
                }
            });
        }

        return new ChatMessage(deleted, id, fromUserId, text, textHtml, label, editTimestamp, reactions);
    }
}
