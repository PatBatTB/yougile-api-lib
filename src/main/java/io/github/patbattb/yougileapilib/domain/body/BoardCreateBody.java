package io.github.patbattb.yougileapilib.domain.body;

import com.fasterxml.jackson.annotation.JsonInclude;
import io.github.patbattb.yougileapilib.domain.BoardStickerInfo;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NonNull;
import lombok.experimental.FieldDefaults;

/**
 * Implementation of the {@link RequestBody} for POST request creates {@link io.github.patbattb.yougileapilib.domain.Board}
 */
@Getter
@FieldDefaults(level = AccessLevel.PRIVATE)
@JsonInclude(JsonInclude.Include.NON_NULL)
public class BoardCreateBody implements RequestBody {

    final String title;
    final String projectId;
    BoardStickerInfo stickers;

    private BoardCreateBody(String title, String projectId) {
        this.title = title;
        this.projectId = projectId;
    }

    /**
     * Instantiates the builder for constructing {@link BoardCreateBody}.
     * Required fields of the {@link BoardCreateBody} needs to be passed as the arguments.
     * The remaining fields can be specified using the builder's methods.
     * @param title title of the board
     * @param projectId project ID where the board is placed
     * @return the builder
     */
    public static BoardCreateBody.Builder builder(@NonNull String title, @NonNull String projectId) {
        return new Builder(new BoardCreateBody(title, projectId));
    }

    public static class Builder extends BodyBuilder<BoardCreateBody> {

        private Builder(BoardCreateBody body) {
            super(body);
        }

        /**
         *
         * @param value bard's stickers
         * @return the builder itself for continue constructing.
         */
        public Builder stickers(BoardStickerInfo value) {
            body.stickers = value;
            return this;
        }
    }
}
