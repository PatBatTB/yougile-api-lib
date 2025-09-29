package io.github.patbattb.yougileapilib.http.deserialize;

import com.fasterxml.jackson.core.JsonProcessingException;
import io.github.patbattb.yougileapilib.domain.Stopwatch;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class StopwatchDeserializerTest extends AbstractDeserializerTest {

    @Test
    @DisplayName("Deserialize required fields only")
    void deserialize() throws JsonProcessingException {
        boolean running = true;
        int seconds = 23;
        long atMoment = 1749574321836L;
        String jsonString = String.format(
                """
                {
                  "running": %s,
                  "seconds": %s,
                  "atMoment": %s
                }
                """, running, seconds, atMoment
        );
        Stopwatch stopwatch = mapper.readValue(jsonString, Stopwatch.class);
        assertThat(stopwatch.isRunning()).isEqualTo(running);
        assertThat(stopwatch.getSeconds()).isEqualTo(seconds);
        assertThat(stopwatch.getAtMoment()).isEqualTo(atMoment);
    }
}