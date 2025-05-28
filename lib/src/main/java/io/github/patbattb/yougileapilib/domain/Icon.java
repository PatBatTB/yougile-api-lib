package io.github.patbattb.yougileapilib.domain;

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

    public final String value;

    Icon(String value) {
        this.value = value;
    }
}
