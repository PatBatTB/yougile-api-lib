package io.github.patbattb.yougileapilib.domain;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import io.github.patbattb.yougileapilib.http.deserialize.BoardDeserializer;
import lombok.*;
import lombok.experimental.FieldDefaults;

@Getter
@FieldDefaults(level = AccessLevel.PRIVATE)
@AllArgsConstructor
@EqualsAndHashCode
@ToString
@JsonDeserialize(using = BoardDeserializer.class)
public class Board {
    @Setter
    boolean deleted;
    String id;
    @Setter
    String title;
    @Setter
    String projectId;
    @Setter
    BoardStickerInfo stickers;

}
