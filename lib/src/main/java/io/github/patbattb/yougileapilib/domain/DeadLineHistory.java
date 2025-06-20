package io.github.patbattb.yougileapilib.domain;

import lombok.*;
import lombok.experimental.FieldDefaults;

@Getter
@FieldDefaults(level = AccessLevel.PRIVATE)
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode
@ToString
public class DeadLineHistory {
    long deadline;
    long timestamp;
    long notifyBefore;
    boolean withTime;
    String by;
    Long startDate;
}
