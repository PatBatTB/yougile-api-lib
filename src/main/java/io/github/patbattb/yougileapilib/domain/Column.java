package io.github.patbattb.yougileapilib.domain;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import io.github.patbattb.yougileapilib.http.deserialize.ColumnDeserializer;
import lombok.*;
import lombok.experimental.FieldDefaults;

/**
 * The column where the {@link Task}s are placed.
 * {@link Column#color} has constraint and must be from {@code 1} to {@code 16}
 */
@Getter
@FieldDefaults(level = AccessLevel.PRIVATE)
@EqualsAndHashCode
@ToString
@JsonDeserialize(using = ColumnDeserializer.class)
public class Column {
    /**
     * If true, then the column has been deleted.
     */
    @Setter
    boolean deleted;
    /**
     * Column ID.
     */
    final String id;
    /**
     * Column title.
     */
    @Setter
    String title;
    /**
     * The color of the column. It is indicated as a number in the range from 1 to 16.
     */
    Integer color;
    /**
     * Board ID where the column is located.
     */
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

    /**
     * The color of the column. It is indicated as a number in the range from 1 to 16.
     * @param color must be number from 1 to 16.
     */
    public void setColor(Integer color) {
        colorCheck(color);
        this.color = color;
    }

    /**
     * Checks out color value for validity.
     * @param color must be number from 1 to 16.
     */
    public static void colorCheck(Integer color) {
        if (color != null && (color < 1 || color > 16)) {
            throw new IllegalArgumentException("The color value must be between 1 and 16");
        }
    }
}
