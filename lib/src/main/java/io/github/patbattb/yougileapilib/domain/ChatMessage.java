package io.github.patbattb.yougileapilib.domain;

import lombok.*;
import lombok.experimental.FieldDefaults;

@Getter
@FieldDefaults(level = AccessLevel.PRIVATE)
@AllArgsConstructor
@EqualsAndHashCode
@ToString
public class ChatMessage {
    @Setter
    boolean deleted;
    String id;
    String fromUserId;
    String text;
    String textHtml;
    @Setter
    String label;
    long editTimestamp;
    //@Setter
    //Object reactions 👍👎👏🙂😀😕🎉❤🚀✔
}
