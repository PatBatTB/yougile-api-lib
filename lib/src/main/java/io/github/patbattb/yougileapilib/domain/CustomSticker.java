package io.github.patbattb.yougileapilib.domain;

import lombok.*;
import lombok.experimental.FieldDefaults;

/**
 * The user-made {@link Board}'s sticker
 */
@Getter
@FieldDefaults(level = AccessLevel.PRIVATE)
@AllArgsConstructor
@EqualsAndHashCode
@ToString
public class CustomSticker {
    /**
     * Sticker ID.
     */
    String id;
    /**
     * If true that sticker is available.
     */
    boolean status;
}
