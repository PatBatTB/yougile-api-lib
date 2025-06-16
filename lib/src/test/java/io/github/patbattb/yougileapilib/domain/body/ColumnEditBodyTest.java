package io.github.patbattb.yougileapilib.domain.body;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.lang.reflect.Constructor;
import java.lang.reflect.Modifier;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class ColumnEditBodyTest {

    @Test
    @DisplayName("The class has private default constructor")
    void constructor() throws NoSuchMethodException {
        Constructor<ColumnEditBody> constructor = ColumnEditBody.class.getDeclaredConstructor();
        assertThat(constructor.getModifiers()).isEqualTo(Modifier.PRIVATE);
    }

    @Test
    @DisplayName("builder() returns the Builder with the ColumnEditBody")
    void builder() {
        ColumnEditBody.Builder builder = ColumnEditBody.builder();
        assertThat(builder.body).isInstanceOf(ColumnEditBody.class);
    }

    @Test
    @DisplayName("getDeleted() returns the value that was passed to the builder")
    void getDeleted() {
        boolean value = true;
        ColumnEditBody body = ColumnEditBody.builder().deleted(value).build();
        assertThat(body.getDeleted()).isEqualTo(value);
    }

    @Test
    @DisplayName("getTitle() returns the value that was passed to the builder")
    void getTitle() {
        String value = "title111";
        ColumnEditBody body = ColumnEditBody.builder().title(value).build();
        assertThat(body.getTitle()).isEqualTo(value);
    }

    @Test
    @DisplayName("getColor() returns the value that was passed to the builder")
    void getColor() {
        int color = 11;
        ColumnEditBody body = ColumnEditBody.builder().color(color).build();
        assertThat(body.getColor()).isEqualTo(color);
    }

    @Test
    @DisplayName("getBoardId() returns the value that was passed to the builder")
    void getBoardId() {
        String boardId = "id111";
        ColumnEditBody body = ColumnEditBody.builder().boardId(boardId).build();
        assertThat(body.getBoardId()).isEqualTo(boardId);
    }

    @Test
    @DisplayName("getDeleted() returns null if the value doesn't passed to the builder")
    void getDeletedNull() {
        ColumnEditBody body = ColumnEditBody.builder().build();
        assertThat(body.getDeleted()).isNull();
    }

    @Test
    @DisplayName("getTitle() returns null if the value doesn't passed to the builder")
    void getTitleNull() {
        ColumnEditBody body = ColumnEditBody.builder().build();
        assertThat(body.getTitle()).isNull();
    }

    @Test
    @DisplayName("getColor() returns null if the value doesn't passed to the builder")
    void getColorNull() {
        ColumnEditBody body = ColumnEditBody.builder().build();
        assertThat(body.getColor()).isNull();
    }

    @Test
    @DisplayName("getBoardId() returns null if the value doesn't passed to the builder")
    void getBoardIdNull() {
        ColumnEditBody body = ColumnEditBody.builder().build();
        assertThat(body.getBoardId()).isNull();
    }

    @Test
    @DisplayName("color() throws exception if the passed value lesser one")
    void colorLessOne() {
        int color = 0;
        ColumnEditBody.Builder builder = ColumnEditBody.builder();
        assertThatThrownBy(() -> builder.color(color)).isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    @DisplayName("color() throws exception if the passed value greater sixteen")
    void colorGreaterSixteen() {
        int color = 17;
        ColumnEditBody.Builder builder = ColumnEditBody.builder();
        assertThatThrownBy(() -> builder.color(color)).isInstanceOf(IllegalArgumentException.class);
    }
}