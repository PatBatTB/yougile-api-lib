package io.github.patbattb.yougileapilib.http.deserialize;

import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.JsonDeserializer;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.json.JsonMapper;
import io.github.patbattb.yougileapilib.domain.Board;
import io.github.patbattb.yougileapilib.domain.BoardStickerInfo;

import java.io.IOException;

public class BoardDeserializer extends JsonDeserializer<Board> {
    @Override
    public Board deserialize(JsonParser p, DeserializationContext ctxt) throws IOException {
        JsonNode node = p.readValueAsTree();
        JsonNode deletedNode = node.get("deleted");
        boolean deleted = (deletedNode != null) && deletedNode.asBoolean();
        String id = node.get("id").asText();
        String title = node.get("title").asText();
        String projectId = node.get("projectId").asText();
        JsonNode stickersNode = node.get("stickers");
        JsonMapper mapper = new JsonMapper();
        BoardStickerInfo stickers = (stickersNode == null) ?
                null :
                mapper.readValue(stickersNode.toString(), BoardStickerInfo.class);
        return new Board(deleted, id, title, projectId, stickers);
    }
}
