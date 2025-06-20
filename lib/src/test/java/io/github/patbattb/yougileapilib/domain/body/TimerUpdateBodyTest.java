package io.github.patbattb.yougileapilib.domain.body;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.lang.reflect.Constructor;
import java.lang.reflect.Modifier;

import static org.assertj.core.api.Assertions.assertThat;

class TimerUpdateBodyTest {

    @Test
    @DisplayName("The class has private default constructor")
    void constructor() throws NoSuchMethodException {
        Constructor<TimerUpdateBody> constructor = TimerUpdateBody.class.getDeclaredConstructor();
        assertThat(constructor.getModifiers()).isEqualTo(Modifier.PRIVATE);
    }

    @Test
    @DisplayName("builder() returns the Builder with the TimerEditBody")
    void builder() {
        TimerUpdateBody.Builder builder = TimerUpdateBody.builder();
        assertThat(builder.body).isInstanceOf(TimerUpdateBody.class);
    }

    @Test
    @DisplayName("getSeconds() returns the value that was passed to the builder")
    void getSeconds() {
        int seconds = 1;
        TimerUpdateBody body = TimerUpdateBody.builder().seconds(seconds).build();
        assertThat(body.getSeconds()).isEqualTo(seconds);
    }

    @Test
    @DisplayName("getRunning() returns the value that was passed to the builder")
    void getRunning() {
        boolean running = true;
        TimerUpdateBody body = TimerUpdateBody.builder().running(running).build();
        assertThat(body.getRunning()).isEqualTo(running);
    }

    @Test
    @DisplayName("getDeleted() returns the value that was passed to the builder")
    void getDeleted() {
        boolean deleted = true;
        TimerUpdateBody body = TimerUpdateBody.builder().deleted(deleted).build();
        assertThat(body.getDeleted()).isEqualTo(deleted);
    }

    @Test
    @DisplayName("getSeconds() returns the value that was passed to the builder")
    void getSecondsNull() {
        TimerUpdateBody body = TimerUpdateBody.builder().build();
        assertThat(body.getSeconds()).isNull();
    }

    @Test
    @DisplayName("getRunning() returns the value that was passed to the builder")
    void getRunningNull() {
        TimerUpdateBody body = TimerUpdateBody.builder().build();
        assertThat(body.getRunning()).isNull();
    }

    @Test
    @DisplayName("getDeleted() returns the value that was passed to the builder")
    void getDeletedNull() {
        TimerUpdateBody body = TimerUpdateBody.builder().build();
        assertThat(body.getDeleted()).isNull();
    }
}