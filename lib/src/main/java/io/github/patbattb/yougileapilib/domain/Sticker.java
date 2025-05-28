package io.github.patbattb.yougileapilib.domain;

import lombok.*;
import lombok.experimental.FieldDefaults;

@Getter
@FieldDefaults(level = AccessLevel.PRIVATE)
@AllArgsConstructor
@EqualsAndHashCode
@ToString
public class Sticker {
    boolean timer;
    boolean deadline;
    boolean stopwatch;
    boolean timeTracking;
    boolean assignee;
    boolean repeat;
    //Object custom;
}
