package io.github.patbattb.yougileapilib.domain.body;

import com.fasterxml.jackson.annotation.JsonInclude;
import io.github.patbattb.yougileapilib.domain.SprintSticker;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.experimental.FieldDefaults;

/**
 * Implementation of the {@link RequestBody} for PUT request updates {@link SprintSticker}
 */
@Getter
@FieldDefaults(level = AccessLevel.PRIVATE)
@JsonInclude(JsonInclude.Include.NON_NULL)
public class SprintStickerUpdateBody implements RequestBody {
    Boolean deleted;
    String name;

    private SprintStickerUpdateBody() {}

    /**
     * Instantiates the builder for constructing {@link SprintStickerUpdateBody}.
     * This builder has no parameters. All fields of the {@link SprintStickerUpdateBody} can be specified using the builder's methods.
     * @return the builder.
     */
    public static SprintStickerUpdateBody.Builder builder() {
        return new Builder(new SprintStickerUpdateBody());
    }

    public static class Builder extends BodyBuilder<SprintStickerUpdateBody> {

        private Builder(SprintStickerUpdateBody body) {
            super(body);
        }

        /**
         *
         * @param value true, if object must be deleted.
         * @return the builder itself for continue constructing.
         */
        public Builder deleted(Boolean value) {
            body.deleted = value;
            return this;
        }

        /**
         *
         * @param name sticker name.
         * @return the builder itself for continue constructing.
         */
        public Builder name(String name) {
            body.name = name;
            return this;
        }
    }
}
