package io.github.patbattb.yougileapilib.domain;

import lombok.*;
import lombok.experimental.FieldDefaults;

import java.util.List;

@Getter
@FieldDefaults(level = AccessLevel.PRIVATE)
@AllArgsConstructor
@EqualsAndHashCode
@ToString
public class GroupChat {
    @Setter
    boolean deleted;
    String id;
    @Setter
    String title;
    @Setter
    List<User> users;
}
