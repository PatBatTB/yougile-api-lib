package io.github.patbattb.yougileapilib.domain.body;

import com.fasterxml.jackson.annotation.JsonInclude;
import io.github.patbattb.yougileapilib.domain.StringSticker;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.experimental.FieldDefaults;

/**
 * Implementation of the {@link RequestBody} for PUT request updates {@link StringSticker}
 */
@Getter
@FieldDefaults(level = AccessLevel.PRIVATE)
@JsonInclude(JsonInclude.Include.NON_NULL)
public class StringStickerUpdateBody implements RequestBody {
    boolean deleted;
    String name;
    StringSticker.Icon icon;

    private StringStickerUpdateBody() {}

    /**
     * Instantiates the builder for constructing {@link StringStickerUpdateBody}.
     * This builder has no parameters. All fields of the {@link StringStickerUpdateBody} can be specified using the builder's methods.
     * @return the builder.
     */
    public static StringStickerUpdateBody.Builder builder() {
        return new Builder(new StringStickerUpdateBody());
    }

    public static class Builder extends BodyBuilder<StringStickerUpdateBody> {

        private Builder(StringStickerUpdateBody body) {
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
         * @param value new sticker name.
         * @return the builder itself for continue constructing.
         */
        public Builder name(String value) {
            body.name = value;
            return this;
        }

        /**
         *
         * @param value new sticker icon.
         * @return the builder itself for continue constructing.
         */
        public Builder icon(StringSticker.Icon value) {
            body.icon = value;
            return this;
        }
    }
}
