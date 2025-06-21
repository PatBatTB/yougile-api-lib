package io.github.patbattb.yougileapilib.domain.body;

import io.github.patbattb.yougileapilib.domain.ProjectPermissions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import java.lang.reflect.Constructor;
import java.lang.reflect.Modifier;

import static org.assertj.core.api.Assertions.assertThat;

class ProjectRoleUpdateBodyTest {

    @Test
    @DisplayName("The class has private default constructor")
    void constructor() throws NoSuchMethodException {
        Constructor<ProjectRoleUpdateBody> constructor = ProjectRoleUpdateBody.class.getDeclaredConstructor();
        assertThat(constructor.getModifiers()).isEqualTo(Modifier.PRIVATE);
    }

    @Test
    @DisplayName("builder() returns the Builder with the ProjectRoleEditBody")
    void builder() {
        ProjectRoleUpdateBody.Builder builder = ProjectRoleUpdateBody.builder();
        assertThat(builder.body).isInstanceOf(ProjectRoleUpdateBody.class);
    }

    @Test
    @DisplayName("getName() returns the value that was passed to the builder")
    void getName() {
        String name = "name111";
        ProjectRoleUpdateBody body = ProjectRoleUpdateBody.builder().name(name).build();
        assertThat(body.getName()).isEqualTo(name);
    }

    @Test
    @DisplayName("getDescription() returns the value that was passed to the builder")
    void getDescription() {
        String description = "descr111";
        ProjectRoleUpdateBody body = ProjectRoleUpdateBody.builder().description(description).build();
        assertThat(body.getDescription()).isEqualTo(description);
    }

    @Test
    @DisplayName("getPermissions() returns the value that was passed to the builder")
    void getPermissions() {
        ProjectPermissions permissions = Mockito.mock(ProjectPermissions.class);
        ProjectRoleUpdateBody body = ProjectRoleUpdateBody.builder().projectPermissions(permissions).build();
        assertThat(body.getPermissions()).isEqualTo(permissions);
    }

    @Test
    @DisplayName("getName() returns the value that was passed to the builder")
    void getNameNull() {
        ProjectRoleUpdateBody body = ProjectRoleUpdateBody.builder().build();
        assertThat(body.getName()).isNull();
    }

    @Test
    @DisplayName("getDescription() returns the value that was passed to the builder")
    void getDescriptionNull() {
        ProjectRoleUpdateBody body = ProjectRoleUpdateBody.builder().build();
        assertThat(body.getDescription()).isNull();
    }

    @Test
    @DisplayName("getPermissions() returns the value that was passed to the builder")
    void getPermissionsNull() {
        ProjectRoleUpdateBody body = ProjectRoleUpdateBody.builder().build();
        assertThat(body.getPermissions()).isNull();
    }
}