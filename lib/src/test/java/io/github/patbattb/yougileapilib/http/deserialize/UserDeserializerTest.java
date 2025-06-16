package io.github.patbattb.yougileapilib.http.deserialize;

import com.fasterxml.jackson.core.JsonProcessingException;
import io.github.patbattb.yougileapilib.domain.User;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class UserDeserializerTest extends AbstractDeserializerTest {

    static String id;
    static String email;
    static String realName;
    static String status;
    static long lastActivity;

    @BeforeAll
    static void beforeAll() {
        id = "9c685a12-4450-4764-8ba3-f49a73d00b10";
        email = "ex@ex.com";
        realName = "Igor";
        status = "online";
        lastActivity = 1749571342210L;
    }

    @Test
    @DisplayName("Deserialize required fields only")
    void deserialize() throws JsonProcessingException {
        String jsonString = String.format(
                """
                {
                  "id": "%s",
                  "email": "%s",
                  "realName": "%s",
                  "status": "%s",
                  "lastActivity": %s
                }
                """, id, email, realName, status, lastActivity
        );
        User user = mapper.readValue(jsonString, User.class);
        assertThat(user.getId()).isEqualTo(id);
        assertThat(user.getEmail()).isEqualTo(email);
        assertThat(user.getRealName()).isEqualTo(realName);
        assertThat(user.getStatus()).isEqualTo(status);
        assertThat(user.getLastActivity()).isEqualTo(lastActivity);
        assertThat(user.isAdmin()).isEqualTo(false);

    }

    @Test
    @DisplayName("Deserialize isAdmin field")
    void deserializeIsAdmin() throws JsonProcessingException {
        boolean isAdmin = true;
        String jsonString = String.format(
                """
                {
                  "id": "%s",
                  "email": "%s",
                  "realName": "%s",
                  "status": "%s",
                  "lastActivity": %s,
                  "isAdmin": %s
                }
                """, id, email, realName, status, lastActivity, isAdmin
        );
        User user = mapper.readValue(jsonString, User.class);
        assertThat(user.isAdmin()).isEqualTo(isAdmin);

    }
}