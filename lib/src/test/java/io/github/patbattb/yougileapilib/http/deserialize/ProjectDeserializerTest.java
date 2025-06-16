package io.github.patbattb.yougileapilib.http.deserialize;

import com.fasterxml.jackson.core.JsonProcessingException;
import io.github.patbattb.yougileapilib.domain.Project;
import io.github.patbattb.yougileapilib.domain.UserRole;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Collections;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

class ProjectDeserializerTest extends AbstractDeserializerTest {

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
        boolean deleted = false;
        String jsonString = String.format(
                """
                {
                  "id": "%s",
                  "title": "%s",
                  "timestamp": %s
                }
                """, id, title, created
        );
        Project project = mapper.readValue(jsonString, Project.class);
        assertThat(project.isDeleted()).isEqualTo(deleted);
        assertThat(project.getId()).isEqualTo(id);
        assertThat(project.getTitle()).isEqualTo(title);
        assertThat(project.getUsers()).isEqualTo(Collections.EMPTY_LIST);
    }

    @Test
    @DisplayName("Deserialize users field")
    void deserializeUsers() throws JsonProcessingException {
        UserRole userOne = new UserRole("4902b994-b806-4af4-acec-018ea5ea6468", "worker");
        UserRole userTwo = new UserRole("8aeaeb9d-f94e-4c66-96d3-eb8d96fe7018", "ee88efd5-5cb2-41a0-9ea2-295da25863d4");
        String jsonString = String.format(
                """
                {
                  "id": "%s",
                  "title": "%s",
                  "timestamp": %s,
                  "users": {
                      "%s": "%s",
                      "%s": "%s"
                  }
                }
                """, id, title, created, userOne.getId(), userOne.getRoleId(), userTwo.getId(), userTwo.getRoleId()
        );
        Project project = mapper.readValue(jsonString, Project.class);
        assertThat(project.getUsers()).isEqualTo(List.of(userOne, userTwo));
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
        Project project = mapper.readValue(jsonString, Project.class);
        assertThat(project.isDeleted()).isEqualTo(deleted);
    }
}