package io.github.patbattb.yougileapilib.domain;

import lombok.*;
import lombok.experimental.FieldDefaults;

/**
 * History point of the {@link Deadline}
 */
@Getter
@FieldDefaults(level = AccessLevel.PRIVATE)
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode
@ToString
public class DeadlineHistory {
    /**
     * Deadline timestamp.
     */
    long deadline;
    /**
     * Timestamp of history point.
     */
    long timestamp;
    /**
     * Time of the reminder in millis.
     * How long before the deadline should reminder needs to set?
     */
    long notifyBefore;
    /**
     * Should the time be displayed on the sticker? If it's {@code false}, then only date
     */
    boolean withTime;
    /**
     * ID of user that changed current deadline sticker.
     */
    String by;
    /**
     * Start of the task timestamp.
     */
    Long startDate;
}
