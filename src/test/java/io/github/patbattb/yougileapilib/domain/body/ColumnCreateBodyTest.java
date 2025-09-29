package io.github.patbattb.yougileapilib.domain.body;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.lang.reflect.Constructor;
import java.lang.reflect.Modifier;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class ColumnCreateBodyTest {

    @Test
    @DisplayName("The class doesn't have default constructor")
    void noDefaultConstructor() {
        assertThatThrownBy(ColumnCreateBody.class::getDeclaredConstructor).isInstanceOf(NoSuchMethodException.class);
    }

    @Test
    @DisplayName("The class have private constructor with (String, String) parameters")
    void privateStringStringConstructor() throws NoSuchMethodException {
        Constructor<ColumnCreateBody> constructor = ColumnCreateBody.class.getDeclaredConstructor(String.class, String.class);
        assertThat(constructor.getModifiers()).isEqualTo(Modifier.PRIVATE);
    }

    @Test
    @DisplayName("builder() returns the Builder with the ColumnCreatedBody")
    void builder() {
        ColumnCreateBody.Builder builder = ColumnCreateBody.builder("", "");
        assertThat(builder.body).isInstanceOf(ColumnCreateBody.class);
    }

    @Test
    @DisplayName("getTitle() returns the value that was passed to the builder.")
    void getTitle() {
        String title = "title111";
        ColumnCreateBody body = ColumnCreateBody.builder(title, "").build();
        assertThat(body.getTitle()).isEqualTo(title);
    }

    @Test
    @DisplayName("getBoardId() returns the value that was passed to the builder")
    void getBoardId() {
        String boardId = "boardId111";
        ColumnCreateBody body = ColumnCreateBody.builder("", boardId).build();
        assertThat(body.getBoardId()).isEqualTo(boardId);
    }

    @Test
    @DisplayName("getColor() returns the value that was passed to the builder")
    void getColor() {
        int color = 5;
        ColumnCreateBody body = ColumnCreateBody.builder("","").color(color).build();
        assertThat(body.getColor()).isEqualTo(color);
    }

    @Test
    @DisplayName("getColor() returns null if the value wasn't passed to the builder")
    void getColorNull() {
        ColumnCreateBody body = ColumnCreateBody.builder("", "").build();
        assertThat(body.getColor()).isNull();
    }

    @Test
    @DisplayName("color() throws the exception if passed value less than 1")
    void colorLessOne() {
        int color = 0;
        ColumnCreateBody.Builder builder = ColumnCreateBody.builder("", "");
        assertThatThrownBy(() -> builder.color(color)).isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    @DisplayName("color() throws the exception if passed value greater than 16")
    void colorGreaterSixteen() {
        int color = 17;
        ColumnCreateBody.Builder builder = ColumnCreateBody.builder("", "");
        assertThatThrownBy(() -> builder.color(color)).isInstanceOf(IllegalArgumentException.class);
    }
}