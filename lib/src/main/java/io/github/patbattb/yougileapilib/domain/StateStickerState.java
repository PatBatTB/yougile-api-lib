package io.github.patbattb.yougileapilib.domain;

import com.fasterxml.jackson.annotation.JsonValue;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import io.github.patbattb.yougileapilib.http.deserialize.StateStickerStateDeserializer;
import lombok.*;
import lombok.experimental.FieldDefaults;

import java.util.Arrays;

/**
 * Entity of state for the state-sticker available on the {@link Board}
 * On YouGile this stickers named StringSticker.
 */
@Getter
@FieldDefaults(level = AccessLevel.PRIVATE)
@AllArgsConstructor
@EqualsAndHashCode
@ToString
@JsonDeserialize(using = StateStickerStateDeserializer.class)
public class StateStickerState {

    /**
     * If true, then state has been deleted.
     */
    @Setter
    boolean deleted;
    /**
     * State ID.
     */
    String id;
    /**
     * State name.
     */
    @Setter
    String name;
    /**
     * State color
     * This enum represents available values:
     * <ul>
     * <li>{@link StateStickerState.Color#NO_COLOR} - without color.
     * <li>{@link StateStickerState.Color#GRAY} - gray color.
     * <li>{@link StateStickerState.Color#RED} - red color.
     * <li>{@link StateStickerState.Color#PINK} - pink color.
     * <li>{@link StateStickerState.Color#ORANGE} - orange color.
     * <li>{@link StateStickerState.Color#GREEN} - green color.
     * <li>{@link StateStickerState.Color#AQUA} - aqua color.
     * <li>{@link StateStickerState.Color#BLUE} - blue color.
     * <li>{@link StateStickerState.Color#PURPLE} - purple color.
     * </ul>
     */
    @Setter
    Color color;

    public enum Color {
        //state colors gray-#B8BFCF red-#D92400 pink-#FF8C8C orange-#F5C24D green-#79CE69 aqua-#2BDBCC blue-#8CC2FF purple-#CA79DB
        NO_COLOR(""),
        GRAY("#B8BFCF"),
        RED("#D92400"),
        PINK("#FF8C8C"),
        ORANGE("#F5C24D"),
        GREEN("#79CE69"),
        AQUA("#2BDBCC"),
        BLUE("#8CC2FF"),
        PURPLE("#CA79DB");

        private static final String apiFieldName = "stateSticker.state.color";
        @JsonValue
        private final String value;

        Color(String value) {
            this.value = value;
        }

        /**
         * Create enum constant from the {@link String} value.
         * If there is no passed value in available list method throws {@link IllegalArgumentException}
         * @param value value of the constant. Available values : "", #B8BFCF, #D92400, #FF8C8C, #F5C24D,
         *              #79CE69, #2BDBCC, #8CC2FF, #CA79DB
         * @return appropriate enum constant.
         * @throws IllegalArgumentException if passed value is not available.
         */
        public static StateStickerState.Color fromValue(String value) {
            for (StateStickerState.Color move: StateStickerState.Color.values()) {
                if (move.value.equalsIgnoreCase(value)) {
                    return move;
                }
            }
            throw new IllegalArgumentException(apiFieldName + " value must be one of: " + Arrays.stream(values()).map(elem -> elem.value).toList());
        }
    }
}
