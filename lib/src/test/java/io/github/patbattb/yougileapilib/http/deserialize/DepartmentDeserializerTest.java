package io.github.patbattb.yougileapilib.http.deserialize;

import com.fasterxml.jackson.core.JsonProcessingException;
import io.github.patbattb.yougileapilib.domain.Department;
import io.github.patbattb.yougileapilib.domain.UserRole;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Collections;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

class DepartmentDeserializerTest extends AbstractDeserializerTest {

    static String id;
    static String title;

    @BeforeAll
    static void beforeAll() {
        id = "4f6f0391-0f94-4d30-9b0e-99430a36d4fb";
        title = "Dev department";
    }

    @Test
    @DisplayName("Deserialize required fields only")
    void deserialize() throws JsonProcessingException {
        boolean deleted = false;
        String jsonString = String.format(
                """
                {
                  "id": "%s",
                  "title": "%s"
                }
                """, id, title
        );
        Department department = mapper.readValue(jsonString, Department.class);
        assertThat(department.getId()).isEqualTo(id);
        assertThat(department.getTitle()).isEqualTo(title);
        assertThat(department.isDeleted()).isEqualTo(false);
        assertThat(department.getParentId()).isNull();
        assertThat(department.getUsers()).isEqualTo(Collections.EMPTY_LIST);
    }

    @Test
    @DisplayName("Deserialize deleted field")
    void deserializeDeleted() throws JsonProcessingException {
        boolean deleted = true;
        String jsonString = String.format(
                """
                {
                  "id": "%s",
                  "title": "%s",
                  "deleted": %s
                }
                """, id, title, deleted
        );
        Department department = mapper.readValue(jsonString, Department.class);
        assertThat(department.isDeleted()).isEqualTo(deleted);
    }

    @Test
    @DisplayName("Deserialize parentId field")
    void deserializeParentId() throws JsonProcessingException {
        String parentId = "001623dc-6501-461b-9de6-c1d1d6fc1d16";
        String jsonString = String.format(
                """
                {
                  "id": "%s",
                  "title": "%s",
                  "parentId": "%s"
                }
                """, id, title, parentId
        );
        Department department = mapper.readValue(jsonString, Department.class);
        assertThat(department.getParentId()).isEqualTo(parentId);
    }

    @Test
    @DisplayName("Deserialize users field")
    void deserializeUsers() throws JsonProcessingException {
        UserRole userOne = new UserRole("4902b994-b806-4af4-acec-018ea5ea6468", "manager");
        UserRole userTwo = new UserRole("8aeaeb9d-f94e-4c66-96d3-eb8d96fe7018", "member");
        String jsonString = String.format(
                """
                {
                  "id": "%s",
                  "title": "%s",
                  "users": {
                    "%s": "%s",
                    "%s": "%s"
                  }
                }
                """, id, title, userOne.getId(), userOne.getRoleId(), userTwo.getId(), userTwo.getRoleId()
        );
        Department department = mapper.readValue(jsonString, Department.class);
        assertThat(department.getUsers()).isEqualTo(List.of(userOne, userTwo));
    }
}