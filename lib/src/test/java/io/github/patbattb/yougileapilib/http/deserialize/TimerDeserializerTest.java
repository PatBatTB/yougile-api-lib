package io.github.patbattb.yougileapilib.http.deserialize;

import com.fasterxml.jackson.core.JsonProcessingException;
import io.github.patbattb.yougileapilib.domain.Timer;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class TimerDeserializerTest extends AbstractDeserializerTest {

    @Test
    @DisplayName("Deserialize required fields only")
    void deserialize() throws JsonProcessingException {
        boolean running = true;
        int seconds = -181103;
        long since = 1749579680775L;
        String jsonString = String.format(
                """
                {
                    "running": %s,
                    "seconds": %s,
                    "since": %s
                }
                """, running, seconds, since
        );
        Timer timer = mapper.readValue(jsonString, Timer.class);
        assertThat(timer.isRunning()).isEqualTo(running);
        assertThat(timer.getSeconds()).isEqualTo(seconds);
        assertThat(timer.getSince()).isEqualTo(since);
    }
}