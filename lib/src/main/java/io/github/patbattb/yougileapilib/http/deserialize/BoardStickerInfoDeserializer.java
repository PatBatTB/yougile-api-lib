package io.github.patbattb.yougileapilib.http.deserialize;

import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.JsonDeserializer;
import com.fasterxml.jackson.databind.JsonNode;
import io.github.patbattb.yougileapilib.domain.BoardStickerInfo;
import io.github.patbattb.yougileapilib.domain.CustomSticker;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class BoardStickerInfoDeserializer extends JsonDeserializer<BoardStickerInfo> {
    @Override
    public BoardStickerInfo deserialize(JsonParser p, DeserializationContext ctxt) throws IOException {
        JsonNode node = p.readValueAsTree();
        JsonNode timerNode = node.get("timer");
        boolean timer = timerNode != null && timerNode.asBoolean();
        JsonNode deadlineNode = node.get("deadline");
        boolean deadline = deadlineNode != null && deadlineNode.asBoolean();
        JsonNode stopwatchNode = node.get("stopwatch");
        boolean stopwatch = stopwatchNode != null && stopwatchNode.asBoolean();
        JsonNode timeTrackingNode = node.get("timeTracking");
        boolean timeTracking = timeTrackingNode != null && timeTrackingNode.asBoolean();
        JsonNode assigneeNode = node.get("assignee");
        boolean assignee = assigneeNode != null && assigneeNode.asBoolean();
        JsonNode repeatNode = node.get("repeat");
        boolean repeat = repeatNode != null && repeatNode.asBoolean();
        JsonNode customNode = node.get("custom");
        List<CustomSticker> customStickers = new ArrayList<>();
        if (customNode != null) {
            for (Map.Entry<String, JsonNode> entry: customNode.properties()) {
                customStickers.add(new CustomSticker(entry.getKey(), entry.getValue().asBoolean()));
            }
        }
        return new BoardStickerInfo(timer, deadline, stopwatch, timeTracking, assignee, repeat, customStickers);
    }
}
