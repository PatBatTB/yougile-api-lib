package io.github.patbattb.yougileapilib.domain;

import lombok.*;
import lombok.experimental.FieldDefaults;

@Getter
@FieldDefaults(level = AccessLevel.PRIVATE)
@AllArgsConstructor
@EqualsAndHashCode
@ToString
public class User {
    String id;
    String email;
    @Setter
    boolean isAdmin;
    String realName;
    String status;
    long lastActivity;
}
