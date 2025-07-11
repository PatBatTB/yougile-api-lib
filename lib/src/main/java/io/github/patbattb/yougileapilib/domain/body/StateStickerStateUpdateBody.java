package io.github.patbattb.yougileapilib.domain.body;

import com.fasterxml.jackson.annotation.JsonInclude;
import io.github.patbattb.yougileapilib.domain.StateStickerState;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.experimental.FieldDefaults;

/**
 * Implementation of the {@link RequestBody} for PUT request updates {@link io.github.patbattb.yougileapilib.domain.StateStickerState}
 */
@Getter
@JsonInclude(JsonInclude.Include.NON_NULL)
@FieldDefaults(level = AccessLevel.PRIVATE)
public class StateStickerStateUpdateBody extends RequestBody {

    Boolean deleted;
    String name;
    StateStickerState.Color color;

    private StateStickerStateUpdateBody() {}

    /**
     * Instantiates the builder for constructing {@link StateStickerStateUpdateBody}.
     * This builder has no parameters. All fields of the {@link StateStickerStateUpdateBody} can be specified using the builder's methods.
     * @return the builder
     */
    public static StateStickerStateUpdateBody.Builder builder() {
        return new Builder(new StateStickerStateUpdateBody());
    }

    public static class Builder extends BodyBuilder<StateStickerStateUpdateBody> {

        private Builder(StateStickerStateUpdateBody body) {
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
        public Builder color(StateStickerState.Color value) {
            body.color = value;
            return this;
        }
    }
}
