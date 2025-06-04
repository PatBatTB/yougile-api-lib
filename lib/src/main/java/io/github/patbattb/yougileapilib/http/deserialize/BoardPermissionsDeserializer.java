package io.github.patbattb.yougileapilib.http.deserialize;

import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.JsonDeserializer;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.json.JsonMapper;
import io.github.patbattb.yougileapilib.domain.BoardPermissions;
import io.github.patbattb.yougileapilib.domain.ColumnPermissions;

import java.io.IOException;

public class BoardPermissionsDeserializer extends JsonDeserializer<BoardPermissions> {
    @Override
    public BoardPermissions deserialize(JsonParser p, DeserializationContext ctxt) throws IOException {
        JsonNode node = p.readValueAsTree();
        boolean editTitle = node.get("editTitle").asBoolean();
        boolean delete = node.get("delete").asBoolean();
        boolean move = node.get("move").asBoolean();
        boolean showStickers = node.get("showStickers").asBoolean();
        boolean editStickers = node.get("editStickers").asBoolean();
        boolean addColumn = node.get("addColumn").asBoolean();
        JsonMapper mapper = new JsonMapper();
        ColumnPermissions columnPermissions = mapper.readValue(node.get("columns").toString(), ColumnPermissions.class);
        boolean settings = node.get("settings").asBoolean();
        return new BoardPermissions(editTitle, delete, move, showStickers, editStickers, addColumn, columnPermissions, settings);
    }
}
