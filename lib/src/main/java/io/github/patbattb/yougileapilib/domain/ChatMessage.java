package io.github.patbattb.yougileapilib.domain;

import lombok.*;
import lombok.experimental.FieldDefaults;

/**
 * The message of the chat.
 * The message {@link ChatMessage#id} is also its creation time.
 */
@Getter
@FieldDefaults(level = AccessLevel.PRIVATE)
@AllArgsConstructor
@EqualsAndHashCode
@ToString
public class ChatMessage {
    /**
     * If true, then the message has been deleted.
     */
    @Setter
    boolean deleted;
    /**
     * Message ID.
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
    long editTimestamp;
    /*
     * Message reactions.
     */
    //@Setter
    //Object reactions 👍👎👏🙂😀😕🎉❤🚀✔
}
