package io.github.patbattb.yougileapilib.http.deserialize;

import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.JsonDeserializer;
import com.fasterxml.jackson.databind.JsonNode;
import io.github.patbattb.yougileapilib.domain.AuthKey;

import java.io.IOException;

public class AuthKeyDeserializer extends JsonDeserializer<AuthKey> {

    @Override
    public AuthKey deserialize(JsonParser p, DeserializationContext ctxt) throws IOException {
        JsonNode node = p.readValueAsTree();
        String key = node.get("key").asText();
        return new AuthKey(key);
    }
}
