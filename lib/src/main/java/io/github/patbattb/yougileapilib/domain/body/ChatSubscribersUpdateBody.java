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
public class ChatSubscribersUpdateBody extends RequestBody {

    @JsonProperty("content")
    List<String> users;

    private ChatSubscribersUpdateBody(List<String> users) {
        this.users = users;
    }

    public static ChatSubscribersUpdateBody.Builder builder() {
        return new Builder(new ChatSubscribersUpdateBody(new ArrayList<>()));
    }

    public static class Builder extends BodyBuilder<ChatSubscribersUpdateBody> {

        private Builder(ChatSubscribersUpdateBody body) {
            super(body);
        }

        public Builder users(String... userId) {
            body.users = Arrays.asList(userId);
            return this;
        }
    }
}
