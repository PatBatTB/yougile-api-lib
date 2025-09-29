package io.github.patbattb.yougileapilib.domain;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import io.github.patbattb.yougileapilib.http.deserialize.ChatMessgeDeserializer;
import lombok.*;
import lombok.experimental.FieldDefaults;

import java.util.List;

/**
 * The message of the chat.
 * The message {@link ChatMessage#id} is also its creation time.
 */
@Getter
@FieldDefaults(level = AccessLevel.PRIVATE)
@AllArgsConstructor
@EqualsAndHashCode
@ToString
@JsonDeserialize(using = ChatMessgeDeserializer.class)
public class ChatMessage {
    /**
     * If true, then the message has been deleted.
     */
    @Setter
    boolean deleted;
    /**
     * Message ID.
     * It is also the timestamp of creation.
     */
    String id;
    /**
     * Message author ID.
     */
    String fromUserId;
    /**
     * Message text.
     */
    String text;
    /**
     * Message text in HTML.
     */
    String textHtml;
    /**
     * Quick link.
     */
    @Setter
    String label;
    /**
     * Last edit time.
     */
    Long editTimestamp;
    /**
     * Message reactions.
     */
    List<Reaction> reactions;
}
