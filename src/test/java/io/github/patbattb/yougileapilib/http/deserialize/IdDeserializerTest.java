package io.github.patbattb.yougileapilib.http.deserialize;

import com.fasterxml.jackson.core.JsonProcessingException;
import io.github.patbattb.yougileapilib.domain.Id;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class IdDeserializerTest extends AbstractDeserializerTest {

    @Test
    @DisplayName("Deserialize required only fields")
    void deserialize() throws JsonProcessingException {
        String id = "4f6f0391-0f94-4d30-9b0e-99430a36d4fb";
        String jsonString = String.format(
                """
                {
                  "id": "%s"
                }
                """, id
        );
        Id result = mapper.readValue(jsonString, Id.class);
        assertThat(result.id()).isEqualTo(id);
    }
}