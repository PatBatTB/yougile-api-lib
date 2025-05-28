package io.github.patbattb.yougileapilib.domain;

import lombok.*;
import lombok.experimental.FieldDefaults;

@Getter
@FieldDefaults(level = AccessLevel.PRIVATE)
@AllArgsConstructor
@EqualsAndHashCode
@ToString
public class Column {
    @Setter
    boolean deleted;
    String id;
    @Setter
    String title;
    @Setter
    int color;
    @Setter
    String boardId;
}
