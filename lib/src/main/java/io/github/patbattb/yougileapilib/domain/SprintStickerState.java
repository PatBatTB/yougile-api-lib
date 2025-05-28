package io.github.patbattb.yougileapilib.domain;

import lombok.*;
import lombok.experimental.FieldDefaults;

@Getter
@FieldDefaults(level = AccessLevel.PRIVATE)
@AllArgsConstructor
@EqualsAndHashCode
@ToString
public class SprintStickerState {
    @Setter
    boolean deleted;
    String id;
    @Setter
    String name;
    @Setter
    long begin;
    @Setter
    long end;
}
