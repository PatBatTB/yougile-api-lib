package io.github.patbattb.yougileapilib.http.deserialize;

import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.JsonDeserializer;
import com.fasterxml.jackson.databind.JsonNode;
import io.github.patbattb.yougileapilib.domain.Project;
import io.github.patbattb.yougileapilib.domain.UserRole;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class ProjectDeserializer extends JsonDeserializer<Project> {
    @Override
    public Project deserialize(JsonParser p, DeserializationContext ctxt) throws IOException {
        JsonNode rootNode = p.readValueAsTree();
        String title = rootNode.get("title").asText();
        long created = rootNode.get("timestamp").asLong();
        List<UserRole> users = new ArrayList<>();
        JsonNode usersNode = rootNode.get("users");
        if (usersNode != null) {
            for (Map.Entry<String, JsonNode> prop : usersNode.properties()) {
                users.add(new UserRole(prop.getKey(), prop.getValue().asText()));
            }
        }
        String id = rootNode.get("id").asText();
        boolean deleted = false;
        JsonNode deletedNode = rootNode.get("deleted");
        if (deletedNode != null) {
            deleted = deletedNode.asBoolean();
        }
        return new Project(deleted, id, title, created, users);
    }
}
