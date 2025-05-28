package io.github.patbattb.yougileapilib.domain;

import lombok.*;
import lombok.experimental.FieldDefaults;

import java.util.List;

@Getter
@FieldDefaults(level = AccessLevel.PRIVATE)
@AllArgsConstructor
@EqualsAndHashCode
@ToString
public class Board {
    @Setter
    boolean deleted;
    String id;
    @Setter
    String title;
    @Setter
    String projectId;
    @Setter
    List<Sticker> stickers;

}
