package io.github.patbattb.yougileapilib.domain;

import lombok.*;
import lombok.experimental.FieldDefaults;

/**
 * The state of the {@link TextSticker}.
 */
@Getter
@FieldDefaults(level = AccessLevel.PRIVATE)
@AllArgsConstructor
@EqualsAndHashCode
@ToString
public class TextStickerState {
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
     * State color.
     */
    @Setter
    String color;
}
