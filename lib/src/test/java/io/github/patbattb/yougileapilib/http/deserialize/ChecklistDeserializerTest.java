package io.github.patbattb.yougileapilib.http.deserialize;

import com.fasterxml.jackson.core.JsonProcessingException;
import io.github.patbattb.yougileapilib.domain.Checklist;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Collections;

import static org.assertj.core.api.Assertions.assertThat;

class ChecklistDeserializerTest extends AbstractDeserializerTest {

    @Test
    @DisplayName("Deserialize required fields only")
    void deserialize() throws JsonProcessingException {
        String checklistTitle = "list 1";
        String jsonString = String.format(
                """
                {
                  "title": "%s",
                  "items": [
                    {
                      "title": "option 1",
                      "isCompleted": false
                    },
                    {
                      "title": "option 2",
                      "isCompleted": false
                    }
                  ]
                }
                """, checklistTitle
        );
        Checklist checklist = mapper.readValue(jsonString, Checklist.class);
        assertThat(checklist.getTitle()).isEqualTo(checklistTitle);
        assertThat(checklist.getItems().size()).isEqualTo(2);
    }

    @Test
    @DisplayName("Deserialize when items field is null")
    public void deserializeItemsNull() throws JsonProcessingException {
        String jsonString =
                """
                   {
                    "title": "title"
                   }
                """;
        Checklist checklist = mapper.readValue(jsonString, Checklist.class);
        assertThat(checklist.getItems()).isEqualTo(Collections.EMPTY_LIST);
    }

    @Test
    @DisplayName("Deserialize when items not a array")
    public void deserializeItemsNotArray() throws JsonProcessingException {
        String jsonString = """
                {
                    "title": "title",
                    "items": "item"
                }""";
        Checklist checklist = mapper.readValue(jsonString, Checklist.class);
        assertThat(checklist.getItems()).isEqualTo(Collections.EMPTY_LIST);
    }
}