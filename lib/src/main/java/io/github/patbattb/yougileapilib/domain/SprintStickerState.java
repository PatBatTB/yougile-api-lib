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
@NoArgsConstructor
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
    long begin;
    /**
     * Timestamp of the sprint end.
     */
    long end;

    /**
     * Sets timestamp of the sprint start.
     * @param value value can't be lesser than zero or bigger than {@link SprintStickerState#end}
     */
    public void begin(long value) {
        validateTimestamp(value, end);
        this.begin = value;
    }

    /**
     * Sets timestamp of the spirit end.
     * @param value value can't be lesser than zero or {@link SprintStickerState#begin}
     */
    public void end(long value) {
        validateTimestamp(begin, value);
        this.end = value;
    }

    public static void validateTimestamp(long beginValue, long endValue) {
        if (beginValue < 0 || endValue < 0) {
            throw new IllegalArgumentException("Time value can't be lesser than zero.");
        }
        if (beginValue > endValue) {
            throw new IllegalArgumentException("Begin time can't be bigger than end time.");
        }
    }
}
