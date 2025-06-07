package io.github.patbattb.yougileapilib.domain.body;

import io.github.patbattb.yougileapilib.domain.BoardStickerInfo;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import java.lang.reflect.Constructor;
import java.lang.reflect.Modifier;

import static org.assertj.core.api.Assertions.assertThat;

class BoardEditBodyTest {

    @Test
    @DisplayName("The class has private default constructor")
    void constructor() throws NoSuchMethodException {
        Constructor<BoardEditBody> constructor = BoardEditBody.class.getDeclaredConstructor();
        assertThat(constructor.getModifiers()).isEqualTo(Modifier.PRIVATE);
    }

    @Test
    @DisplayName("builder() returns the Builder with the BoardEditBody")
    void builder() {
        BoardEditBody.Builder builder = BoardEditBody.builder();
        assertThat(builder.body).isInstanceOf(BoardEditBody.class);
    }

    @Test
    @DisplayName("getDeleted() returns the value that was passed to the builder")
    void getDeleted() {
        boolean deleted = true;
        BoardEditBody body = BoardEditBody.builder().deleted(deleted).build();
        assertThat(body.getDeleted()).isEqualTo(deleted);
    }

    @Test
    @DisplayName("getTitle() returns the value that was passed to the builder")
    void getTitle() {
        String title = "title111";
        BoardEditBody body = BoardEditBody.builder().title(title).build();
        assertThat(body.getTitle()).isEqualTo(title);
    }

    @Test
    @DisplayName("getProjectId() returns the value that was passed to the builder")
    void getProjectId() {
        String projectId = "id111";
        BoardEditBody body = BoardEditBody.builder().projectId(projectId).build();
        assertThat(body.getProjectId()).isEqualTo(projectId);
    }

    @Test
    @DisplayName("getStickers() returns the value that was passed to the builder")
    void getStickers() {
        BoardStickerInfo boardStickerInfo = Mockito.mock(BoardStickerInfo.class);
        BoardEditBody body = BoardEditBody.builder().stickers(boardStickerInfo).build();
        assertThat(body.getStickers()).isEqualTo(boardStickerInfo);
    }

    @Test
    @DisplayName("getDeleted() returns null if the value wasn't passed to the builder")
    void getDeletedNull() {
        BoardEditBody body = BoardEditBody.builder().build();
        assertThat(body.getDeleted()).isNull();
    }

    @Test
    @DisplayName("getTitle() returns null if the value wasn't passed to the builder")
    void getTitleNull() {
        BoardEditBody body = BoardEditBody.builder().build();
        assertThat(body.getTitle()).isNull();
    }

    @Test
    @DisplayName("getProjectId() returns null if the value wasn't passed to the builder")
    void getProjectIdNull() {
        BoardEditBody body = BoardEditBody.builder().build();
        assertThat(body.getProjectId()).isNull();
    }

    @Test
    @DisplayName("getStickers() returns null if the value wasn't passed to the builder")
    void getStickersNull() {
        BoardEditBody body = BoardEditBody.builder().build();
        assertThat(body.getStickers()).isNull();
    }
}