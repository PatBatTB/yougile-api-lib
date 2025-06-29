package io.github.patbattb.yougileapilib.domain;

import lombok.*;
import lombok.experimental.FieldDefaults;

import java.util.List;

/**
 * Entity of sprint-sticker available on the {@link Board}
 */
@Getter
@FieldDefaults(level = AccessLevel.PRIVATE)
@AllArgsConstructor
@EqualsAndHashCode
@ToString
public class SprintSticker {
    /**
     * Sprint-sticker ID.
     */
    String id;
    /**
     * If true, then the sprint-sticker has been deleted.
     */
    @Setter
    boolean deleted;
    /**
     * Sprint-sticker name.
     */
    @Setter
    String name;
    /**
     * List of the sprint-sticker states.
     */
    List<SprintStickerState> states;
}
