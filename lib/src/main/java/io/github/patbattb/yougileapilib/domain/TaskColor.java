package io.github.patbattb.yougileapilib.domain;

public enum TaskColor {
    PRIMARY("task-primary"),
    GRAY("task-gray"),
    RED("task-red"),
    PINK("task-pink"),
    YELLOW("task-yellow"),
    GREEN("task-green"),
    TURQUOISE("task-turquoise"),
    BLUE("task-blue"),
    VIOLET("task-violet");

    public final String value;

    TaskColor(String value) {
        this.value = value;
    }
}
