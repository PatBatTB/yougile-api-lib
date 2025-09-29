package io.github.patbattb.yougileapilib.domain;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import io.github.patbattb.yougileapilib.http.deserialize.GroupChatDeserializer;
import lombok.*;
import lombok.experimental.FieldDefaults;

import java.util.List;

/**
 * Group chat contained list of the {@code GroupUser}
 * <p>
 * <b>ATTENTION! GroupChat doesn't work correctly! </b>
 * <p>
 * <b>If you delete all users from the chat, it will get bogged down.
 * You can get it through the API, but if you try to change it, add users, or something else, there will be no result.
 * The server returns the 200 status (OK), but no changes occur.</b>
 * <p>
 * <b>There may be other errors that I have not been able to identify as a result of the tests.
 * </b>
 */
@Getter
@FieldDefaults(level = AccessLevel.PRIVATE)
@AllArgsConstructor
@EqualsAndHashCode
@ToString
@JsonDeserialize(using = GroupChatDeserializer.class)
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
    List<GroupChatUser> users;
}
