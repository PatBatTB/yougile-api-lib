package io.github.patbattb.yougileapilib.domain;

import lombok.*;
import lombok.experimental.FieldDefaults;

/**
 * User of {@link Project}.
 * This class is a combination of the {@link User#id} and {@link ProjectRole#id}.
 */
@Getter
@FieldDefaults(level = AccessLevel.PRIVATE)
@AllArgsConstructor
@EqualsAndHashCode
@ToString
public class ProjectUser {
    /**
     * User ID.
     */
    String userId;
    /**
     * ID of the user role in the project.
     * This field allows both system roles and custom user roles.
     * Value can be specified one of system roles:
     * <ul>
     * <li>{@code worker}
     * <li>{@code admin}
     * <li>{@code observer}
     * <li>{@code -} - used for deleting user from the project.
     * </ul>
     * or can be ID of the custom user-made role.
     */
    @Setter
    String roleId;

}
