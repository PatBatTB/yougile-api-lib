package io.github.patbattb.yougileapilib.http.deserialize;

import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.JsonDeserializer;
import com.fasterxml.jackson.databind.JsonNode;
import io.github.patbattb.yougileapilib.domain.TimeTracking;

import java.io.IOException;

public class TimeTrackingDeserializer extends JsonDeserializer<TimeTracking> {
    @Override
    public TimeTracking deserialize(JsonParser p, DeserializationContext ctxt) throws IOException {
        JsonNode node = p.readValueAsTree();
        int plan = node.get("plan").asInt();
        int work = node.get("work").asInt();
        return new TimeTracking(plan, work);
    }
}
