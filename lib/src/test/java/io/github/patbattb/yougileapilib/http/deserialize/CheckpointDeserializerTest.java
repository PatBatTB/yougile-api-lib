package io.github.patbattb.yougileapilib.http.deserialize;

import com.fasterxml.jackson.core.JsonProcessingException;
import io.github.patbattb.yougileapilib.domain.Checkpoint;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class CheckpointDeserializerTest extends AbstractDeserializerTest {

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

        Checkpoint checkpoint = mapper.readValue(jsonString, Checkpoint.class);
        assertThat(checkpoint.getTitle()).isEqualTo(title);
        assertThat(checkpoint.isCompleted()).isEqualTo(completed);
    }
}