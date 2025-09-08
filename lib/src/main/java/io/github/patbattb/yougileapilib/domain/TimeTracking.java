package io.github.patbattb.yougileapilib.domain;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import io.github.patbattb.yougileapilib.http.deserialize.TimeTrackingDeserializer;
import lombok.*;
import lombok.experimental.FieldDefaults;

/**
 * The "TimeTracking" sticker.
 * It is used to indicate the expected and real time for completing a task.
 */
@Getter
@FieldDefaults(level = AccessLevel.PRIVATE)
@AllArgsConstructor
@EqualsAndHashCode
@ToString
@JsonDeserialize(using = TimeTrackingDeserializer.class)
public class TimeTracking {
    /**
     * How many hours were scheduled to complete the task.
     */
    double plan;
    /**
     * How many hours were spent on the task.
     */
    double work;
}
