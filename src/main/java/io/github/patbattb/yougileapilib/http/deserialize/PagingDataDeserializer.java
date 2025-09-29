package io.github.patbattb.yougileapilib.http.deserialize;

import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.JsonDeserializer;
import com.fasterxml.jackson.databind.JsonNode;
import io.github.patbattb.yougileapilib.domain.PagingData;

import java.io.IOException;

public class PagingDataDeserializer extends JsonDeserializer<PagingData> {
    @Override
    public PagingData deserialize(JsonParser p, DeserializationContext ctxt) throws IOException {
        JsonNode node = p.readValueAsTree();
        int count = node.get("count").asInt();
        int limit = node.get("limit").asInt();
        int offset = node.get("offset").asInt();
        boolean next = node.get("next").asBoolean();
        return new PagingData(count, limit, offset, next);
    }
}
