package io.github.patbattb.yougileapilib.domain;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import io.github.patbattb.yougileapilib.http.deserialize.DeadlineDeserializer;
import lombok.*;
import lombok.experimental.FieldDefaults;

import java.util.List;

@Getter
@FieldDefaults(level = AccessLevel.PRIVATE)
@AllArgsConstructor
@EqualsAndHashCode
@ToString
@JsonDeserialize(using = DeadlineDeserializer.class)
public class Deadline {
    long deadline;
    Long startDate;
    Boolean withTime;
    List<String> history;
    List<String> blockedPoints;
    List<String> links;
}
