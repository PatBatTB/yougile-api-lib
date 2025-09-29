package io.github.patbattb.yougileapilib.domain.body;

import com.fasterxml.jackson.annotation.JsonInclude;
import io.github.patbattb.yougileapilib.domain.SprintStickerState;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.experimental.FieldDefaults;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Implementation of the {@link RequestBody} for POST request creates new {@link io.github.patbattb.yougileapilib.domain.SprintSticker}
 */
@Getter
@FieldDefaults(level = AccessLevel.PRIVATE)
@JsonInclude(JsonInclude.Include.NON_NULL)
public class SprintStickerCreateBody implements RequestBody {

    final String name;
    List<SprintStickerState> states = new ArrayList<>();

    private SprintStickerCreateBody(String name) {
        this.name = name;
    }

    /**
     * Instantiates the builder for constructing {@link SprintStickerCreateBody}.
     * Required fields of the {@link SprintStickerCreateBody} needs to be passed as the arguments.
     * The remaining fields can be specified using the builder's methods.
     * @param name sprint-sticker name.
     * @return the builder.
     */
    public static SprintStickerCreateBody.Builder builder(String name) {
        return new Builder(new SprintStickerCreateBody(name));
    }

    /**
     * The builder doesn't have public constructor or static methods.
     * Use {@link SprintStickerCreateBody#builder(String)} for constructing.
     */
    public static class Builder extends BodyBuilder<SprintStickerCreateBody> {

        private Builder(SprintStickerCreateBody body) {
            super(body);
        }

        /**
         *
         * @param values state instances.
         * @return the builder itself for continue constructing.
         */
        public Builder states(SprintStickerState... values) {
            body.states = Arrays.asList(values);
            return this;
        }
    }
}
