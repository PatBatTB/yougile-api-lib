package io.github.patbattb.yougileapilib.domain.body;

import com.fasterxml.jackson.annotation.JsonInclude;
import io.github.patbattb.yougileapilib.domain.StateSticker;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.Setter;
import lombok.experimental.FieldDefaults;

/**
 * Implementation of the {@link RequestBody} for PUT request updates {@link io.github.patbattb.yougileapilib.domain.StateSticker}
 */
@Getter
@Setter
@FieldDefaults(level = AccessLevel.PRIVATE)
@JsonInclude(JsonInclude.Include.NON_NULL)
public class StateStickerUpdateBody extends RequestBody {
    boolean deleted;
    String name;
    StateSticker.Icon icon;

    private StateStickerUpdateBody() {}

    /**
     * Instantiates the builder for constructing {@link StateStickerUpdateBody}.
     * This builder has no parameters. All fields of the {@link StateStickerUpdateBody} can be specified using the builder's methods.
     * @return the builder.
     */
    public static StateStickerUpdateBody.Builder builder() {
        return new Builder(new StateStickerUpdateBody());
    }

    public static class Builder extends BodyBuilder<StateStickerUpdateBody> {

        private Builder(StateStickerUpdateBody body) {
            super(body);
        }

        /**
         *
         * @param value true, if object must be deleted.
         * @return the builder itself for continue constructing.
         */
        public Builder deleted(boolean value) {
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
        public Builder icon(StateSticker.Icon value) {
            body.icon = value;
            return this;
        }
    }
}
