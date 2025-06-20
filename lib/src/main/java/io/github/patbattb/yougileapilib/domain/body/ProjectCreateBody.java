package io.github.patbattb.yougileapilib.domain.body;

import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import io.github.patbattb.yougileapilib.domain.UserRole;
import io.github.patbattb.yougileapilib.http.serialize.ProjectCreateBodySerializer;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NonNull;
import lombok.experimental.FieldDefaults;

import java.util.Arrays;
import java.util.List;

@Getter
@FieldDefaults(level = AccessLevel.PRIVATE)
@JsonSerialize(using = ProjectCreateBodySerializer.class)
public class ProjectCreateBody extends RequestBody {

    final String title;
    List<UserRole> users;

    private ProjectCreateBody(String title) {
        this.title = title;
    }

    public static ProjectCreateBody.Builder builder(@NonNull String title) {
        return new Builder(new ProjectCreateBody(title));
    }

    public static class Builder extends BodyBuilder<ProjectCreateBody> {

        private Builder(ProjectCreateBody body) {
            super(body);
        }

        /**
         *
         * @param users {@link UserRole} User IDs with system or custom role IDs.
         *              Available system role IDs:
         *              <ul>
         *              <li/>{@code admin}
         *              <li/>{@code worker}
         *              <li/>{@code observer}
         *              <li/>{@code -} minus symbol to delete user from project.
         *              </ul>
         */
        public Builder users(UserRole... users) {
            body.users = Arrays.asList(users);
            return this;
        }
    }
}
