package io.github.patbattb.yougileapilib.http.deserialize;

import com.fasterxml.jackson.core.JsonProcessingException;
import io.github.patbattb.yougileapilib.domain.ChecklistOption;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class ChecklistOptionDeserializerTest extends AbstractDeserializerTest {

    @Test
    @DisplayName("Deserialize required fields only")
    void deserialize() throws JsonProcessingException {
        String title = "title111";
        boolean completed = true;

        String jsonString = String.format(
                """
                {
                  "title": "%s",
                  "isCompleted": %s
                }
                """, title, completed
        );

        ChecklistOption checklistOption = mapper.readValue(jsonString, ChecklistOption.class);
        assertThat(checklistOption.getTitle()).isEqualTo(title);
        assertThat(checklistOption.isCompleted()).isEqualTo(completed);
    }
}