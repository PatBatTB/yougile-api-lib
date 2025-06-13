package io.github.patbattb.yougileapilib.http.deserialize;

import com.fasterxml.jackson.core.JsonProcessingException;
import io.github.patbattb.yougileapilib.domain.AuthCompany;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class AuthCompanyDeserializerTest extends AbstractDeserializerTest{

    @Test
    @DisplayName("Deserialize only required fields")
    void deserialize() throws JsonProcessingException {
        String id = "ed75-4e8e-910a";
        String name = "testCompany";
        boolean isAdmin = true;
        String jsonString = String.format("""
                {
                  "id": "%s",
                  "name": "%s",
                  "isAdmin": %s
                }
                """, id, name, isAdmin);
        AuthCompany authCompany = mapper.readValue(jsonString, AuthCompany.class);
        assertThat(authCompany.getId()).isEqualTo(id);
        assertThat(authCompany.getName()).isEqualTo(name);
        assertThat(authCompany.isAdmin()).isEqualTo(isAdmin);
    }
}