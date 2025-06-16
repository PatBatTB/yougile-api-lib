package io.github.patbattb.yougileapilib.http.deserialize;

import com.fasterxml.jackson.core.JsonProcessingException;
import io.github.patbattb.yougileapilib.domain.Checklist;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

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
}