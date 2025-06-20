package io.github.patbattb.yougileapilib.domain.body;

import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import io.github.patbattb.yougileapilib.domain.UserRole;
import io.github.patbattb.yougileapilib.http.serialize.DepartmentUpdateBodySerializer;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.experimental.FieldDefaults;

import java.util.Arrays;
import java.util.List;

@Getter
@FieldDefaults(level = AccessLevel.PRIVATE)
@JsonSerialize(using = DepartmentUpdateBodySerializer.class)
public class DepartmentUpdateBody extends RequestBody {

    Boolean deleted;
    String title;
    String parentId;
    List<UserRole> users;

    private DepartmentUpdateBody() {
    }

    public static DepartmentUpdateBody.Builder builder() {
        return new Builder(new DepartmentUpdateBody());
    }

    public static class Builder extends BodyBuilder<DepartmentUpdateBody> {

        private Builder(DepartmentUpdateBody body) {
            super(body);
        }

        public Builder deleted(boolean value) {
            body.deleted = value;
            return this;
        }

        public Builder title(String value) {
            body.title = value;
            return this;
        }

        public Builder parentId(String value) {
            body.parentId = value;
            return this;
        }

        /**
         *
         * @param users {@link UserRole} User ID with system or custom role ID.
         *              Available system role IDs:
         *              <ul>
         *              <li>{@code manager}
         *              <li>{@code member}
         *              <li>{@code -} minus symbol to delete user from department.
         *              </ul>
         */
        public Builder users(UserRole... users) {
            body.users = Arrays.asList(users);
            return this;
        }
    }
}
