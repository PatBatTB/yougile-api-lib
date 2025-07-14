package io.github.patbattb.yougileapilib.domain.body;

import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import io.github.patbattb.yougileapilib.domain.DepartmentUser;
import io.github.patbattb.yougileapilib.http.serialize.DepartmentUpdateBodySerializer;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.experimental.FieldDefaults;

import java.util.Arrays;
import java.util.List;

/**
 * Implementation of the {@link RequestBody} for PUT request updates {@link io.github.patbattb.yougileapilib.domain.Department}
 */
@Getter
@FieldDefaults(level = AccessLevel.PRIVATE)
@JsonSerialize(using = DepartmentUpdateBodySerializer.class)
public class DepartmentUpdateBody implements RequestBody {

    Boolean deleted;
    String title;
    String parentId;
    List<DepartmentUser> users;

    private DepartmentUpdateBody() {
    }

    /**
     * Instantiates the builder for constructing {@link DepartmentUpdateBody}.
     * This builder has no parameters. All fields of the {@link DepartmentUpdateBody} can be specified using the builder's methods.
     * @return the builder
     */
    public static DepartmentUpdateBody.Builder builder() {
        return new Builder(new DepartmentUpdateBody());
    }

    public static class Builder extends BodyBuilder<DepartmentUpdateBody> {

        private Builder(DepartmentUpdateBody body) {
            super(body);
        }

        /**
         *
         * @param value if true, then the object will be deleted.
         * @return the builder itself for continue constructing.
         */
        public Builder deleted(boolean value) {
            body.deleted = value;
            return this;
        }

        /**
         *
         * @param value department name
         * @return the builder itself for continue constructing.
         */
        public Builder title(String value) {
            body.title = value;
            return this;
        }

        /**
         * ID of the parent department.
         * Must be {@code null} or equals "-", if that top-leveled department.
         * @param value ID of the parent department.
         * @return the builder itself for continue constructing.
         */
        public Builder parentId(String value) {
            body.parentId = value;
            return this;
        }

        /**
         *
         * @param users {@link DepartmentUser} User ID with system or custom role ID.
         *              Available system role IDs:
         *              <ul>
         *              <li>{@code manager}
         *              <li>{@code member}
         *              <li>{@code -} minus symbol to delete user from department.
         *              </ul>
         */
        public Builder users(DepartmentUser... users) {
            body.users = Arrays.asList(users);
            return this;
        }
    }
}
