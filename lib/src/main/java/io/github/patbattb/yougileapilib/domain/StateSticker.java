package io.github.patbattb.yougileapilib.domain;

import com.fasterxml.jackson.annotation.JsonValue;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import io.github.patbattb.yougileapilib.http.deserialize.StateStickerDeserializer;
import lombok.*;
import lombok.experimental.FieldDefaults;

import java.util.Arrays;
import java.util.List;


/**
 * Entity of state-sticker available on the {@link Board}
 * On YouGile this stickers named StringSticker.
 */
@Getter
@FieldDefaults(level = AccessLevel.PRIVATE)
@AllArgsConstructor
@EqualsAndHashCode
@ToString
@JsonDeserialize(using = StateStickerDeserializer.class)
public class StateSticker {

    /**
     * State-sticker ID.
     */
    String id;
    /**
     * If true, then the sprint-sticker has been deleted.
     */
    @Setter
    boolean deleted;
    /**
     * State-sticker ID.
     */
    @Setter
    String name;
    /**
     * Icon
     */
    @Setter
    Icon icon;
    List<StateStickerState> states;

    /**
     * The enumeration represents available icons for {@link StateSticker#icon}.
     */
    public enum Icon {
        EMPTY(""),
        STAR("star"),
        HEART("heart"),
        CHECK("check"),
        CLOUD("cloud"),
        FILTER("filter"),
        ALARM("alarm"),
        BOLT("bolt"),
        BOOKMARK("bookmark"),
        BOX("box"),
        BULB("bulb"),
        PRIO("prio"),
        CODE("code"),
        RUBLE("ruble"),
        DOLLAR("dollar"),
        EURO("euro"),
        EYE("eye"),
        FLAG("flag"),
        FLAME("flame"),
        HISTORY("history"),
        INFO("info"),
        KEY("key"),
        ANCHOR("anchor"),
        MESSAGE("message"),
        MOVIE("movie"),
        MNOTE("mnote"),
        PENCIL("pencil"),
        PICTURE("picture"),
        PIN("pin"),
        CLOCKWISE("clockwise"),
        CLOCKWISEDOT("clockwiseDot"),
        RECTANGLE("rectangle"),
        SHIELD("shield"),
        STACK("stack"),
        STRING("string"),
        TIMESTOP("timeStop"),
        DESIGN("design"),
        USER("user"),
        PLUS("plus"),
        GEAR("gear"),
        SORT("sort");

        private static final String apiFieldName = "string-sticker.icon";
        @JsonValue
        public final String value;

        Icon(String value) {
            this.value = value;
        }

        /**
         * Create enum constant from the {@link String} value.
         * If there is no passed value in available list method throws {@link IllegalArgumentException}
         * @param value value of the constant. Available values : "", star, heart, check, cloud, filter,
         * alarm, bolt, bookmark, box, bulb, prio, code, ruble, dollar, euro, eye, flag, flame, history,
         * info, key, anchor, message, movie, mnote, pencil, picture, pin, clockwise, clockwiseDot,
         * rectangle, shield, stack, string, timeStop, design, user, plus, gear, sort, calendar.
         * @return appropriate enum constant.
         * @throws IllegalArgumentException if passed value is not available.
         */
        public static StateSticker.Icon fromValue(String value) {
            for (StateSticker.Icon icon: StateSticker.Icon.values()) {
                if (icon.value.equalsIgnoreCase(value)) {
                    return icon;
                }
            }
            throw new IllegalArgumentException(apiFieldName + " value must be one of: " + Arrays.stream(values()).map(elem -> elem.value).toList());
        }
    }
}
