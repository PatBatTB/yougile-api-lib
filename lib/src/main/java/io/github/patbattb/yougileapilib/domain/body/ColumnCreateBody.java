package io.github.patbattb.yougileapilib.domain.body;

import com.fasterxml.jackson.annotation.JsonInclude;
import io.github.patbattb.yougileapilib.domain.Column;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NonNull;
import lombok.experimental.FieldDefaults;

/**
 * Implementation of the {@link RequestBody} for POST request creates {@link Column}
 */
@Getter
@FieldDefaults(level = AccessLevel.PRIVATE)
@JsonInclude(JsonInclude.Include.NON_NULL)
public class ColumnCreateBody implements RequestBody {

    final String title;
    final String boardId;
    Integer color;

    private ColumnCreateBody(String title, String boardId) {
        this.title = title;
        this.boardId = boardId;
    }

    /**
     * Instantiates the builder for constructing {@link ColumnCreateBody}.
     * Required fields of the {@link ColumnCreateBody} needs to be passed as the arguments.
     * The remaining fields can be specified using the builder's methods.
     * @param title column name
     * @param boardId board ID where column can be placed.
     * @return the builder.
     */
    public static ColumnCreateBody.Builder builder(@NonNull String title, @NonNull String boardId) {
        return new Builder(new ColumnCreateBody(title, boardId));
    }

    public static class Builder extends BodyBuilder<ColumnCreateBody> {

        private Builder(ColumnCreateBody body) {
            super(body);
        }

        /**
         *
         * @param value The color of the column. It is indicated as a number in the range from 1 to 16.
         * @return the builder itself for continue constructing.
         */
        public Builder color(Integer value) {
            Column.colorCheck(value);
            body.color = value;
            return this;
        }
    }
}
