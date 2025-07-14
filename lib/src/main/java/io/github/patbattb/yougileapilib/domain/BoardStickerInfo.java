package io.github.patbattb.yougileapilib.domain;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import io.github.patbattb.yougileapilib.http.deserialize.BoardStickerInfoDeserializer;
import io.github.patbattb.yougileapilib.http.serialize.BoardStickerInfoSerializer;
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
@JsonSerialize(using = BoardStickerInfoSerializer.class)
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
     * ATTENTION! Works state-stickers and sprint-stickers only.
     * Server returns error 404, if other-typed sticker has been sent.
     * This can lead to a situation where you get a Board object and pass it to the update method, but you get error 404.
     * This is because it is possible to obtain the ID of a custom sticker through the API, but not to transmit it.
     * Technical support reported that this was a bug, and there was no way to check the sticker for validity.
     * To ensure correct operation, you must transfer an object with an empty stickers field, or be sure that only state stickers or sprint stickers are recorded in this field.
     */
    List<CustomSticker> custom;
}
