package io.github.patbattb.yougileapilib.http.deserialize;

import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.JsonDeserializer;
import com.fasterxml.jackson.databind.JsonNode;
import io.github.patbattb.yougileapilib.domain.AuthKeyDetails;

import java.io.IOException;

public class AuthKeyDetailsDeserializer extends JsonDeserializer<AuthKeyDetails> {

    @Override
    public AuthKeyDetails deserialize(JsonParser p, DeserializationContext ctxt) throws IOException {
        JsonNode node = p.readValueAsTree();
        String key = node.get("key").asText();
        long created = node.get("timestamp").asLong();
        String companyId = node.get("companyId").asText();

        return new AuthKeyDetails(key, companyId, created, false);
    }
}
