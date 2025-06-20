package io.github.patbattb.yougileapilib.domain.body;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.lang.reflect.Constructor;
import java.lang.reflect.Modifier;

import static org.assertj.core.api.Assertions.assertThat;

class TimeTrackingUpdateBodyTest {

    @Test
    @DisplayName("The class has private default constructor")
    void constructor() throws NoSuchMethodException {
        Constructor<TimeTrackingUpdateBody> constructor = TimeTrackingUpdateBody.class.getDeclaredConstructor();
        assertThat(constructor.getModifiers()).isEqualTo(Modifier.PRIVATE);
    }

    @Test
    @DisplayName("builder() returns the Builder with whe TimeTrackingEditBody")
    void builder() {
        TimeTrackingUpdateBody.Builder builder = TimeTrackingUpdateBody.builder();
        assertThat(builder.body).isInstanceOf(TimeTrackingUpdateBody.class);
    }

    @Test
    @DisplayName("getPlan() returns the value that was passed to the builder")
    void getPlan() {
        double plan = 10;
        TimeTrackingUpdateBody body = TimeTrackingUpdateBody.builder().plan(plan).build();
        assertThat(body.getPlan()).isEqualTo(plan);
    }

    @Test
    @DisplayName("getWork() returns the value that was passed to the builder")
    void getWork() {
        double work = 10;
        TimeTrackingUpdateBody body = TimeTrackingUpdateBody.builder().work(work).build();
        assertThat(body.getWork()).isEqualTo(work);
    }

    @Test
    @DisplayName("getDeleted() returns the value that was passed to the builder")
    void getDeleted() {
        boolean deleted = true;
        TimeTrackingUpdateBody body = TimeTrackingUpdateBody.builder().deleted(deleted).build();
        assertThat(body.getDeleted()).isEqualTo(deleted);
    }

    @Test
    @DisplayName("getPlan() returns null if the value wasn't passed to the builder")
    void getPlanNull() {
        TimeTrackingUpdateBody body = TimeTrackingUpdateBody.builder().build();
        assertThat(body.getPlan()).isNull();
    }

    @Test
    @DisplayName("getWork() returns null if the value wasn't passed to the builder")
    void getWorkNull() {
        TimeTrackingUpdateBody body = TimeTrackingUpdateBody.builder().build();
        assertThat(body.getWork()).isNull();
    }

    @Test
    @DisplayName("getDeleted() returns null if the value wasn't passed to the builder")
    void getDeletedNull() {
        TimeTrackingUpdateBody body = TimeTrackingUpdateBody.builder().build();
        assertThat(body.getDeleted()).isNull();
    }
}