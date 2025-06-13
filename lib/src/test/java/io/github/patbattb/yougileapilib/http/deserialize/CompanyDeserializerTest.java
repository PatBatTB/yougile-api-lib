package io.github.patbattb.yougileapilib.http.deserialize;

import com.fasterxml.jackson.core.JsonProcessingException;
import io.github.patbattb.yougileapilib.domain.Company;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class CompanyDeserializerTest extends AbstractDeserializerTest {

    static String id;
    static String title;
    static long created;


    @BeforeAll
    static void beforeAll() {
        id = "4f6f0391-0f94-4d30-9b0e-99430a36d4fb";
        title = "GosService";
        created = 1623223299149L;
    }

    @Test
    @DisplayName("Deserialize required fields only")
    void deserialize() throws JsonProcessingException {
        String jsonString = String.format(
                """
                {
                  "id": "%s",
                  "title": "%s",
                  "timestamp": %s
                }
                """, id, title, created
        );
        Company company = mapper.readValue(jsonString, Company.class);
        assertThat(company.isDeleted()).isEqualTo(false);
        assertThat(company.getId()).isEqualTo(id);
        assertThat(company.getTitle()).isEqualTo(title);
        assertThat(company.getCreated()).isEqualTo(created);
    }

    @Test
    @DisplayName("Deserialize deleted field")
    void deserializeDeleted() throws JsonProcessingException {
        boolean deleted = true;
        String jsonString = String.format(
                """
                {
                  "deleted": %s,
                  "id": "%s",
                  "title": "%s",
                  "timestamp": %s
                }
                """, deleted, id, title, created
        );
        Company company = mapper.readValue(jsonString, Company.class);
        assertThat(company.isDeleted()).isEqualTo(deleted);
    }

}