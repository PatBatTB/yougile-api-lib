package io.github.patbattb.yougileapilib.domain.body;

import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import io.github.patbattb.yougileapilib.domain.DepartmentUser;
import io.github.patbattb.yougileapilib.http.serialize.DepartmentCreateBodySerializer;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NonNull;
import lombok.experimental.FieldDefaults;

import java.util.Arrays;
import java.util.List;

@Getter
@JsonSerialize(using = DepartmentCreateBodySerializer.class)
@FieldDefaults(level = AccessLevel.PRIVATE)
public class DepartmentCreateBody extends RequestBody {

    final String title;
    String parentId;
    List<DepartmentUser> users;

    private DepartmentCreateBody(String title) {
        this.title = title;
    }

    public static DepartmentCreateBody.Builder builder(@NonNull String title) {
        return new Builder(new DepartmentCreateBody(title));
    }

    public static class Builder extends BodyBuilder<DepartmentCreateBody> {

        private Builder(DepartmentCreateBody body) {
            super(body);
        }

        /**
         *
         * @param users {@link DepartmentUser} User IDs with system or custom role ID.
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

        public Builder parentId(String value) {
            body.parentId = value;
            return this;
        }
    }
}
