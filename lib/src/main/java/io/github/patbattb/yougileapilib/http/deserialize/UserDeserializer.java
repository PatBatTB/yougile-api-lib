package io.github.patbattb.yougileapilib.http.deserialize;

import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.JsonDeserializer;
import com.fasterxml.jackson.databind.JsonNode;
import io.github.patbattb.yougileapilib.domain.User;

import java.io.IOException;

public class UserDeserializer extends JsonDeserializer<User> {
    @Override
    public User deserialize(JsonParser p, DeserializationContext ctxt) throws IOException {
        JsonNode node = p.readValueAsTree();
        String id = node.get("id").asText();
        String email = node.get("email").asText();
        boolean isAdmin = node.get("isAdmin").asBoolean();
        String realName = node.get("realName").asText();
        String status = node.get("status").asText();
        long lastActivity = node.get("lastActivity").asLong();
        return new User(id, email, isAdmin, realName, status, lastActivity);
    }
}
