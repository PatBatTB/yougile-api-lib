package io.github.patbattb.yougileapilib.domain.body;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.lang.reflect.Constructor;
import java.lang.reflect.Modifier;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class ColumnUpdateBodyTest {

    @Test
    @DisplayName("The class has private default constructor")
    void constructor() throws NoSuchMethodException {
        Constructor<ColumnUpdateBody> constructor = ColumnUpdateBody.class.getDeclaredConstructor();
        assertThat(constructor.getModifiers()).isEqualTo(Modifier.PRIVATE);
    }

    @Test
    @DisplayName("builder() returns the Builder with the ColumnEditBody")
    void builder() {
        ColumnUpdateBody.Builder builder = ColumnUpdateBody.builder();
        assertThat(builder.body).isInstanceOf(ColumnUpdateBody.class);
    }

    @Test
    @DisplayName("getDeleted() returns the value that was passed to the builder")
    void getDeleted() {
        boolean value = true;
        ColumnUpdateBody body = ColumnUpdateBody.builder().deleted(value).build();
        assertThat(body.getDeleted()).isEqualTo(value);
    }

    @Test
    @DisplayName("getTitle() returns the value that was passed to the builder")
    void getTitle() {
        String value = "title111";
        ColumnUpdateBody body = ColumnUpdateBody.builder().title(value).build();
        assertThat(body.getTitle()).isEqualTo(value);
    }

    @Test
    @DisplayName("getColor() returns the value that was passed to the builder")
    void getColor() {
        int color = 11;
        ColumnUpdateBody body = ColumnUpdateBody.builder().color(color).build();
        assertThat(body.getColor()).isEqualTo(color);
    }

    @Test
    @DisplayName("getBoardId() returns the value that was passed to the builder")
    void getBoardId() {
        String boardId = "id111";
        ColumnUpdateBody body = ColumnUpdateBody.builder().boardId(boardId).build();
        assertThat(body.getBoardId()).isEqualTo(boardId);
    }

    @Test
    @DisplayName("getDeleted() returns null if the value doesn't passed to the builder")
    void getDeletedNull() {
        ColumnUpdateBody body = ColumnUpdateBody.builder().build();
        assertThat(body.getDeleted()).isNull();
    }

    @Test
    @DisplayName("getTitle() returns null if the value doesn't passed to the builder")
    void getTitleNull() {
        ColumnUpdateBody body = ColumnUpdateBody.builder().build();
        assertThat(body.getTitle()).isNull();
    }

    @Test
    @DisplayName("getColor() returns null if the value doesn't passed to the builder")
    void getColorNull() {
        ColumnUpdateBody body = ColumnUpdateBody.builder().build();
        assertThat(body.getColor()).isNull();
    }

    @Test
    @DisplayName("getBoardId() returns null if the value doesn't passed to the builder")
    void getBoardIdNull() {
        ColumnUpdateBody body = ColumnUpdateBody.builder().build();
        assertThat(body.getBoardId()).isNull();
    }

    @Test
    @DisplayName("color() throws exception if the passed value lesser one")
    void colorLessOne() {
        int color = 0;
        ColumnUpdateBody.Builder builder = ColumnUpdateBody.builder();
        assertThatThrownBy(() -> builder.color(color)).isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    @DisplayName("color() throws exception if the passed value greater sixteen")
    void colorGreaterSixteen() {
        int color = 17;
        ColumnUpdateBody.Builder builder = ColumnUpdateBody.builder();
        assertThatThrownBy(() -> builder.color(color)).isInstanceOf(IllegalArgumentException.class);
    }
}