package io.github.patbattb.yougileapilib.domain;

import lombok.*;
import lombok.experimental.FieldDefaults;

/**
 * The reaction for chat message.
 */
@Getter
@FieldDefaults(level = AccessLevel.PRIVATE)
@AllArgsConstructor
@EqualsAndHashCode
@ToString
public class Reaction {
    /**
     * Reaction author ID.
     */
    final String fromUserId;

    /**
     * Reaction emoji.
     */
    @Setter
    String smiley;

    long timestamp;
}
