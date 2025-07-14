package io.github.patbattb.yougileapilib.domain.body;

import com.fasterxml.jackson.annotation.JsonInclude;
import io.github.patbattb.yougileapilib.domain.StringStickerState;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.experimental.FieldDefaults;

/**
 * Implementation of the {@link RequestBody} for PUT request updates {@link StringStickerState}
 */
@Getter
@JsonInclude(JsonInclude.Include.NON_NULL)
@FieldDefaults(level = AccessLevel.PRIVATE)
public class StringStickerStateUpdateBody implements RequestBody {

    Boolean deleted;
    String name;
    StringStickerState.Color color;

    private StringStickerStateUpdateBody() {}

    /**
     * Instantiates the builder for constructing {@link StringStickerStateUpdateBody}.
     * This builder has no parameters. All fields of the {@link StringStickerStateUpdateBody} can be specified using the builder's methods.
     * @return the builder
     */
    public static StringStickerStateUpdateBody.Builder builder() {
        return new Builder(new StringStickerStateUpdateBody());
    }

    public static class Builder extends BodyBuilder<StringStickerStateUpdateBody> {

        private Builder(StringStickerStateUpdateBody body) {
            super(body);
        }

        /**
         *
         * @param value if true, then object will be deleted.
         * @return the builder itself for continue constructing.
         */
        public Builder deleted(boolean value) {
            body.deleted = value;
            return this;
        }

        /**
         *
         * @param value state name.
         * @return the builder itself for continue constructing.
         */
        public Builder name(String value) {
            body.name = value;
            return this;
        }

        /**
         *
         * @param value state color.
         * @return the builder itself for continue constructing.
         */
        public Builder color(StringStickerState.Color value) {
            body.color = value;
            return this;
        }
    }
}
