package io.github.patbattb.yougileapilib.domain.body;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.lang.reflect.Constructor;
import java.lang.reflect.Modifier;

import static org.assertj.core.api.Assertions.assertThat;

class CompanyUpdateBodyTest {

    @Test
    @DisplayName("The class has private default constructor")
    void constructor() throws NoSuchMethodException {
        Constructor<CompanyUpdateBody> constructor = CompanyUpdateBody.class.getDeclaredConstructor();
        assertThat(constructor.getModifiers()).isEqualTo(Modifier.PRIVATE);
    }

    @Test
    @DisplayName("builder() returns the Builder with the CompanyEditBody")
    void builder() {
        CompanyUpdateBody.Builder builder = CompanyUpdateBody.builder();
        assertThat(builder.body).isInstanceOf(CompanyUpdateBody.class);
    }

    @Test
    @DisplayName("getDeleted() returns the value that was passed to the builder")
    void getDeleted() {
        boolean deleted = true;
        CompanyUpdateBody body = CompanyUpdateBody.builder().deleted(deleted).build();
        assertThat(body.getDeleted()).isEqualTo(deleted);
    }

    @Test
    @DisplayName("getTitle() returns the value that was passed to the builder")
    void getTitle() {
        String title = "title111";
        CompanyUpdateBody body = CompanyUpdateBody.builder().title(title).build();
        assertThat(body.getTitle()).isEqualTo(title);
    }

    @Test
    @DisplayName("getDeleted() returns null if the value doesn't passed to the builder")
    void getDeletedNull() {
        CompanyUpdateBody body = CompanyUpdateBody.builder().build();
        assertThat(body.getDeleted()).isNull();
    }

    @Test
    @DisplayName("getTitle() returns null if the value doesn't passed to the builder")
    void getTitleNull() {
        CompanyUpdateBody body = CompanyUpdateBody.builder().build();
        assertThat(body.getTitle()).isNull();
    }
}