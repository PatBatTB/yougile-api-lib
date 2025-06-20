package io.github.patbattb.yougileapilib.domain.body;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.experimental.FieldDefaults;

@Getter
@FieldDefaults(level = AccessLevel.PRIVATE)
@JsonInclude(JsonInclude.Include.NON_NULL)
public class ColumnUpdateBody extends RequestBody {

    Boolean deleted;
    String title;
    Integer color;
    String boardId;

    private ColumnUpdateBody() {
    }

    public static ColumnUpdateBody.Builder builder() {
        return new Builder(new ColumnUpdateBody());
    }

    public static class Builder extends BodyBuilder<ColumnUpdateBody> {

        private Builder(ColumnUpdateBody body) {
            super(body);
        }

        public Builder deleted(boolean value) {
            body.deleted = value;
            return this;
        }

        public Builder title(String value) {
            body.title = value;
            return this;
        }

        public Builder color(int value) {
            if (value < 1 || value > 16) {
                throw new IllegalArgumentException("The color value must be between 1 and 16");
            }
            body.color = value;
            return this;
        }

        public Builder boardId(String value) {
            body.boardId = value;
            return this;
        }
    }
}
