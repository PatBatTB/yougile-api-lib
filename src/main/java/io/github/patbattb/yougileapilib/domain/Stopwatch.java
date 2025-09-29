package io.github.patbattb.yougileapilib.domain;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import io.github.patbattb.yougileapilib.http.deserialize.StopwatchDeserializer;
import lombok.*;
import lombok.experimental.FieldDefaults;

/**
 * Stopwatch on the {@link Task}.
 *
 */
@Getter
@FieldDefaults(level = AccessLevel.PRIVATE)
@AllArgsConstructor
@EqualsAndHashCode
@ToString
@JsonDeserialize(using = StopwatchDeserializer.class)
public class Stopwatch {
    /**
     * Stopwatch status - started (true) / stopped (false)
     */
    boolean running;
    /**
     * How many seconds have passed while the timer was running.
     */
    int seconds;
    /**
     * The point in time at which the seconds value was relevant
     */
    long atMoment;
}
