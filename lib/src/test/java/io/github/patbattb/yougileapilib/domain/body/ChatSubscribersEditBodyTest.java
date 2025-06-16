package io.github.patbattb.yougileapilib.domain.body;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.lang.reflect.Constructor;
import java.lang.reflect.Modifier;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatCollection;

class ChatSubscribersEditBodyTest {

    @Test
    @DisplayName("The class has private default constructor")
    void constructor() throws NoSuchMethodException {
        Constructor<ChatSubscribersEditBody> constructor = ChatSubscribersEditBody.class.getDeclaredConstructor();
        assertThat(constructor.getModifiers()).isEqualTo(Modifier.PRIVATE);
    }

    @Test
    @DisplayName("builder() returns the Builder with the ChatSubscribersEditBody")
    void builder() {
        ChatSubscribersEditBody.Builder builder = ChatSubscribersEditBody.builder();
        assertThat(builder.body).isInstanceOf(ChatSubscribersEditBody.class);
    }

    @Test
    @DisplayName("getUsers() returns the value that was passed to the builder")
    void getUsers() {
        String[] users = { "userID1", "userID2" };
        ChatSubscribersEditBody body = ChatSubscribersEditBody.builder().users(users).build();
        assertThatCollection(body.getUsers()).containsExactlyInAnyOrder(users);
    }

    @Test
    @DisplayName("getUsers() returns null if the builder's method wasn't call")
    void getUsersNull() {
        ChatSubscribersEditBody body = ChatSubscribersEditBody.builder().build();
        assertThat(body.getUsers()).isNull();
    }

    @Test
    @DisplayName("getUsers() returns empty list if the builder's methos was call without arguments")
    void getUserEmpty() {
        ChatSubscribersEditBody body = ChatSubscribersEditBody.builder().users().build();
        assertThat(body.getUsers()).isEmpty();
    }
}