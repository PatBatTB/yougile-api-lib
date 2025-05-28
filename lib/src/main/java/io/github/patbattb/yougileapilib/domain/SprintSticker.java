package io.github.patbattb.yougileapilib.domain;

import lombok.*;
import lombok.experimental.FieldDefaults;

import java.util.List;

@Getter
@FieldDefaults(level = AccessLevel.PRIVATE)
@AllArgsConstructor
@EqualsAndHashCode
@ToString
public class SprintSticker {
    String id;
    @Setter
    boolean deleted;
    @Setter
    String name;
    List<SprintStickerState> states;
}
