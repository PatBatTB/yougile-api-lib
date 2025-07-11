package io.github.patbattb.yougileapilib.http.serialize;

import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.databind.JsonSerializer;
import com.fasterxml.jackson.databind.SerializerProvider;
import io.github.patbattb.yougileapilib.domain.BoardStickerInfo;
import io.github.patbattb.yougileapilib.domain.CustomSticker;

import java.io.IOException;

public class BoardStickerInfoSerializer extends JsonSerializer<BoardStickerInfo> {
    @Override
    public void serialize(BoardStickerInfo value, JsonGenerator gen, SerializerProvider serializerProvider) throws IOException {
        gen.writeStartObject();
        gen.writeBooleanField("timer", value.isTimer());
        gen.writeBooleanField("deadline", value.isDeadline());
        gen.writeBooleanField("stopwatch", value.isStopwatch());
        gen.writeBooleanField("timeTracking", value.isTimeTracking());
        gen.writeBooleanField("assignee", value.isAssignee());
        gen.writeBooleanField("repeat", value.isRepeat());
        gen.writeFieldName("custom");
        gen.writeStartObject();
        for (CustomSticker sticker: value.getStickers()) {
            gen.writeBooleanField(sticker.getId(), sticker.getStatus());
        }
        gen.writeEndObject();
        gen.writeEndObject();
    }
}
