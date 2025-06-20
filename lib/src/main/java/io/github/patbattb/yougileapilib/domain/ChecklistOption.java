package io.github.patbattb.yougileapilib.domain;

import com.fasterxml.jackson.annotation.JsonGetter;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import io.github.patbattb.yougileapilib.http.deserialize.ChecklistOptionDeserializer;
import lombok.*;
import lombok.experimental.FieldDefaults;

@Getter
@FieldDefaults(level = AccessLevel.PRIVATE)
@AllArgsConstructor
@EqualsAndHashCode
@ToString
@JsonDeserialize(using = ChecklistOptionDeserializer.class)
public class ChecklistOption {
    String title;
    boolean isCompleted;

    @JsonGetter("isCompleted")
    public boolean isCompleted() {
        return isCompleted;
    }
}
