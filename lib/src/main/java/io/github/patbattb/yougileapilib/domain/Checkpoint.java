package io.github.patbattb.yougileapilib.domain;

import com.fasterxml.jackson.annotation.JsonGetter;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import io.github.patbattb.yougileapilib.http.deserialize.CheckpointDeserializer;
import lombok.*;
import lombok.experimental.FieldDefaults;

@Getter
@FieldDefaults(level = AccessLevel.PRIVATE)
@AllArgsConstructor
@EqualsAndHashCode
@ToString
@JsonDeserialize(using = CheckpointDeserializer.class)
public class Checkpoint {
    String title;
    boolean isCompleted;

    @JsonGetter("isCompleted")
    public boolean isCompleted() {
        return isCompleted;
    }
}
