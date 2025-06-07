package io.github.patbattb.yougileapilib.domain.body;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.lang.reflect.Constructor;
import java.lang.reflect.Modifier;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;


class AuthKeyBodyTest {

    @Test
    @DisplayName("The class doesn't have default constructor.")
    void noDefaultConstructor() {
        assertThatThrownBy(AuthKeyBody.class::getDeclaredConstructor).isInstanceOf(NoSuchMethodException.class);
    }

    @Test
    @DisplayName("The class has private constructor with (String, String, String) parameters")
    void hasPrivateConstructor() throws NoSuchMethodException {
        Constructor<AuthKeyBody> constructor = AuthKeyBody.class.getDeclaredConstructor(String.class, String.class, String.class);
        assertThat(constructor.getModifiers()).isEqualTo(Modifier.PRIVATE);
    }

    @Test
    @DisplayName("builder() returns the Builder with the AuthKeyBody")
    void builder() {
        AuthKeyBody.Builder builder = AuthKeyBody.builder("", "", "");
        assertThat(builder.body).isInstanceOf(AuthKeyBody.class);
    }

    @Test
    @DisplayName("getLogin() returns the value that passed to the builder")
    void getLogin() {
        String login = "log111";
        AuthKeyBody body = AuthKeyBody.builder(login, "", "").build();
        assertThat(body.getLogin()).isEqualTo(login);
    }

    @Test
    @DisplayName("getPassword() returns the value that passed to the builder")
    void getPassword() {
        String password = "pass111";
        AuthKeyBody body = AuthKeyBody.builder("", password, "").build();
        assertThat(body.getPassword()).isEqualTo(password);
    }

    @Test
    @DisplayName("getCompanyId() returns the value that passed to the builder")
    void getCompanyId() {
        String companyId = "id111";
        AuthKeyBody body = AuthKeyBody.builder("","", companyId).build();
        assertThat(body.getCompanyId()).isEqualTo(companyId);
    }
}