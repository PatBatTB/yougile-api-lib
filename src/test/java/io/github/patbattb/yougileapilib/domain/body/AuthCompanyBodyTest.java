package io.github.patbattb.yougileapilib.domain.body;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.lang.reflect.Constructor;
import java.lang.reflect.Modifier;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class AuthCompanyBodyTest {



    @Test
    @DisplayName("The class doesn't have default constructor.")
    void noDefaultConstructorTest() {
        assertThatThrownBy(AuthKeyBody.class::getDeclaredConstructor).isInstanceOf(NoSuchMethodException.class);
    }

    @Test
    @DisplayName("The class has private constructor with (String, String) parameters.")
    void TestConstructorStringString() throws NoSuchMethodException {
        Constructor<AuthCompanyBody> constructor = AuthCompanyBody.class.getDeclaredConstructor(String.class, String.class);
        assertThat(constructor.getModifiers()).isEqualTo(Modifier.PRIVATE);
    }

    @Test
    @DisplayName("builder() returns the Builder with the AuthCompanyBody")
    void builder() {
        AuthCompanyBody.Builder builder = AuthCompanyBody.builder("", "");
        assertThat(builder.body).isInstanceOf(AuthCompanyBody.class);
    }

    @Test
    @DisplayName("getLogin() returns the value that was passed to the builder")
    void getLogin() {
        String login = "log111";
        AuthCompanyBody body = AuthCompanyBody.builder(login, "").build();
        assertThat(body.getLogin()).isEqualTo(login);
    }

    @Test
    @DisplayName("getPassword() returns the value that was passed to the builder")
    void getPassword() {
        String password = "pass111";
        AuthCompanyBody body = AuthCompanyBody.builder("", password).build();
        assertThat(body.getPassword()).isEqualTo(password);
    }

    @Test
    @DisplayName("getName() returns the value that was passed to the builder")
    void getName() {
        String name = "name111";
        AuthCompanyBody body = AuthCompanyBody.builder("", "").name(name).build();
        assertThat(body.getName()).isEqualTo(name);
    }

    @Test
    @DisplayName("getName() returns null if the value wasn't passed to the builder")
    void getNameNull() {
        AuthCompanyBody body = AuthCompanyBody.builder("", "").build();
        assertThat(body.getName()).isNull();
    }
}