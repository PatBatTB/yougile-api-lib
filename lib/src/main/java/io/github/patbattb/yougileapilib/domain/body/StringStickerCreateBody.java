package io.github.patbattb.yougileapilib.domain.body;

import com.fasterxml.jackson.annotation.JsonInclude;
import io.github.patbattb.yougileapilib.domain.StringSticker;
import io.github.patbattb.yougileapilib.domain.StringStickerState;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NonNull;
import lombok.experimental.FieldDefaults;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Implementation of the {@link RequestBody} for POST request creates new {@link StringSticker}
 */
@Getter
@FieldDefaults(level = AccessLevel.PRIVATE)
@JsonInclude(JsonInclude.Include.NON_NULL)
public class StringStickerCreateBody implements RequestBody{

    final String name;
    StringSticker.Icon icon;
    List<StringStickerState> states = new ArrayList<>();

    private StringStickerCreateBody(String name) {
        this.name = name;
    }

    /**
     * Instantiates the builder for constructing {@link StringStickerCreateBody}.
     * Required fields of the {@link StringStickerCreateBody} needs to be passed as the arguments.
     * The remaining fields can be specified using the builder's methods.
     * @param name string-sticker name.
     * @return the builder.
     */
    public static StringStickerCreateBody.Builder builder(@NonNull String name) {
        return new Builder(new StringStickerCreateBody(name));
    }

    /**
     * The builder doesn't have public constructor or static methods.
     * Use {@link StringStickerCreateBody#builder(String)} for constructing.
     */
    public static class Builder extends BodyBuilder<StringStickerCreateBody> {

        private Builder(StringStickerCreateBody body) {
            super(body);
        }

        /**
         *
         * @param icon Icon of the sticker.
         * @return the builder itself for continue constructing.
         */
        public Builder icon(StringSticker.Icon icon) {
            body.icon = icon;
            return this;
        }

        /**
         *
         * @param states state instances.
         * @return the builder itself for continue constructing.
         */
        public Builder states(StringStickerState... states) {
            body.states = Arrays.asList(states);
            return this;
        }
    }
}
