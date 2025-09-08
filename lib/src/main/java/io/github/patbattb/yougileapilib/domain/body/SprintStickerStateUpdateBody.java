package io.github.patbattb.yougileapilib.domain.body;

import com.fasterxml.jackson.annotation.JsonInclude;
import io.github.patbattb.yougileapilib.domain.SprintStickerState;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.experimental.FieldDefaults;

/**
 * Implementation of the {@link RequestBody} for PUT request updates {@link SprintStickerState}
 */
@Getter
@JsonInclude(JsonInclude.Include.NON_NULL)
@FieldDefaults(level = AccessLevel.PRIVATE)
public class SprintStickerStateUpdateBody implements RequestBody {
    Boolean deleted;
    String name;
    Long begin;
    Long end;

    private SprintStickerStateUpdateBody() {}

    /**
     * Instantiates the builder for constructing {@link SprintStickerStateUpdateBody}.
     * This builder has no parameters. All fields of the {@link SprintStickerStateUpdateBody} can be specified using the builder's methods.
     * @return the builder
     */
    public static Builder builder() {
        return new Builder(new SprintStickerStateUpdateBody());
    }

    public static class Builder extends BodyBuilder<SprintStickerStateUpdateBody> {

        private Builder(SprintStickerStateUpdateBody body) {
            super(body);
        }

        /**
         *
         * @param value if true, then object will be deleted.
         * @return the builder itself for continue constructing.
         */
        public Builder deleted(Boolean value) {
            body.deleted = value;
            return this;
        }

        /**
         *
         * @param value new name of the state.
         * @return the builder itself for continue constructing.
         */
        public Builder name(String value) {
            body.name = value;
            return this;
        }

        /**
         *
         * @param value timestamp of the sticker start.
         * @return the builder itself for continue constructing.
         */
        public Builder begin(Long value) {
            if (value < 0) {
                throw new IllegalArgumentException("Begin time can't be lesser than zero.");
            }
            if (body.end != null && value > body.end) {
                throw new IllegalArgumentException("Begin time can't be bigger than end time.");
            }
            body.begin = value;
            return this;
        }

        /**
         *
         * @param value timestamp of the sticker end.
         * @return the builder itself for continue constructing.
         */
        public Builder end(Long value) {
            if (value < 0) {
                throw new IllegalArgumentException("End time can't be lesser than zero.");
            }
            if (body.begin != null && value < body.begin) {
                throw new IllegalArgumentException("End time can't be lesser than begin time.");
            }
            body.end = value;
            return this;
        }
    }
}
