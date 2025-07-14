package io.github.patbattb.yougileapilib.domain.body;

import com.fasterxml.jackson.annotation.JsonInclude;
import io.github.patbattb.yougileapilib.domain.StringStickerState;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.experimental.FieldDefaults;

/**
 * Implementation of the {@link RequestBody} for POST request creates new {@link io.github.patbattb.yougileapilib.domain.StringSticker}
 */
@Getter
@FieldDefaults(level = AccessLevel.PRIVATE)
@JsonInclude(JsonInclude.Include.NON_NULL)
public class StringStickerStateCreateBody implements RequestBody {

    final String name;
    StringStickerState.Color color;

    private StringStickerStateCreateBody(String name) {
        this.name = name;
    }

    /**
     * Instantiates the builder for constructing {@link StringStickerStateCreateBody}.
     * Required fields of the {@link StringStickerStateCreateBody} needs to be passed as the arguments.
     * The remaining fields can be specified using the builder's methods.
     * @param name string-sticker state name.
     * @return the builder.
     */
    public static Builder builder(String name) {
        return new Builder(new StringStickerStateCreateBody(name));
    }

    public static class Builder extends BodyBuilder<StringStickerStateCreateBody> {

        private Builder(StringStickerStateCreateBody body) {
            super(body);
        }

        /**
         *
         * @param value color of the state.
         * @return the builder itself for continue constructing.
         */
        public Builder color(StringStickerState.Color value) {
            body.color = value;
            return this;
        }
    }
}
