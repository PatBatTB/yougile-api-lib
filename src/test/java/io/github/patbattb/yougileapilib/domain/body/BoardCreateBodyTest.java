package io.github.patbattb.yougileapilib.domain.body;

import io.github.patbattb.yougileapilib.domain.BoardStickerInfo;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import java.lang.reflect.Constructor;
import java.lang.reflect.Modifier;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class BoardCreateBodyTest {

    @Test
    @DisplayName("The class doesn't have default constructor")
    void noDefaultConstructor() {
        assertThatThrownBy(BoardCreateBody.class::getDeclaredConstructor).isInstanceOf(NoSuchMethodException.class);
    }

    @Test
    @DisplayName("The class has private constructor with (String, String) parameters")
    void hasPrivateConstructor() throws NoSuchMethodException {
        Constructor<BoardCreateBody> constructor = BoardCreateBody.class.getDeclaredConstructor(String.class, String.class);
        assertThat(constructor.getModifiers()).isEqualTo(Modifier.PRIVATE);
    }

    @Test
    @DisplayName("builder() returns the Builder with the BoardCreateBody")
    void builder() {
        BoardCreateBody.Builder builder = BoardCreateBody.builder("", "");
        assertThat(builder.body).isInstanceOf(BoardCreateBody.class);
    }

    @Test
    @DisplayName("getTitle() returns the value that was passed to the builder")
    void getTitle() {
        String title = "title111";
        BoardCreateBody body = BoardCreateBody.builder(title, "").build();
        assertThat(body.getTitle()).isEqualTo(title);
    }

    @Test
    @DisplayName("getProjectId returns the value that was passed to the builder")
    void getProjectId() {
        String projectId = "id111";
        BoardCreateBody body = BoardCreateBody.builder("", projectId).build();
        assertThat(body.getProjectId()).isEqualTo(projectId);
    }

    @Test
    @DisplayName("getStickers returns the value that was passed to the builder")
    void getStickers() {
        BoardStickerInfo boardStickerInfo = Mockito.mock(BoardStickerInfo.class);
        BoardCreateBody body = BoardCreateBody.builder("", "").stickers(boardStickerInfo).build();
        assertThat(body.getStickers()).isEqualTo(boardStickerInfo);
    }

    @Test
    @DisplayName("getStickers returns null if the value wasn't passed to the builder")
    void getStickersNull() {
        BoardCreateBody body = BoardCreateBody.builder("", "").build();
        assertThat(body.getStickers()).isNull();
    }
}