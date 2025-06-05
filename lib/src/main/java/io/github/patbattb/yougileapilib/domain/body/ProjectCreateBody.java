package io.github.patbattb.yougileapilib.domain.body;

import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import io.github.patbattb.yougileapilib.domain.UserRole;
import io.github.patbattb.yougileapilib.http.serialize.ProjectCreateBodySerializer;
import lombok.Getter;

import java.util.ArrayList;
import java.util.List;

@Getter
@JsonSerialize(using = ProjectCreateBodySerializer.class)
public class ProjectCreateBody extends RequestBody {
    private final String title;
    private final List<UserRole> users;

    private ProjectCreateBody(String title, List<UserRole> users) {
        this.title = title;
        this.users = users;
    }

    public static ProjectCreateBody.Builder builder(String title) {
        return new Builder(new ProjectCreateBody(title, new ArrayList<>()));
    }

    public static class Builder extends BodyBuilder<ProjectCreateBody> {

        public Builder(ProjectCreateBody body) {
            super(body);
        }

        /**
         *
         * @param user {@link UserRole} User ID with system or custom role ID.
         *              Available system role IDs:
         *              <ul>
         *              <li/>{@code admin}
         *              <li/>{@code worker}
         *              <li/>{@code observer}
         *              <li/>{@code -} minus symbol to delete user from project.
         *              </ul>
         */
        public Builder users(UserRole user) {
            body.users.add(user);
            return this;
        }

        @Override
        public ProjectCreateBody build() {
            return new ProjectCreateBody(this.body.title, List.copyOf(this.body.users));
        }
    }
}
