package io.github.patbattb.yougileapilib.domain;

import lombok.*;
import lombok.experimental.FieldDefaults;

@Getter
@FieldDefaults(level = AccessLevel.PRIVATE)
@AllArgsConstructor
@EqualsAndHashCode
@ToString
public class TextStickerState {
    @Setter
    boolean deleted;
    String id;
    @Setter
    String name;
    @Setter
    String color;
}
