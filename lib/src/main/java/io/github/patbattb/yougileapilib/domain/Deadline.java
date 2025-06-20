package io.github.patbattb.yougileapilib.domain;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import io.github.patbattb.yougileapilib.http.deserialize.DeadlineDeserializer;
import lombok.*;
import lombok.experimental.FieldDefaults;

import java.util.List;

@Getter
@FieldDefaults(level = AccessLevel.PRIVATE)
@EqualsAndHashCode
@ToString
@NoArgsConstructor
@AllArgsConstructor
@JsonDeserialize(using = DeadlineDeserializer.class)
public class Deadline {
    @Setter
    Long deadline;
    @Setter
    Long startDate;
    @Setter
    Boolean withTime;
    List<DeadLineHistory> history;
    List<String> blockedPoints;
    List<String> links;

    public Deadline(Long deadline, Long startDate, Boolean withTime) {
        this.deadline = deadline;
        this.startDate = startDate;
        this.withTime = withTime;
    }

}
