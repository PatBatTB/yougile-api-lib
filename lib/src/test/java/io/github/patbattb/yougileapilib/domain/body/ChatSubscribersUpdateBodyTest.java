package io.github.patbattb.yougileapilib.domain.body;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.lang.reflect.Constructor;
import java.lang.reflect.Modifier;
import java.util.Collections;
import java.util.List;

import static org.assertj.core.api.Assertions.*;

class ChatSubscribersUpdateBodyTest {

    @Test
    @DisplayName("The class doesn't have default constructor")
    void constructor() {
        assertThatThrownBy(ChatSubscribersUpdateBody.class::getDeclaredConstructor).isInstanceOf(NoSuchMethodException.class);
    }

    @Test
    @DisplayName("The class has private constructor with (List) parameter")
    void constructorWithList() throws NoSuchMethodException {
        Constructor<ChatSubscribersUpdateBody> constructor = ChatSubscribersUpdateBody.class.getDeclaredConstructor(List.class);
        assertThat(constructor.getModifiers()).isEqualTo(Modifier.PRIVATE);
    }

    @Test
    @DisplayName("builder() returns the Builder with the ChatSubscribersEditBody")
    void builder() {
        ChatSubscribersUpdateBody.Builder builder = ChatSubscribersUpdateBody.builder();
        assertThat(builder.body).isInstanceOf(ChatSubscribersUpdateBody.class);
    }

    @Test
    @DisplayName("getUsers() returns the value that was passed to the builder")
    void getUsers() {
        String[] users = { "userID1", "userID2" };
        ChatSubscribersUpdateBody body = ChatSubscribersUpdateBody.builder().users(users).build();
        assertThatCollection(body.getUsers()).containsExactlyInAnyOrder(users);
    }

    @Test
    @DisplayName("getUsers() returns null if the builder's method wasn't call")
    void getUsersNull() {
        ChatSubscribersUpdateBody body = ChatSubscribersUpdateBody.builder().build();
        assertThat(body.getUsers()).isEqualTo(Collections.EMPTY_LIST);
    }

    @Test
    @DisplayName("getUsers() returns empty list if the builder's methos was call without arguments")
    void getUserEmpty() {
        ChatSubscribersUpdateBody body = ChatSubscribersUpdateBody.builder().users().build();
        assertThat(body.getUsers()).isEmpty();
    }
}