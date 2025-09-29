package io.github.patbattb.yougileapilib.http.deserialize;

import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.JsonDeserializer;
import com.fasterxml.jackson.databind.JsonNode;
import io.github.patbattb.yougileapilib.domain.Department;
import io.github.patbattb.yougileapilib.domain.DepartmentUser;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class DepartmentDeserializer extends JsonDeserializer<Department> {
    @Override
    public Department deserialize(JsonParser p, DeserializationContext ctxt) throws IOException {
        JsonNode node = p.readValueAsTree();

        JsonNode deletedNode = node.get("deleted");
        boolean deleted = (deletedNode != null) && deletedNode.asBoolean();


        String id = node.get("id").asText();
        String title = node.get("title").asText();

        List<DepartmentUser> userList = new ArrayList<>();
        JsonNode usersNode = node.get("users");
        if (usersNode != null) {
            for(Map.Entry<String, JsonNode> enty: usersNode.properties()) {
                userList.add(new DepartmentUser(enty.getKey(), DepartmentUser.RoleId.fromValue(enty.getValue().asText())));
            }
        }
        JsonNode parentIdNode = node.get("parentId");
        String parentId = (parentIdNode == null) ? null : parentIdNode.asText();

        return new Department(deleted, id, title, parentId, userList);
    }
}
