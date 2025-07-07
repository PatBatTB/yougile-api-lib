package io.github.patbattb.yougileapilib.domain;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import io.github.patbattb.yougileapilib.http.deserialize.BoardStickerInfoDeserializer;
import lombok.*;
import lombok.experimental.FieldDefaults;

import java.util.List;

/**
 * The info of stickers available on the {@link Board}
 * The field equals {@code true} if the appropriate sticker is available.
 */
@Getter
@FieldDefaults(level = AccessLevel.PRIVATE)
@AllArgsConstructor
@EqualsAndHashCode
@ToString
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonDeserialize(using = BoardStickerInfoDeserializer.class)
public class BoardStickerInfo {
    /**
     * Is available a timer on the board?
     */
    boolean timer;
    /**
     * Is available a deadline on the board?
     */
    boolean deadline;
    /**
     * Is available a stopwatch on the board?
     */
    boolean stopwatch;
    /**
     * Is available a time tracking on the board?
     */
    boolean timeTracking;
    /**
     * Is it possible to assign performers to tasks on the board?
     */
    boolean assignee;
    /**
     * Are regular tasks available on the board?
     */
    boolean repeat;
    /**
     * Custom board stickers.
     */
    @JsonProperty("custom")
    List<CustomSticker> stickers;
}
