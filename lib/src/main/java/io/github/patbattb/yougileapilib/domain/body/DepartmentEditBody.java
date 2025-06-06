package io.github.patbattb.yougileapilib.domain.body;

import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import io.github.patbattb.yougileapilib.domain.UserRole;
import io.github.patbattb.yougileapilib.http.serialize.DepartmentEditBodySerializer;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.experimental.FieldDefaults;

import java.util.ArrayList;
import java.util.List;

@Getter
@FieldDefaults(level = AccessLevel.PRIVATE)
@JsonSerialize(using = DepartmentEditBodySerializer.class)
public class DepartmentEditBody extends RequestBody {

    Boolean deleted;
    String title;
    String parentId;
    final List<UserRole> users;

    private DepartmentEditBody(List<UserRole> users) {
        this.users = users;
    }

    public static DepartmentEditBody.Builder builder() {
        return new Builder(new DepartmentEditBody(new ArrayList<>()));
    }

    public static class Builder extends BodyBuilder<DepartmentEditBody> {

        private Builder(DepartmentEditBody body) {
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
         * @param user {@link UserRole} User ID with system or custom role ID.
         *              Available system role IDs:
         *              <ul>
         *              <li>{@code manager}
         *              <li>{@code member}
         *              <li>{@code -} minus symbol to delete user from department.
         *              </ul>
         */
        public Builder users(UserRole user) {
            body.users.add(user);
            return this;
        }
    }
}
