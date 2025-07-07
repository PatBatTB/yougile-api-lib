package io.github.patbattb.yougileapilib.domain;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import io.github.patbattb.yougileapilib.http.deserialize.TimerDeserializer;
import lombok.*;
import lombok.experimental.FieldDefaults;

/**
 * The timer represents a time counter with a countdown that is set for a {@link Task}.
 */
@Getter
@FieldDefaults(level = AccessLevel.PRIVATE)
@AllArgsConstructor
@EqualsAndHashCode
@ToString
@JsonDeserialize(using = TimerDeserializer.class)
public class Timer {
    /**
     * How many seconds remain for the timer finish.
     */
    int seconds;
    /**
     * Timestamp of the timer start.
     */
    long since;
    /**
     * Timer status - running / stopped.
     */
    boolean running;
}
