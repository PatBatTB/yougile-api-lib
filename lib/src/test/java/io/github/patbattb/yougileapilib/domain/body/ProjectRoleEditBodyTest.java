package io.github.patbattb.yougileapilib.domain.body;

import io.github.patbattb.yougileapilib.domain.ProjectPermissions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import java.lang.reflect.Constructor;
import java.lang.reflect.Modifier;

import static org.assertj.core.api.Assertions.assertThat;

class ProjectRoleEditBodyTest {

    @Test
    @DisplayName("The class has private default constructor")
    void constructor() throws NoSuchMethodException {
        Constructor<ProjectRoleEditBody> constructor = ProjectRoleEditBody.class.getDeclaredConstructor();
        assertThat(constructor.getModifiers()).isEqualTo(Modifier.PRIVATE);
    }

    @Test
    @DisplayName("builder() returns the Builder with the ProjectRoleEditBody")
    void builder() {
        ProjectRoleEditBody.Builder builder = ProjectRoleEditBody.builder();
        assertThat(builder.body).isInstanceOf(ProjectRoleEditBody.class);
    }

    @Test
    @DisplayName("getName() returns the value that was passed to the builder")
    void getName() {
        String name = "name111";
        ProjectRoleEditBody body = ProjectRoleEditBody.builder().name(name).build();
        assertThat(body.getName()).isEqualTo(name);
    }

    @Test
    @DisplayName("getDescription() returns the value that was passed to the builder")
    void getDescription() {
        String description = "descr111";
        ProjectRoleEditBody body = ProjectRoleEditBody.builder().description(description).build();
        assertThat(body.getDescription()).isEqualTo(description);
    }

    @Test
    @DisplayName("getPermissions() returns the value that was passed to the builder")
    void getPermissions() {
        ProjectPermissions permissions = Mockito.mock(ProjectPermissions.class);
        ProjectRoleEditBody body = ProjectRoleEditBody.builder().projectPermissions(permissions).build();
        assertThat(body.getPermissions()).isEqualTo(permissions);
    }

    @Test
    @DisplayName("getName() returns the value that was passed to the builder")
    void getNameNull() {
        ProjectRoleEditBody body = ProjectRoleEditBody.builder().build();
        assertThat(body.getName()).isNull();
    }

    @Test
    @DisplayName("getDescription() returns the value that was passed to the builder")
    void getDescriptionNull() {
        ProjectRoleEditBody body = ProjectRoleEditBody.builder().build();
        assertThat(body.getDescription()).isNull();
    }

    @Test
    @DisplayName("getPermissions() returns the value that was passed to the builder")
    void getPermissionsNull() {
        ProjectRoleEditBody body = ProjectRoleEditBody.builder().build();
        assertThat(body.getPermissions()).isNull();
    }
}