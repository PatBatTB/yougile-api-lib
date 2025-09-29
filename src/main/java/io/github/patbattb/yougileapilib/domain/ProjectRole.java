package io.github.patbattb.yougileapilib.domain;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import io.github.patbattb.yougileapilib.http.deserialize.ProjectRoleDeserializer;
import lombok.*;
import lombok.experimental.FieldDefaults;

/**
 * The user's authority role of a {@link Project}.
 * Represents role with {@link ProjectPermissions}
 */
@Getter
@FieldDefaults(level = AccessLevel.PRIVATE)
@AllArgsConstructor
@EqualsAndHashCode
@ToString
@JsonDeserialize(using = ProjectRoleDeserializer.class)
public class ProjectRole {
    /**
     * Project role ID.
     * This ID can be used as {@link ProjectUser#roleId} to assign this role to the user.
     */
    String id;
    /**
     * Project role name.
     */
    @Setter
    String name;
    /**
     * Project role description.
     */
    @Setter
    String description;
    /**
     * Permissions in the project.
     */
    @Setter
    ProjectPermissions projectPermissions;
}
