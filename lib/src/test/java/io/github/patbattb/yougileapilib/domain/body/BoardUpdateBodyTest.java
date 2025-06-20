package io.github.patbattb.yougileapilib.domain.body;

import io.github.patbattb.yougileapilib.domain.BoardStickerInfo;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import java.lang.reflect.Constructor;
import java.lang.reflect.Modifier;

import static org.assertj.core.api.Assertions.assertThat;

class BoardUpdateBodyTest {

    @Test
    @DisplayName("The class has private default constructor")
    void constructor() throws NoSuchMethodException {
        Constructor<BoardUpdateBody> constructor = BoardUpdateBody.class.getDeclaredConstructor();
        assertThat(constructor.getModifiers()).isEqualTo(Modifier.PRIVATE);
    }

    @Test
    @DisplayName("builder() returns the Builder with the BoardEditBody")
    void builder() {
        BoardUpdateBody.Builder builder = BoardUpdateBody.builder();
        assertThat(builder.body).isInstanceOf(BoardUpdateBody.class);
    }

    @Test
    @DisplayName("getDeleted() returns the value that was passed to the builder")
    void getDeleted() {
        boolean deleted = true;
        BoardUpdateBody body = BoardUpdateBody.builder().deleted(deleted).build();
        assertThat(body.getDeleted()).isEqualTo(deleted);
    }

    @Test
    @DisplayName("getTitle() returns the value that was passed to the builder")
    void getTitle() {
        String title = "title111";
        BoardUpdateBody body = BoardUpdateBody.builder().title(title).build();
        assertThat(body.getTitle()).isEqualTo(title);
    }

    @Test
    @DisplayName("getProjectId() returns the value that was passed to the builder")
    void getProjectId() {
        String projectId = "id111";
        BoardUpdateBody body = BoardUpdateBody.builder().projectId(projectId).build();
        assertThat(body.getProjectId()).isEqualTo(projectId);
    }

    @Test
    @DisplayName("getStickers() returns the value that was passed to the builder")
    void getStickers() {
        BoardStickerInfo boardStickerInfo = Mockito.mock(BoardStickerInfo.class);
        BoardUpdateBody body = BoardUpdateBody.builder().stickers(boardStickerInfo).build();
        assertThat(body.getStickers()).isEqualTo(boardStickerInfo);
    }

    @Test
    @DisplayName("getDeleted() returns null if the value wasn't passed to the builder")
    void getDeletedNull() {
        BoardUpdateBody body = BoardUpdateBody.builder().build();
        assertThat(body.getDeleted()).isNull();
    }

    @Test
    @DisplayName("getTitle() returns null if the value wasn't passed to the builder")
    void getTitleNull() {
        BoardUpdateBody body = BoardUpdateBody.builder().build();
        assertThat(body.getTitle()).isNull();
    }

    @Test
    @DisplayName("getProjectId() returns null if the value wasn't passed to the builder")
    void getProjectIdNull() {
        BoardUpdateBody body = BoardUpdateBody.builder().build();
        assertThat(body.getProjectId()).isNull();
    }

    @Test
    @DisplayName("getStickers() returns null if the value wasn't passed to the builder")
    void getStickersNull() {
        BoardUpdateBody body = BoardUpdateBody.builder().build();
        assertThat(body.getStickers()).isNull();
    }
}