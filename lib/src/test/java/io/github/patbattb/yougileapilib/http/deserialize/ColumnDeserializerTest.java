package io.github.patbattb.yougileapilib.http.deserialize;

import com.fasterxml.jackson.core.JsonProcessingException;
import io.github.patbattb.yougileapilib.domain.Column;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class ColumnDeserializerTest extends AbstractDeserializerTest {

    static String id;
    static String title;
    static String boardId;

    @BeforeAll
    static void beforeAll() {
        id = "4f6f0391-0f94-4d30-9b0e-99430a36d4fb";
        title = "To do";
        boardId = "0d923a9f-3675-43c6-84ce-f3580cf5e760";
    }

    @Test
    @DisplayName("Deserialize required fields only")
    void deserialize() throws JsonProcessingException {
        String jsonString = String.format(
                """
                {
                  "id": "%s",
                  "title": "%s",
                  "boardId": "%s"
                }
                """, id, title, boardId
        );
        Column column = mapper.readValue(jsonString, Column.class);
        assertThat(column.getId()).isEqualTo(id);
        assertThat(column.getTitle()).isEqualTo(title);
        assertThat(column.getBoardId()).isEqualTo(boardId);
        assertThat(column.isDeleted()).isEqualTo(false);
        assertThat(column.getColor()).isNull();
    }

    @Test
    @DisplayName("Deserialize deleted field")
    void deserializeDeleted() throws JsonProcessingException {
        boolean deleted = true;
        String jsonString = String.format(
                """
                {
                  "id": "%s",
                  "title": "%s",
                  "boardId": "%s",
                  "deleted": %s
                }
                """, id, title, boardId, deleted
        );
        Column column = mapper.readValue(jsonString, Column.class);
        assertThat(column.isDeleted()).isEqualTo(deleted);
    }

    @Test
    @DisplayName("Deserialize color field")
    void deserializeColor() throws JsonProcessingException {
        int color = 10;
        String jsonString = String.format(
                """
                {
                  "id": "%s",
                  "title": "%s",
                  "boardId": "%s",
                  "color": %s
                }
                """, id, title, boardId, color
        );
        Column column = mapper.readValue(jsonString, Column.class);
        assertThat(column.getColor()).isEqualTo(color);
    }
}