package io.github.patbattb.yougileapilib.domain;

import lombok.*;
import lombok.experimental.FieldDefaults;

import java.util.List;

//TODO update doc after class rework
/**
 * Group chat contained list of the {@code GroupUser}
 */
@Getter
@FieldDefaults(level = AccessLevel.PRIVATE)
@AllArgsConstructor
@EqualsAndHashCode
@ToString
public class GroupChat {
    /**
     * If true that the group chat has been deleted.
     */
    @Setter
    boolean deleted;
    /**
     * Group chat ID.
     */
    String id;
    /**
     * Group chat title.
     */
    @Setter
    String title;
    /**
     * List of users in the group chat.
     */
    @Setter
    List<User> users;
}
