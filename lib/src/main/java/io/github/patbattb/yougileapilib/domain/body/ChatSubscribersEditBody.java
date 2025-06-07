package io.github.patbattb.yougileapilib.domain.body;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.experimental.FieldDefaults;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Getter
@FieldDefaults(level = AccessLevel.PRIVATE)
@JsonInclude(JsonInclude.Include.NON_NULL)
public class ChatSubscribersEditBody extends RequestBody {

    @JsonProperty("content")
    List<String> users;

    private ChatSubscribersEditBody(List<String> users) {
        this.users = users;
    }

    public static ChatSubscribersEditBody.Builder builder() {
        return new Builder(new ChatSubscribersEditBody(new ArrayList<>()));
    }

    public static class Builder extends BodyBuilder<ChatSubscribersEditBody> {

        private Builder(ChatSubscribersEditBody body) {
            super(body);
        }

        public Builder users(String... userId) {
            body.users = Arrays.asList(userId);
            return this;
        }
    }
}
