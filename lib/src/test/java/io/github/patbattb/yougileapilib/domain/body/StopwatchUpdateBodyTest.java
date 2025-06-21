package io.github.patbattb.yougileapilib.domain.body;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.lang.reflect.Constructor;
import java.lang.reflect.Modifier;

import static org.assertj.core.api.Assertions.assertThat;

class StopwatchUpdateBodyTest {

    @Test
    @DisplayName("The class has private default constructor")
    void constructor() throws NoSuchMethodException {
        Constructor<StopwatchUpdateBody> constructor = StopwatchUpdateBody.class.getDeclaredConstructor();
        assertThat(constructor.getModifiers()).isEqualTo(Modifier.PRIVATE);
    }

    @Test
    @DisplayName("builder() returns the Builder with the StopwatchEditBody")
    void builder() {
        StopwatchUpdateBody.Builder builder = StopwatchUpdateBody.builder();
        assertThat(builder.body).isInstanceOf(StopwatchUpdateBody.class);
    }

    @Test
    @DisplayName("getRunning() returns the value that was passed to the builder")
    void getRunning() {
        boolean running = true;
        StopwatchUpdateBody body = StopwatchUpdateBody.builder().running(running).build();
        assertThat(body.getRunning()).isEqualTo(running);
    }

    @Test
    @DisplayName("getDeleted() returns the vale that was passed to the builder")
    void getDeleted() {
        boolean deleted = true;
        StopwatchUpdateBody body = StopwatchUpdateBody.builder().deleted(deleted).build();
        assertThat(body.getDeleted()).isEqualTo(deleted);
    }

    @Test
    @DisplayName("getRunning() returns null if he value wasn't passed to the builder")
    void getRunningNull() {
        StopwatchUpdateBody body = StopwatchUpdateBody.builder().build();
        assertThat(body.getRunning()).isNull();
    }

    @Test
    @DisplayName("getDeleted() returns null if he value wasn't passed to the builder")
    void getDeletedNull() {
        StopwatchUpdateBody body = StopwatchUpdateBody.builder().build();
        assertThat(body.getDeleted()).isNull();
    }
}