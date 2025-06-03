package io.github.patbattb.yougileapilib.domain;

import lombok.Getter;

public enum SystemProjectRole {
    Admin("admin"),
    Worker("worker"),
    Observer("observer"),
    ToDelete("-");

    @Getter
    private final String value;

    SystemProjectRole(String value) {
        this.value = value;
    }
}
