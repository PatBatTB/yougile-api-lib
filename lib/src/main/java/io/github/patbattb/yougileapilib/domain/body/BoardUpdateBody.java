package io.github.patbattb.yougileapilib.domain.body;

import com.fasterxml.jackson.annotation.JsonInclude;
import io.github.patbattb.yougileapilib.domain.BoardStickerInfo;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.experimental.FieldDefaults;

@Getter
@FieldDefaults(level = AccessLevel.PRIVATE)
@JsonInclude(JsonInclude.Include.NON_NULL)
public class BoardUpdateBody extends RequestBody {

    Boolean deleted;
    String title;
    String projectId;
    BoardStickerInfo stickers;

    private BoardUpdateBody() {
    }

    public static BoardUpdateBody.Builder builder() {
        return new Builder(new BoardUpdateBody());
    }

    public static class Builder extends BodyBuilder<BoardUpdateBody> {

        private Builder(BoardUpdateBody body) {
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

        public Builder projectId(String value) {
            body.projectId = value;
            return this;
        }

        public Builder stickers(BoardStickerInfo value) {
            body.stickers = value;
            return this;
        }
    }
}
