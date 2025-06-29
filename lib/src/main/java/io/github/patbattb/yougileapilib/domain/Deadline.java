package io.github.patbattb.yougileapilib.domain;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import io.github.patbattb.yougileapilib.http.deserialize.DeadlineDeserializer;
import lombok.*;
import lombok.experimental.FieldDefaults;

import java.util.List;

/**
 * The deadline sticker of the {@link Task}
 * The Deadline sticker. Indicates the deadline for completing the task.
 * In addition to the deadline date, it is possible to specify the time and the start date of the task.
 */
@Getter
@FieldDefaults(level = AccessLevel.PRIVATE)
@EqualsAndHashCode
@ToString
@NoArgsConstructor
@AllArgsConstructor
@JsonDeserialize(using = DeadlineDeserializer.class)
public class Deadline {
    /**
     * Deadline timestamp.
     */
    @Setter
    Long deadline;
    /**
     * Start of the task timestamp.
     */
    @Setter
    Long startDate;
    /**
     * Should the time be displayed on the sticker? If it's {@code false}, then only date
     */
    @Setter
    Boolean withTime;
    /**
     * Deadline change history.
     */
    List<DeadlineHistory> history;
    /**
     * Points that block the deadline date (Start or End).
     */
    List<String> blockedPoints;
    /**
     * Linked tasks.
     */
    List<String> links;

    public Deadline(Long deadline, Long startDate, Boolean withTime) {
        this.deadline = deadline;
        this.startDate = startDate;
        this.withTime = withTime;
    }

}
