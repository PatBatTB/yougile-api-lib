package io.github.patbattb.yougileapilib.domain;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import io.github.patbattb.yougileapilib.http.deserialize.ColumnDeserializer;
import lombok.*;
import lombok.experimental.FieldDefaults;

@Getter
@FieldDefaults(level = AccessLevel.PRIVATE)
@EqualsAndHashCode
@ToString
@JsonDeserialize(using = ColumnDeserializer.class)
public class Column {
    @Setter
    boolean deleted;
    final String id;
    @Setter
    String title;
    Integer color;
    @Setter
    String boardId;

    public Column(boolean deleted, String id, String title, Integer color, String boardId) {
        colorCheck(color);
        this.deleted = deleted;
        this.id = id;
        this.title = title;
        this.color = color;
        this.boardId = boardId;
    }

    public void setColor(Integer color) {
        colorCheck(color);
        this.color = color;
    }

    public static void colorCheck(Integer color) {
        if (color != null && (color < 1 || color > 16)) {
            throw new IllegalArgumentException("The color value must be between 1 and 16");
        }
    }
}
