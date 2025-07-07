package io.github.patbattb.yougileapilib.domain;

import com.fasterxml.jackson.annotation.JsonGetter;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import io.github.patbattb.yougileapilib.http.deserialize.ChecklistOptionDeserializer;
import lombok.*;
import lombok.experimental.FieldDefaults;

/**
 * This item represents one point of an {@link Checklist}, that may be completed or not.
 */
@Getter
@FieldDefaults(level = AccessLevel.PRIVATE)
@AllArgsConstructor
@EqualsAndHashCode
@ToString
@JsonDeserialize(using = ChecklistOptionDeserializer.class)
public class ChecklistOption {
    /**
     * Name of the checklist option.
     */
    String title;
    /**
     * Is the option completed?
     */
    boolean isCompleted;

    /**
     * Is the option completed?
     */
    @JsonGetter("isCompleted")
    public boolean isCompleted() {
        return isCompleted;
    }
}
