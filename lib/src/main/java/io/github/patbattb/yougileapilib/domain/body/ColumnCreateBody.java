package io.github.patbattb.yougileapilib.domain.body;

import com.fasterxml.jackson.annotation.JsonInclude;
import io.github.patbattb.yougileapilib.domain.Column;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NonNull;
import lombok.experimental.FieldDefaults;

@Getter
@FieldDefaults(level = AccessLevel.PRIVATE)
@JsonInclude(JsonInclude.Include.NON_NULL)
public class ColumnCreateBody extends RequestBody {

    final String title;
    final String boardId;
    Integer color;

    private ColumnCreateBody(String title, String boardId) {
        this.title = title;
        this.boardId = boardId;
    }

    public static ColumnCreateBody.Builder builder(@NonNull String title, @NonNull String boardId) {
        return new Builder(new ColumnCreateBody(title, boardId));
    }

    public static class Builder extends BodyBuilder<ColumnCreateBody> {

        private Builder(ColumnCreateBody body) {
            super(body);
        }

        public Builder color(int value) {
            Column.colorCheck(value);
            body.color = value;
            return this;
        }
    }
}
