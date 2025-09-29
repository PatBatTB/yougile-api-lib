package io.github.patbattb.yougileapilib.http.deserialize;

import com.fasterxml.jackson.core.JsonProcessingException;
import io.github.patbattb.yougileapilib.domain.AuthKey;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class AuthKeyDeserializerTest extends AbstractDeserializerTest {

    @Test
    @DisplayName("Deserialize only required fields")
    void deserialize() throws JsonProcessingException {
        String key = "H6HngIA816fpIhY7tBvWx/it3YbVvEt/33Sk8afA39MCR9a";
        String jsonString = String.format(
                """
                {
                  "key": "%s"
                }
                """, key
        );
        AuthKey authKey = mapper.readValue(jsonString, AuthKey.class);
        assertThat(authKey.key()).isEqualTo(key);
    }
}