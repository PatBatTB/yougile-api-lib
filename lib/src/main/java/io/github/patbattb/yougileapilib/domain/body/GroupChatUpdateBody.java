package io.github.patbattb.yougileapilib.domain.body;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import io.github.patbattb.yougileapilib.domain.GroupChatUser;
import io.github.patbattb.yougileapilib.http.serialize.GroupChatUpdateBodySerializer;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.experimental.FieldDefaults;

import java.util.Arrays;
import java.util.List;

/**
 * Implementation of the {@link RequestBody} for PUT request updates {@link io.github.patbattb.yougileapilib.domain.GroupChat}
 */
@Getter
@JsonInclude(JsonInclude.Include.NON_NULL)
@FieldDefaults(level = AccessLevel.PRIVATE)
@JsonSerialize(using = GroupChatUpdateBodySerializer.class)
public class GroupChatUpdateBody implements RequestBody {
    Boolean deleted;
    String title;
    List<GroupChatUser> users;

    private GroupChatUpdateBody() {}

    /**
     * Instantiates the builder for constructing {@link GroupChatUpdateBody}.
     * This builder has no parameters. All fields of the {@link GroupChatUpdateBody} can be specified using the builder's methods.
     * @return the builder.
     */
    public static Builder builder() {
        return new Builder(new GroupChatUpdateBody());
    }

    public static class Builder extends BodyBuilder<GroupChatUpdateBody> {

        private Builder(GroupChatUpdateBody body) {
            super(body);
        }

        /**
         *
         * @param value true, if object must be deleted.
         * @return the builder itself for continue constructing.
         */
        public Builder deleted(Boolean value) {
            body.deleted = value;
            return this;
        }

        /**
         *
         * @param value new title of the group chat.
         * @return the builder itself for continue constructing.
         */
        public Builder title(String value) {
            body.title = value;
            return this;
        }

        /**
         *
         * @param users array of the group chat users.
         * @return the builder itself for continue constructing.
         */
        public Builder users(GroupChatUser... users) {
            body.users = Arrays.asList(users);
            return this;
        }
    }
}
