package io.github.patbattb.yougileapilib.http.deserialize;

import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.JsonDeserializer;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.json.JsonMapper;
import io.github.patbattb.yougileapilib.domain.ProjectPermissions;
import io.github.patbattb.yougileapilib.domain.ProjectRole;

import java.io.IOException;

public class ProjectRoleDeserializer extends JsonDeserializer<ProjectRole> {
    @Override
    public ProjectRole deserialize(JsonParser p, DeserializationContext ctxt) throws IOException {
        JsonNode node = p.readValueAsTree();
        String id = node.get("id").asText();
        String name = node.get("name").asText();
        JsonNode descriptionNode = node.get("description");
        String description = descriptionNode == null ? null : descriptionNode.asText();
        JsonMapper mapper = new JsonMapper();
        ProjectPermissions projectPermissions = mapper.readValue(node.get("permissions").toString(), ProjectPermissions.class);
        return new ProjectRole(id, name, description, projectPermissions);
    }
}
