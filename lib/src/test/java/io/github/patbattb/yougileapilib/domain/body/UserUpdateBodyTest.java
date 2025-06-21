package io.github.patbattb.yougileapilib.domain.body;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.lang.reflect.Constructor;
import java.lang.reflect.Modifier;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class UserUpdateBodyTest {

    @Test
    @DisplayName("The class doesn't have default constructor")
    void noDefaultConstructor() {
        assertThatThrownBy(UserUpdateBody.class::getDeclaredConstructor).isInstanceOf(NoSuchMethodException.class);
    }

    @Test
    @DisplayName("The class has private constructor with (boolean) parameter")
    void privateConstructor() throws NoSuchMethodException {
        Constructor<UserUpdateBody> constructor = UserUpdateBody.class.getDeclaredConstructor(boolean.class);
        assertThat(constructor.getModifiers()).isEqualTo(Modifier.PRIVATE);
    }

    @Test
    @DisplayName("builder() returns the Builder with the UserEditBody")
    void builder() {
        UserUpdateBody.Builder builder = UserUpdateBody.builder(false);
        assertThat(builder.body).isInstanceOf(UserUpdateBody.class);
    }

    @Test
    @DisplayName("isAdmin() returns the value that was passed to the builder")
    void isAdmin() {
        boolean isAdmin = true;
        UserUpdateBody body = UserUpdateBody.builder(isAdmin).build();
        assertThat(body.isAdmin()).isEqualTo(isAdmin);
    }
}