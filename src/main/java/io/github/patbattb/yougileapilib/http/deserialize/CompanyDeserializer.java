package io.github.patbattb.yougileapilib.http.deserialize;

import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.JsonDeserializer;
import com.fasterxml.jackson.databind.JsonNode;
import io.github.patbattb.yougileapilib.domain.Company;

import java.io.IOException;

public class CompanyDeserializer extends JsonDeserializer<Company> {
    @Override
    public Company deserialize(JsonParser p, DeserializationContext ctxt) throws IOException {
        JsonNode node = p.readValueAsTree();
        boolean deleted = false;
        JsonNode deletedNode = node.get("deleted");
        if (deletedNode != null) {
            deleted = deletedNode.asBoolean();
        }
        String id = node.get("id").asText();
        String title = node.get("title").asText();
        long created = node.get("timestamp").asLong();
        return new Company(deleted, id, title, created);
    }
}
