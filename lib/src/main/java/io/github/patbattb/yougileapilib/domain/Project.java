package io.github.patbattb.yougileapilib.domain;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import io.github.patbattb.yougileapilib.http.deserialize.ProjectDeserializer;
import lombok.*;
import lombok.experimental.FieldDefaults;

import java.util.List;

/**
 * The project where a {@link Board}s are placed.
 * Can contain list of {@link ProjectUser} with id of the project's roles.
 */
@Getter
@FieldDefaults(level = AccessLevel.PRIVATE)
@AllArgsConstructor
@EqualsAndHashCode
@ToString
@JsonDeserialize(using = ProjectDeserializer.class)
public class Project {
    /**
     * If true then the project has been deleted.
     */
    @Setter
    boolean deleted;
    /**
     * Project ID.
     */
    String id;
    /**
     * Project title.
     */
    @Setter
    String title;
    /**
     * Timestamp of the project's creation.
     */
    long created;
    /**
     * List of the users in the project.
     * Users in the project and their roles.
     */
    @Setter
    List<ProjectUser> users;
}
