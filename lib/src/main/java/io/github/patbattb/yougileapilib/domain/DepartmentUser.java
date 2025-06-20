package io.github.patbattb.yougileapilib.domain;

import lombok.*;
import lombok.experimental.FieldDefaults;

import java.util.Arrays;

@Getter
@FieldDefaults(level = AccessLevel.PRIVATE)
@AllArgsConstructor
@EqualsAndHashCode
@ToString
public class DepartmentUser {
    String userId;
    @Setter
    RoleId roleId;

    @Getter
    public enum RoleId {

        MANAGER("manager"),
        MEMBER("member"),
        DELETE("-");

        private final String value;

        RoleId(String value) {
            this.value = value;
        }

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
