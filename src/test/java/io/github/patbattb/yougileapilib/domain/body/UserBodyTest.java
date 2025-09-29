package io.github.patbattb.yougileapilib.domain.body;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.lang.reflect.Constructor;
import java.lang.reflect.Modifier;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class UserBodyTest {

    @Test
    @DisplayName("The class doesn't have default constructor")
    void noDefaultConstructor() {
        assertThatThrownBy(UserBody.class::getDeclaredConstructor).isInstanceOf(NoSuchMethodException.class);
    }

    @Test
    @DisplayName("The class has private constructor with (String) parameter")
    void privateConstructor() throws NoSuchMethodException {
        Constructor<UserBody> constructor = UserBody.class.getDeclaredConstructor(String.class);
        assertThat(constructor.getModifiers()).isEqualTo(Modifier.PRIVATE);
    }

    @Test
    @DisplayName("builder() returns the Builder with the UserBody")
    void builder() {
        UserBody.Builder builder = UserBody.builder("");
        assertThat(builder.body).isInstanceOf(UserBody.class);
    }

    @Test
    @DisplayName("isAdmin() returns the value that was passed to the builder")
    void isAdmin() {
        boolean isAdmin = true;
        UserBody body = UserBody.builder("").isAdmin(isAdmin).build();
        assertThat(body.isAdmin()).isEqualTo(isAdmin);
    }

    @Test
    @DisplayName("getEmail() returns the value that was passed to the builder")
    void getEmail() {
        String email = "email@ex.com";
        UserBody body = UserBody.builder(email).build();
        assertThat(body.getEmail()).isEqualTo(email);
    }

    @Test
    @DisplayName("isAdmin() returns null if the value wasn't passed to the builder")
    void isAdminNull() {
        UserBody body = UserBody.builder("").build();
        assertThat(body.isAdmin()).isNull();
    }
}