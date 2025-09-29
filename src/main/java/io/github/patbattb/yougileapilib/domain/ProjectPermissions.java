package io.github.patbattb.yougileapilib.domain;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import io.github.patbattb.yougileapilib.http.deserialize.ProjectPermissionsDeserializer;
import lombok.*;
import lombok.experimental.FieldDefaults;

/**
 * Permissions available on the {@link Project}.
 * It's the top leveled permissions, and it's part of {@link ProjectRole}
 * It contains {@link BoardPermissions}.
 */
@Getter
@Setter
@FieldDefaults(level = AccessLevel.PRIVATE)
@AllArgsConstructor
@EqualsAndHashCode
@ToString
@JsonDeserialize(using = ProjectPermissionsDeserializer.class)
@JsonInclude(JsonInclude.Include.NON_NULL)
public class ProjectPermissions {
    /**
     * Can the project title be edited?
     */
    boolean editTitle;
    /**
     * Can the project be deleted?
     */
    boolean delete;
    /**
     * Can any board be added in the project?
     */
    boolean addBoard;
    /**
     * The permissions of the board in the project.
     */
    @NonNull
    @JsonProperty("boards")
    BoardPermissions boardPermissions;
    /**
     * The docs of the API don't have description about it.
     */
    ProjectPermissions children;
}
