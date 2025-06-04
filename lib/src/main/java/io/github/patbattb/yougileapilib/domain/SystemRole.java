package io.github.patbattb.yougileapilib.domain;

import lombok.Getter;

public enum SystemRole {
    ADMIN("admin"),
    WORKER("worker"),
    OBSERVER("observer"),
    TO_DELETE("-");

    @Getter
    private final String id;

    SystemRole(String id) {
        this.id = id;
    }
}
