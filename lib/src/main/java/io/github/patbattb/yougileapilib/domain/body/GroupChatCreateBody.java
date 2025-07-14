package io.github.patbattb.yougileapilib.domain.body;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import io.github.patbattb.yougileapilib.domain.GroupChatUser;
import io.github.patbattb.yougileapilib.http.serialize.GroupChatCreateBodySerializer;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.experimental.FieldDefaults;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Implementation of the {@link RequestBody} for POST request creates {@link io.github.patbattb.yougileapilib.domain.GroupChat}
 */
@Getter
@FieldDefaults(level = AccessLevel.PRIVATE)
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonSerialize(using = GroupChatCreateBodySerializer.class)
public class GroupChatCreateBody implements RequestBody {

    final String title;
    List<GroupChatUser> users = new ArrayList<>();

    private GroupChatCreateBody(String title) {
        this.title = title;
    }

    /**
     * Instantiates the builder for constructing {@link GroupChatCreateBody}.
     * Required fields of the {@link GroupChatCreateBody} needs to be passed as the arguments.
     * The remaining fields can be specified using the builder's methods.
     * @param title department name
     * @return the builder.
     */
    public static Builder builder(String title) {
        return new Builder(new GroupChatCreateBody(title));
    }

    public static class Builder extends BodyBuilder<GroupChatCreateBody> {

        private Builder(GroupChatCreateBody body) {
            super(body);
        }

        /**
         *
         * @param users users of the group chat.
         * @return the builder itself for continue constructing.
         */
        public Builder users(GroupChatUser... users) {
            body.users = Arrays.asList(users);
            return this;
        }
    }

}