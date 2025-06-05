package io.github.patbattb.yougileapilib.domain;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import io.github.patbattb.yougileapilib.http.deserialize.BoardStickerInfoDeserializer;
import lombok.*;
import lombok.experimental.FieldDefaults;

import java.util.List;

@Getter
@FieldDefaults(level = AccessLevel.PRIVATE)
@AllArgsConstructor
@EqualsAndHashCode
@ToString
@JsonDeserialize(using = BoardStickerInfoDeserializer.class)
public class BoardStickerInfo {
    boolean timer;
    boolean deadline;
    boolean stopwatch;
    boolean timeTracking;
    boolean assignee;
    boolean repeat;
    List<CustomSticker> stickers;
}
