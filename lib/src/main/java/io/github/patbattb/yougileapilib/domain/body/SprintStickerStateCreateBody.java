package io.github.patbattb.yougileapilib.domain.body;

import com.fasterxml.jackson.annotation.JsonInclude;
import io.github.patbattb.yougileapilib.domain.SprintStickerState;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.experimental.FieldDefaults;

/**
 * Implementation of the {@link RequestBody} for POST request creates new {@link SprintStickerState}
 * <p>
 * The class doesn't have public constructors, use {@link SprintStickerStateCreateBody#builder(String)} for constructing.
 */
@Getter
@FieldDefaults(level = AccessLevel.PRIVATE)
@JsonInclude(JsonInclude.Include.NON_NULL)
public class SprintStickerStateCreateBody implements RequestBody{
    final String name;
    Long begin;
    Long end;

    private SprintStickerStateCreateBody(String name) {
        this.name = name;
    }

    /**
     * Instantiates the builder for constructing {@link SprintStickerStateCreateBody}.
     * Required fields of the {@link SprintStickerStateCreateBody} needs to be passed as the arguments.
     * The remaining fields can be specified using the builder's methods.
     * @param name sprint-sticker name.
     * @return the builder.
     */
    public static Builder builder(String name) {
        return new Builder(new SprintStickerStateCreateBody(name));
    }

    /**
     * The builder doesn't have public constructor or static methods.
     * Use {@link SprintStickerStateCreateBody#builder(String)} for constructing.
     */
    public static class Builder extends BodyBuilder<SprintStickerStateCreateBody> {

        private Builder(SprintStickerStateCreateBody body) {
            super(body);
        }

        /**
         * Values can't be lesser than zero and beginValue can't be bigger than endValue.
         * @param beginValue timestamp of the sticker start.
         * @param endValue timestamp of the sticker end.
         * @return the builder itself for continue constructing.
         */
        public Builder timestamp(Long beginValue, Long endValue) {
            SprintStickerState.validateTimestamp(beginValue, endValue);
            body.begin = beginValue;
            body.end = endValue;
            return this;
        }
    }
}
