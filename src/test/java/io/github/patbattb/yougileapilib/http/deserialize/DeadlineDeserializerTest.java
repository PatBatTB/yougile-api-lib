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
        String jsonString =
                """
                {
                    "deadline": 1653029146646,
                    "startDate": 1653028146646,
                    "withTime": true,
                    "history": [
                        {
                          "deadline": 1750507200000,
                          "timestamp": 1750403931364,
                          "notifyBefore": 0,
                          "withTime": false,
                          "by": "9c685a12-4450-4764-8ba3-f49a73d00b10"
                        },
                        {
                          "deadline": 1750507200000,
                          "timestamp": 1750403933214,
                          "notifyBefore": 0,
                          "withTime": true,
                          "by": "9c685a12-4450-4764-8ba3-f49a73d00b10"
                        }
                    ],
                    "blockedPoints": [
                      "string"
                    ],
                    "links": [
                      "string"
                    ]
                  }
                """;
        Deadline deadlineClass = mapper.readValue(jsonString, Deadline.class);
    }
}