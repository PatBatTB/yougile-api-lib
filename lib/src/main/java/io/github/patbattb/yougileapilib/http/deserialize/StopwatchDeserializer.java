package io.github.patbattb.yougileapilib.http.deserialize;

import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.JsonDeserializer;
import com.fasterxml.jackson.databind.JsonNode;
import io.github.patbattb.yougileapilib.domain.Stopwatch;

import java.io.IOException;

public class StopwatchDeserializer extends JsonDeserializer<Stopwatch> {
    @Override
    public Stopwatch deserialize(JsonParser p, DeserializationContext ctxt) throws IOException {
        JsonNode node =  p.readValueAsTree();
        boolean running = node.get("running").asBoolean();
        int seconds = node.get("seconds").asInt();
        long atMoment = node.get("atMoment").asLong();
        return new Stopwatch(running, seconds, atMoment);
    }
}
