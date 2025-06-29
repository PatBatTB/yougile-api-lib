package io.github.patbattb.yougileapilib.domain;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import io.github.patbattb.yougileapilib.http.deserialize.ChecklistDeserializer;
import lombok.*;
import lombok.experimental.FieldDefaults;

import java.util.List;

/**
 * The checklist contained in the {@link Task}.
 * It includes {@link ChecklistOption}
 */
@Getter
@FieldDefaults(level = AccessLevel.PRIVATE)
@AllArgsConstructor
@EqualsAndHashCode
@ToString
@JsonDeserialize(using = ChecklistDeserializer.class)
public class Checklist {
    /**
     * Name of the checklist.
     */
    String title;
    /**
     * List of the checklist options.
     */
    List<ChecklistOption> items;
}
