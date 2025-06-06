package io.github.patbattb.yougileapilib.domain.body;

import com.fasterxml.jackson.annotation.JsonInclude;
import io.github.patbattb.yougileapilib.domain.BoardStickerInfo;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.experimental.FieldDefaults;

@Getter
@FieldDefaults(level = AccessLevel.PRIVATE)
@JsonInclude(JsonInclude.Include.NON_EMPTY)
public class BoardCreateBody extends RequestBody {

    final String title;
    final String projectId;
    BoardStickerInfo stickers;

    private BoardCreateBody(String title, String projectId) {
        this.title = title;
        this.projectId = projectId;
    }

    public static BoardCreateBody.Builder builder(String title, String projectId) {
        return new Builder(new BoardCreateBody(title, projectId));
    }

    public static class Builder extends BodyBuilder<BoardCreateBody> {

        private Builder(BoardCreateBody body) {
            super(body);
        }

        public Builder stickers(BoardStickerInfo value) {
            body.stickers = value;
            return this;
        }
    }
}
