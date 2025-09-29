package io.github.patbattb.yougileapilib.domain.body;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.experimental.FieldDefaults;

/**
 * Implementation of the {@link RequestBody} for POST request creates {@link io.github.patbattb.yougileapilib.domain.ChatMessage}
 */
@Getter
@FieldDefaults(level = AccessLevel.PRIVATE)
@JsonInclude(JsonInclude.Include.NON_NULL)
public class ChatMessageCreateBody implements RequestBody {
    final String text;
    String textHtml;
    String label;

    private ChatMessageCreateBody(String text) {
        this.text = text;
    }

    /**
     * Instantiates the builder for constructing {@link ChatMessageCreateBody}.
     * Required fields of the {@link ChatMessageCreateBody} needs to be passed as the arguments.
     * The remaining fields can be specified using the builder's methods.
     * @param text message text.
     * @return the builder.
     */
    public static Builder builder(String text) {
        return new Builder(new ChatMessageCreateBody(text));
    }

    public static class Builder extends BodyBuilder<ChatMessageCreateBody> {

        private Builder(ChatMessageCreateBody body) {
            super(body);
        }

        /**
         * If you pass textHtml, it will be displayed on the chat. Other way {@link ChatMessageCreateBody#text} will be displayed.
         * @param value text in HTML format.
         * @return the builder itself for continue constructing.
         */
        public Builder textHtml(String value) {
            body.textHtml = value;
            return this;
        }

        /**
         *
         * @param value message label
         * @return the builder itself for continue constructing.
         */
        public Builder label(String value) {
            body.label = value;
            return this;
        }
    }
}
