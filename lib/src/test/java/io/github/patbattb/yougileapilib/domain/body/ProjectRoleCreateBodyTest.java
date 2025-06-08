package io.github.patbattb.yougileapilib.domain.body;

import io.github.patbattb.yougileapilib.domain.ProjectPermissions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import java.lang.reflect.Constructor;
import java.lang.reflect.Modifier;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class ProjectRoleCreateBodyTest {

    @Test
    @DisplayName("The class doesn't have default constructor")
    void noDefaultConstructor() {
        assertThatThrownBy(ProjectRoleCreateBody.class::getDeclaredConstructor).isInstanceOf(NoSuchMethodException.class);
    }

    @Test
    @DisplayName("The class has private constructor with (String, ProjectPermissions) parameters")
    void hasPrivateConstructor() throws NoSuchMethodException {
        Constructor<ProjectRoleCreateBody> constructor = ProjectRoleCreateBody.class.getDeclaredConstructor(String.class, ProjectPermissions.class);
        assertThat(constructor.getModifiers()).isEqualTo(Modifier.PRIVATE);
    }

    @Test
    @DisplayName("builder() returns the Builder with the ProjectRoleCreateBody")
    void builder() {
        ProjectPermissions permissions = Mockito.mock(ProjectPermissions.class);
        ProjectRoleCreateBody.Builder builder = ProjectRoleCreateBody.builder("", permissions);
        assertThat(builder.body).isInstanceOf(ProjectRoleCreateBody.class);
    }

    @Test
    @DisplayName("getName() returns the value that was passed to the builder")
    void getName() {
        String name = "name111";
        ProjectPermissions permissions = Mockito.mock(ProjectPermissions.class);
        ProjectRoleCreateBody body = ProjectRoleCreateBody.builder(name, permissions).build();
        assertThat(body.getName()).isEqualTo(name);
    }

    @Test
    @DisplayName("getDescription() returns the value that was passed to the builder")
    void getDescription() {
        String description = "descr111";
        ProjectPermissions permissions = Mockito.mock(ProjectPermissions.class);
        ProjectRoleCreateBody body = ProjectRoleCreateBody.builder("", permissions).description(description).build();
        assertThat(body.getDescription()).isEqualTo(description);
    }

    @Test
    @DisplayName("getPermissions() returns the value that was passed to the builder")
    void getPermissions() {
        ProjectPermissions permissions = Mockito.mock(ProjectPermissions.class);
        ProjectRoleCreateBody body = ProjectRoleCreateBody.builder("", permissions).build();
        assertThat(body.getPermissions()).isEqualTo(permissions);
    }

    @Test
    @DisplayName("getDescription() returns null if the value wasn't passed to the builder")
    void getDescriptionNull() {
        ProjectPermissions permissions = Mockito.mock(ProjectPermissions.class);
        ProjectRoleCreateBody body = ProjectRoleCreateBody.builder("", permissions).build();
        assertThat(body.getDescription()).isNull();
    }
}