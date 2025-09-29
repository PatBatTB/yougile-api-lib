package io.github.patbattb.yougileapilib.http.deserialize;

import com.fasterxml.jackson.core.JsonProcessingException;
import io.github.patbattb.yougileapilib.domain.TimeTracking;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class TimeTrackingDeserializerTest extends AbstractDeserializerTest {

    @Test
    @DisplayName("Deserialize required fields only")
    void deserialize() throws JsonProcessingException {
        int plan = 10;
        int work = 5;
        String jsonString = String.format(
                """
                {
                    "plan": %s,
                    "work": %s
                  }
                """, plan, work
        );
        TimeTracking timeTracking = mapper.readValue(jsonString, TimeTracking.class);
        assertThat(timeTracking.getPlan()).isEqualTo(plan);
        assertThat(timeTracking.getWork()).isEqualTo(work);
    }
}