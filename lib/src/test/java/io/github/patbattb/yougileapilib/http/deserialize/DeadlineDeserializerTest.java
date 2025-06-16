package io.github.patbattb.yougileapilib.http.deserialize;

import com.fasterxml.jackson.core.JsonProcessingException;
import io.github.patbattb.yougileapilib.domain.Deadline;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class DeadlineDeserializerTest extends AbstractDeserializerTest {

    static long deadline;


    @Test
    @DisplayName("Deserialize required fields only")
    void deserialize() throws JsonProcessingException {
        String jsonString = String.format(
                """
                {
                    "deadline": 1653029146646,
                    "startDate": 1653028146646,
                    "withTime": true,
                    "history": [
                      "string"
                    ],
                    "blockedPoints": [
                      "string"
                    ],
                    "links": [
                      "string"
                    ]
                  }
                """
        );
        Deadline deadlineClass = mapper.readValue(jsonString, Deadline.class);
    }
}