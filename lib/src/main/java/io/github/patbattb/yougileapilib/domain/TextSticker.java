package io.github.patbattb.yougileapilib.domain;

import lombok.*;
import lombok.experimental.FieldDefaults;

import java.util.List;

@Getter
@FieldDefaults(level = AccessLevel.PRIVATE)
@AllArgsConstructor
@EqualsAndHashCode
@ToString
public class TextSticker {
    String id;
    @Setter
    boolean deleted;
    @Setter
    String name;
    @Setter
    Icon icon;
    List<TextStickerState> textStickerStates;
    int limit;
    int offset;
}
