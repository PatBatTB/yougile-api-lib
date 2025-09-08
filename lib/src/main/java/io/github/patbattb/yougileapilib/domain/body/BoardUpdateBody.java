package io.github.patbattb.yougileapilib.domain.body;

import com.fasterxml.jackson.annotation.JsonInclude;
import io.github.patbattb.yougileapilib.domain.BoardStickerInfo;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.experimental.FieldDefaults;

/**
 * Implementation of the {@link RequestBody} for PUT request updates {@link io.github.patbattb.yougileapilib.domain.Board}
 */
@Getter
@FieldDefaults(level = AccessLevel.PRIVATE)
@JsonInclude(JsonInclude.Include.NON_NULL)
public class BoardUpdateBody implements RequestBody {

    Boolean deleted;
    String title;
    String projectId;
    BoardStickerInfo stickers;

    private BoardUpdateBody() {
    }

    /**
     * Instantiates the builder for constructing {@link BoardUpdateBody}.
     * This builder has no parameters. All fields of the {@link BoardUpdateBody} can be specified using the builder's methods.
     * @return the builder
     */
    public static BoardUpdateBody.Builder builder() {
        return new Builder(new BoardUpdateBody());
    }

    public static class Builder extends BodyBuilder<BoardUpdateBody> {

        private Builder(BoardUpdateBody body) {
            super(body);
        }

        /**
         *
         * @param value if true, then object can be deleted.
         * @return the builder itself for continue constructing.
         */
        public Builder deleted(Boolean value) {
            body.deleted = value;
            return this;
        }

        /**
         *
         * @param value board title
         * @return the builder itself for continue constructing.
         */
        public Builder title(String value) {
            body.title = value;
            return this;
        }

        /**
         *
         * @param value ID of the project, where should the board be placed.
         * @return the builder itself for continue constructing.
         */
        public Builder projectId(String value) {
            body.projectId = value;
            return this;
        }

        /**
         *
         * @param value available stickers on the board.
         * @return the builder itself for continue constructing.
         */
        public Builder stickers(BoardStickerInfo value) {
            body.stickers = value;
            return this;
        }
    }
}
