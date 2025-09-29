package io.github.patbattb.yougileapilib.http.deserialize;

import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.JsonDeserializer;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.json.JsonMapper;
import io.github.patbattb.yougileapilib.domain.BoardPermissions;
import io.github.patbattb.yougileapilib.domain.ProjectPermissions;

import java.io.IOException;

public class ProjectPermissionsDeserializer extends JsonDeserializer<ProjectPermissions> {
    @Override
    public ProjectPermissions deserialize(JsonParser p, DeserializationContext ctxt) throws IOException {
        JsonNode node = p.readValueAsTree();
        boolean editTitle = node.get("editTitle").asBoolean();
        boolean delete = node.get("delete").asBoolean();
        boolean addBoard = node.get("addBoard").asBoolean();
        JsonMapper mapper = new JsonMapper();
        BoardPermissions boardPermissions = mapper.readValue(node.get("boards").toString(), BoardPermissions.class);
        return new ProjectPermissions(editTitle, delete, addBoard, boardPermissions, null); //children as null
    }
}
