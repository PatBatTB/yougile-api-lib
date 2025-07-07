package io.github.patbattb.yougileapilib.domain;

import lombok.*;
import lombok.experimental.FieldDefaults;

import java.util.Arrays;

/**
 * User of {@link Department}.
 * This class is a combination of the {@link User#id} and role of the {@link Department}.
 * The {@link DepartmentUser.RoleId} enumeration is a constraint of the available values for the {@link DepartmentUser#roleId} field.
 */
@Getter
@FieldDefaults(level = AccessLevel.PRIVATE)
@AllArgsConstructor
@EqualsAndHashCode
@ToString
public class DepartmentUser {
    /**
     * ID of the user.
     */
    String userId;
    /**
     * If of the role.
     * The role can't be user-made. There is allowed only specified system roles.
     * This enum represents available values:
     * {@link RoleId#MANAGER} - manager of the department.
     * {@link RoleId#MEMBER} - member of the department.
     * {@link RoleId#DELETE} - specify this role to remove the user from the department.
     */
    @Setter
    RoleId roleId;

    /**
     * This enumeration represents available role ID of the {@link DepartmentUser}.
     */
    @Getter
    public enum RoleId {

        MANAGER("manager"),
        MEMBER("member"),
        DELETE("-");

        private final String value;

        RoleId(String value) {
            this.value = value;
        }

        /**
         * Create enum constant from the {@link String} value.
         * If there is no passed value in available list method throws {@link IllegalArgumentException}
         * @param value value of the constant. Available values : manager, member, -.
         * @return appropriate enum constant.
         * @throws IllegalArgumentException if passed value is not available.
         */
        public static RoleId fromValue(String value) {
            for (RoleId roleId: RoleId.values()) {
                if (roleId.value.equalsIgnoreCase(value)) {
                    return roleId;
                }
            }
            throw new IllegalArgumentException("users.role value must be one of: " + Arrays.stream(values()).map(elem -> elem.value).toList());

        }
    }
}
