package io.github.patbattb.yougileapilib.domain.body;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.lang.reflect.Constructor;
import java.lang.reflect.Modifier;

import static org.assertj.core.api.Assertions.assertThat;

class CompanyEditBodyTest {

    @Test
    @DisplayName("The class has private default constructor")
    void constructor() throws NoSuchMethodException {
        Constructor<CompanyEditBody> constructor = CompanyEditBody.class.getDeclaredConstructor();
        assertThat(constructor.getModifiers()).isEqualTo(Modifier.PRIVATE);
    }

    @Test
    @DisplayName("builder() returns the Builder with the CompanyEditBody")
    void builder() {
        CompanyEditBody.Builder builder = CompanyEditBody.builder();
        assertThat(builder.body).isInstanceOf(CompanyEditBody.class);
    }

    @Test
    @DisplayName("getDeleted() returns the value that was passed to the builder")
    void getDeleted() {
        boolean deleted = true;
        CompanyEditBody body = CompanyEditBody.builder().deleted(deleted).build();
        assertThat(body.getDeleted()).isEqualTo(deleted);
    }

    @Test
    @DisplayName("getTitle() returns the value that was passed to the builder")
    void getTitle() {
        String title = "title111";
        CompanyEditBody body = CompanyEditBody.builder().title(title).build();
        assertThat(body.getTitle()).isEqualTo(title);
    }

    @Test
    @DisplayName("getDeleted() returns null if the value doesn't passed to the builder")
    void getDeletedNull() {
        CompanyEditBody body = CompanyEditBody.builder().build();
        assertThat(body.getDeleted()).isNull();
    }

    @Test
    @DisplayName("getTitle() returns null if the value doesn't passed to the builder")
    void getTitleNull() {
        CompanyEditBody body = CompanyEditBody.builder().build();
        assertThat(body.getTitle()).isNull();
    }
}