package io.github.patbattb.yougileapilib.domain;

import lombok.*;
import lombok.experimental.FieldDefaults;

/**
 * State of the {@link SprintSticker}.
 * The sprint sticker state indicates the start date and the end date of the sprint.
 * After creation, the state of the sprint sticker can be assigned to some {@link SprintSticker}.
 */
@Getter
@FieldDefaults(level = AccessLevel.PRIVATE)
@AllArgsConstructor
@EqualsAndHashCode
@ToString
public class SprintStickerState {
    /**
     * If true, then state has been deleted.
     */
    @Setter
    boolean deleted;
    /**
     * State ID.
     */
    String id;
    /**
     * State name.
     */
    @Setter
    String name;
    /**
     * Timestamp of the sprint start.
     */
    @Setter
    long begin;
    /**
     * Timestamp of the sprint end.
     */
    @Setter
    long end;
}
