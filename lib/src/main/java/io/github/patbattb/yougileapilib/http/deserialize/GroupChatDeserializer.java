package io.github.patbattb.yougileapilib.http.deserialize;

import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.JsonDeserializer;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.json.JsonMapper;
import io.github.patbattb.yougileapilib.domain.GroupChat;
import io.github.patbattb.yougileapilib.domain.GroupChatUser;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class GroupChatDeserializer extends JsonDeserializer<GroupChat> {
    @Override
    public GroupChat deserialize(JsonParser p, DeserializationContext ctxt) throws IOException {
        JsonNode rootNode = p.readValueAsTree();
        JsonNode deletedNode = rootNode.get("deleted");
        boolean deleted = (deletedNode != null) && deletedNode.asBoolean();
        String id = rootNode.get("id").asText();
        String title = rootNode.get("title").asText();
        List<GroupChatUser> users = new ArrayList<>();
        JsonNode usersNode = rootNode.get("users");
        JsonMapper mapper = new JsonMapper();
        usersNode.propertyStream().forEach(entry ->
                    users.add(new GroupChatUser(entry.getKey(), entry.getValue().get("notified").asBoolean())));
        return new GroupChat(deleted, id, title, users);
    }
}
