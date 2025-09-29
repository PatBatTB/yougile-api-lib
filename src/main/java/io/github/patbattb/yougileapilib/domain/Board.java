package io.github.patbattb.yougileapilib.domain;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import io.github.patbattb.yougileapilib.http.deserialize.BoardDeserializer;
import lombok.*;
import lombok.experimental.FieldDefaults;

/**
 * A board on which {@link Column} can be placed.
 * The board itself contains the ID of the {@link Project} to which it belongs.
 */
@Getter
@FieldDefaults(level = AccessLevel.PRIVATE)
@AllArgsConstructor
@EqualsAndHashCode
@ToString
@JsonDeserialize(using = BoardDeserializer.class)
public class Board {
    /**
     * If true, then the board has been deleted.
     */
    @Setter
    boolean deleted;
    /**
     * Board ID.
     */
    String id;
    /**
     * Board title.
     */
    @Setter
    String title;
    /**
     * Project ID where the board is located.
     */
    @Setter
    String projectId;
    /**
     * Board stickers.
     */
    @Setter
    BoardStickerInfo stickers;

}
