package io.github.patbattb.yougileapilib.http.deserialize;

import com.fasterxml.jackson.core.JsonProcessingException;
import io.github.patbattb.yougileapilib.domain.Board;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class BoardDeserializerTest extends AbstractDeserializerTest {
    static String title;
    static String projectId;
    static String id;

    @BeforeAll
    static void BeforeAll() {
        title = "APINewTitle";
        projectId = "261abd9e-e47c-4873-b00b";
        id = "31f1-4ce2-8547";
    }

    @Test
    @DisplayName("Deserialize required fields only")
    void deserialize() throws JsonProcessingException {
        String jsonString = String.format(
                """
                {
                  "title": "%s",
                  "projectId": "%s",
                  "id": "%s"
                }
                """, title, projectId, id
        );
        Board board = mapper.readValue(jsonString, Board.class);
        assertThat(board.getTitle()).isEqualTo(title);
        assertThat(board.getProjectId()).isEqualTo(projectId);
        assertThat(board.getId()).isEqualTo(id);
        assertThat(board.isDeleted()).isEqualTo(false);
        assertThat(board.getStickers()).isNull();
    }

    @Test
    @DisplayName("Deserialize deleted field")
    void deserializeDeleted() throws JsonProcessingException {
        boolean deleted = true;
        String jsonString = String.format(
                """
                {
                  "title": "%s",
                  "projectId": "%s",
                  "id": "%s",
                  "deleted": %s
                }
                """, title, projectId, id, deleted
        );
        Board board = mapper.readValue(jsonString, Board.class);
        assertThat(board.isDeleted()).isEqualTo(deleted);
    }

    @Test
    @DisplayName("Deserialize stickers field")
    void deserializeStickers() throws JsonProcessingException {
        String jsonString = String.format(
                """
                {
                  "title": "%s",
                  "projectId": "%s",
                  "id": "%s",
                  "stickers": null
                }
                """, title, projectId, id
        );
        Board board = mapper.readValue(jsonString, Board.class);
        assertThat(board.getStickers()).isNull();
    }

}