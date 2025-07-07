package io.github.patbattb.yougileapilib.domain;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import io.github.patbattb.yougileapilib.http.deserialize.UserDeserializer;
import lombok.*;
import lombok.experimental.FieldDefaults;

/**
 * User entity.
 * Contains general info of the YouGile user.
 */
@Getter
@FieldDefaults(level = AccessLevel.PRIVATE)
@AllArgsConstructor
@EqualsAndHashCode
@ToString
@JsonDeserialize(using = UserDeserializer.class)
public class User {
    /**
     * User ID.
     */
    String id;
    /**
     * User email.
     */
    String email;
    /**
     * Has the user admin rights?
     */
    @Setter
    boolean isAdmin;
    String realName;
    String status;
    long lastActivity;
}
