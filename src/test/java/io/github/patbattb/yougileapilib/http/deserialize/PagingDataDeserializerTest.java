package io.github.patbattb.yougileapilib.http.deserialize;

import com.fasterxml.jackson.core.JsonProcessingException;
import io.github.patbattb.yougileapilib.domain.PagingData;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class PagingDataDeserializerTest extends AbstractDeserializerTest {

    @Test
    @DisplayName("Deserialize required only fields")
    void deserialize() throws JsonProcessingException {
        int limit = 20;
        int offset = 5;
        boolean next = true;
        int count = 10;
        String jsonString = String.format(
                """
                {
                  "limit": %s,
                  "offset": %s,
                  "next": %s,
                  "count": %s
                }
                """, limit, offset, next, count
        );
        PagingData data = mapper.readValue(jsonString, PagingData.class);
        assertThat(data.limit()).isEqualTo(limit);
        assertThat(data.offset()).isEqualTo(offset);
        assertThat(data.next()).isEqualTo(next);
        assertThat(data.count()).isEqualTo(count);
    }
}