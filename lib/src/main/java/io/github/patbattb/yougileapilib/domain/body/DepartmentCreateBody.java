package io.github.patbattb.yougileapilib.domain.body;

import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import io.github.patbattb.yougileapilib.domain.UserRole;
import io.github.patbattb.yougileapilib.http.serialize.DepartmentCreateBodySerializer;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.experimental.FieldDefaults;

import java.util.ArrayList;
import java.util.List;

@Getter
@JsonSerialize(using = DepartmentCreateBodySerializer.class)
@FieldDefaults(level = AccessLevel.PRIVATE)
public class DepartmentCreateBody extends RequestBody {

    final String title;
    String parentId;
    final List<UserRole> users;

    private DepartmentCreateBody(String title, List<UserRole> users) {
        this.title = title;
        this.users = users;
    }

    public static DepartmentCreateBody.Builder builder(String title) {
        return new Builder(new DepartmentCreateBody(title, new ArrayList<>()));
    }

    public static class Builder extends BodyBuilder<DepartmentCreateBody> {

        private Builder(DepartmentCreateBody body) {
            super(body);
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

        public Builder parentId(String value) {
            body.parentId = value;
            return this;
        }
    }
}
