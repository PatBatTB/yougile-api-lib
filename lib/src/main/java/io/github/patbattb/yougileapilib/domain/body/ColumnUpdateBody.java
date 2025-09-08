package io.github.patbattb.yougileapilib.domain.body;

import com.fasterxml.jackson.annotation.JsonInclude;
import io.github.patbattb.yougileapilib.domain.Column;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.experimental.FieldDefaults;

/**
 * Implementation of the {@link RequestBody} for PUT request updates {@link Column}
 */
@Getter
@FieldDefaults(level = AccessLevel.PRIVATE)
@JsonInclude(JsonInclude.Include.NON_NULL)
public class ColumnUpdateBody implements RequestBody {

    Boolean deleted;
    String title;
    Integer color;
    String boardId;

    private ColumnUpdateBody() {
    }

    /**
     * Instantiates the builder for constructing {@link ColumnUpdateBody}.
     * This builder has no parameters. All fields of the {@link ColumnUpdateBody} can be specified using the builder's methods.
     * @return the builder
     */
    public static ColumnUpdateBody.Builder builder() {
        return new Builder(new ColumnUpdateBody());
    }

    public static class Builder extends BodyBuilder<ColumnUpdateBody> {

        private Builder(ColumnUpdateBody body) {
            super(body);
        }

        /**
         *
         * @param value if true, then object will be deleted.
         * @return the builder itself for continue constructing.
         */
        public Builder deleted(Boolean value) {
            body.deleted = value;
            return this;
        }

        /**
         *
         * @param value column name
         * @return the builder itself for continue constructing.
         */
        public Builder title(String value) {
            body.title = value;
            return this;
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

        /**
         *
         * @param value board ID where column can be placed.
         * @return the builder itself for continue constructing.
         */
        public Builder boardId(String value) {
            body.boardId = value;
            return this;
        }
    }
}
