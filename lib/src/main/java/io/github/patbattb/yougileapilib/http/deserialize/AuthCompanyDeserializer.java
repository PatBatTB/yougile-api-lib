package io.github.patbattb.yougileapilib.http.deserialize;

import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.JsonDeserializer;
import com.fasterxml.jackson.databind.JsonNode;
import io.github.patbattb.yougileapilib.domain.AuthCompany;

import java.io.IOException;

public class AuthCompanyDeserializer extends JsonDeserializer<AuthCompany> {

    @Override
    public AuthCompany deserialize(JsonParser p, DeserializationContext ctxt) throws IOException {
        JsonNode node = p.readValueAsTree();
            String id = node.get("id").asText();
            String name = node.get("name").asText();
            boolean isAdmin = node.get("isAdmin").asBoolean();
            return new AuthCompany(id, name, isAdmin);
    }
}
