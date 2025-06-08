package io.github.patbattb.yougileapilib.domain.body;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.lang.reflect.Constructor;
import java.lang.reflect.Modifier;

import static org.assertj.core.api.Assertions.assertThat;

class TimeTrackingEditBodyTest {

    @Test
    @DisplayName("The class has private default constructor")
    void constructor() throws NoSuchMethodException {
        Constructor<TimeTrackingEditBody> constructor = TimeTrackingEditBody.class.getDeclaredConstructor();
        assertThat(constructor.getModifiers()).isEqualTo(Modifier.PRIVATE);
    }

    @Test
    @DisplayName("builder() returns the Builder with whe TimeTrackingEditBody")
    void builder() {
        TimeTrackingEditBody.Builder builder = TimeTrackingEditBody.builder();
        assertThat(builder.body).isInstanceOf(TimeTrackingEditBody.class);
    }

    @Test
    @DisplayName("getPlan() returns the value that was passed to the builder")
    void getPlan() {
        double plan = 10;
        TimeTrackingEditBody body = TimeTrackingEditBody.builder().plan(plan).build();
        assertThat(body.getPlan()).isEqualTo(plan);
    }

    @Test
    @DisplayName("getWork() returns the value that was passed to the builder")
    void getWork() {
        double work = 10;
        TimeTrackingEditBody body = TimeTrackingEditBody.builder().work(work).build();
        assertThat(body.getWork()).isEqualTo(work);
    }

    @Test
    @DisplayName("getDeleted() returns the value that was passed to the builder")
    void getDeleted() {
        boolean deleted = true;
        TimeTrackingEditBody body = TimeTrackingEditBody.builder().deleted(deleted).build();
        assertThat(body.getDeleted()).isEqualTo(deleted);
    }

    @Test
    @DisplayName("getPlan() returns null if the value wasn't passed to the builder")
    void getPlanNull() {
        TimeTrackingEditBody body = TimeTrackingEditBody.builder().build();
        assertThat(body.getPlan()).isNull();
    }

    @Test
    @DisplayName("getWork() returns null if the value wasn't passed to the builder")
    void getWorkNull() {
        TimeTrackingEditBody body = TimeTrackingEditBody.builder().build();
        assertThat(body.getWork()).isNull();
    }

    @Test
    @DisplayName("getDeleted() returns null if the value wasn't passed to the builder")
    void getDeletedNull() {
        TimeTrackingEditBody body = TimeTrackingEditBody.builder().build();
        assertThat(body.getDeleted()).isNull();
    }
}