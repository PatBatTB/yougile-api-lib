package io.github.patbattb.yougileapilib.domain.body;

import com.fasterxml.jackson.annotation.JsonInclude;
import io.github.patbattb.yougileapilib.domain.StateSticker;
import io.github.patbattb.yougileapilib.domain.StateStickerState;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NonNull;
import lombok.experimental.FieldDefaults;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Implementation of the {@link RequestBody} for POST request creates new {@link io.github.patbattb.yougileapilib.domain.StateSticker}
 */
@Getter
@FieldDefaults(level = AccessLevel.PRIVATE)
@JsonInclude(JsonInclude.Include.NON_NULL)
public class StateStickerCreateBody extends RequestBody{

    final String name;
    StateSticker.Icon icon;
    List<StateStickerState> states = new ArrayList<>();

    private StateStickerCreateBody(String name) {
        this.name = name;
    }

    /**
     * Instantiates the builder for constructing {@link StateStickerCreateBody}.
     * Required fields of the {@link StateStickerCreateBody} needs to be passed as the arguments.
     * The remaining fields can be specified using the builder's methods.
     * @param name state-sticker name.
     * @return the builder.
     */
    public static StateStickerCreateBody.Builder builder(@NonNull String name) {
        return new Builder(new StateStickerCreateBody(name));
    }

    /**
     * The builder doesn't have public constructor or static methods.
     * Use {@link StateStickerCreateBody#builder(String)} for constructing.
     */
    public static class Builder extends BodyBuilder<StateStickerCreateBody> {

        private Builder(StateStickerCreateBody body) {
            super(body);
        }

        /**
         *
         * @param icon Icon of the sticker.
         * @return the builder itself for continue constructing.
         */
        public Builder icon(StateSticker.Icon icon) {
            body.icon = icon;
            return this;
        }

        /**
         *
         * @param states state instances.
         * @return the builder itself for continue constructing.
         */
        public Builder states(StateStickerState... states) {
            body.states = Arrays.asList(states);
            return this;
        }
    }
}
