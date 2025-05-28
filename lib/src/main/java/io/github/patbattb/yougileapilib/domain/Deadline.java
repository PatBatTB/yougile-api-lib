package io.github.patbattb.yougileapilib.domain;

import lombok.*;
import lombok.experimental.FieldDefaults;

import java.util.List;

@Getter
@FieldDefaults(level = AccessLevel.PRIVATE)
@AllArgsConstructor
@EqualsAndHashCode
@ToString
public class Deadline {
    long deadline;
    long startDate;
    boolean withTime;
    List<String> history;
    List<String> blockedPoints;
    List<String> links;
}
