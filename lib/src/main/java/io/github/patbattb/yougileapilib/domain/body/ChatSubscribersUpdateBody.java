package io.github.patbattb.yougileapilib.domain.body;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.experimental.FieldDefaults;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Implementation of the {@link RequestBody} for PUT request updates ChatSubscribers of the {@link io.github.patbattb.yougileapilib.domain.Task}
 */
@Getter
@FieldDefaults(level = AccessLevel.PRIVATE)
@JsonInclude(JsonInclude.Include.NON_NULL)
public class ChatSubscribersUpdateBody extends RequestBody {

    @JsonProperty("content")
    List<String> users;

    private ChatSubscribersUpdateBody(List<String> users) {
        this.users = users;
    }

    /**
     * Instantiates the builder for constructing {@link ChatSubscribersUpdateBody}.
     * This builder has no parameters. All fields of the {@link ChatSubscribersUpdateBody} can be specified using the builder's methods.
     * The remaining fields can be specified using the builder's methods.
     * @return the builder
     */
    public static ChatSubscribersUpdateBody.Builder builder() {
        return new Builder(new ChatSubscribersUpdateBody(new ArrayList<>()));
    }

    public static class Builder extends BodyBuilder<ChatSubscribersUpdateBody> {

        private Builder(ChatSubscribersUpdateBody body) {
            super(body);
        }

        /**
         *
         * @param userId array of user IDs, who need to subscribed to the task's chat.
         * @return the builder itself for continue constructing.
         */
        public Builder users(String... userId) {
            body.users = Arrays.asList(userId);
            return this;
        }
    }
}
