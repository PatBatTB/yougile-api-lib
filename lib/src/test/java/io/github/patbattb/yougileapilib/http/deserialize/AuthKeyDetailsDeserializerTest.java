package io.github.patbattb.yougileapilib.http.deserialize;

import com.fasterxml.jackson.core.JsonProcessingException;
import io.github.patbattb.yougileapilib.domain.AuthKeyDetails;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class AuthKeyDetailsDeserializerTest extends AbstractDeserializerTest {

    @Test
    @DisplayName("Deserialize required fields only")
    void deserialize() throws JsonProcessingException {
        String key = "H6HngIA816fpIhY7tBvWx/it3YbVvEt/33Sk8afA39MCR9a";
        String companyId = "858c5d32-dd93-4d2b-9b9c-aa1ec7007c0c";
        long timestamp = 1560506639447L;
        boolean deleted = true;
        String jsonString = String.format(
                """
                {
                    "key": "%s",
                    "companyId": "%s",
                    "timestamp": "%s",
                    "deleted": %s
                }
                """, key, companyId, timestamp, deleted
        );
        AuthKeyDetails keyDetails = mapper.readValue(jsonString, AuthKeyDetails.class);
    }
}