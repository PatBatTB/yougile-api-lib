package io.github.patbattb.yougileapilib.domain.body;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.experimental.FieldDefaults;

import java.util.List;

/**
 * Implementation of the {@link RequestBody} for PUT request updates {@link io.github.patbattb.yougileapilib.domain.ChatMessage}
 */
@Getter
@FieldDefaults(level = AccessLevel.PRIVATE)
@JsonInclude(JsonInclude.Include.NON_NULL)
public class ChatMessageUpdateBody implements RequestBody {
    Boolean deleted;
    String label;
    //The field is always null because updating smiley through API doesn't work correctly on yougile.
    final List<String> react = null;

    private ChatMessageUpdateBody() {}

    /**
     * Instantiates the builder for constructing {@link ChatMessageUpdateBody}.
     * This builder has no parameters. All fields of the {@link ChatMessageUpdateBody} can be specified using the builder's methods.
     * @return the builder
     */
    public static Builder builder() {
        return new Builder(new ChatMessageUpdateBody());
    }

    public static class Builder extends BodyBuilder<ChatMessageUpdateBody> {

        private Builder(ChatMessageUpdateBody body) {
            super(body);
        }

        /**
         *
         * @param value if true, then object will be deleted.
         * @return the builder itself for continue constructing.
         */
        public Builder deleted(Boolean value) {
            body.deleted = value;
            return this;
        }

        /**
         *
         * @param value message label.
         * @return the builder itself for continue constructing.
         */
        public Builder label(String value) {
            body.label = value;
            return this;
        }

        // It doesn't work on yougile. You can get all available smiley as String, but you can put limited set of the smiley only.
        // It means if you get message with the smiley outside limited set, you can't update this message because smiley
        // outside limited set don't allowed for put
//        /**
//         *
//         * @param values Message reactions.
//         * @return the builder itself for continue constructing.
//         */
//        public Builder react(String... values) {
//            body.react = Arrays.asList(values);
//            return this;
//        }
    }
}
