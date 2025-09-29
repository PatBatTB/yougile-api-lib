package io.github.patbattb.yougileapilib.http.deserialize;

import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.JsonDeserializer;
import com.fasterxml.jackson.databind.JsonNode;
import io.github.patbattb.yougileapilib.domain.Timer;

import java.io.IOException;

public class TimerDeserializer extends JsonDeserializer<Timer> {
    @Override
    public Timer deserialize(JsonParser p, DeserializationContext ctxt) throws IOException {
        JsonNode node = p.readValueAsTree();
        int seconds = node.get("seconds").asInt();
        long since = node.get("since").asLong();
        boolean running = node.get("running").asBoolean();
        return new Timer(seconds, since, running);
    }
}
