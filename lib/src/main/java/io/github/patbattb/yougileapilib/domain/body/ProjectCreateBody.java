package io.github.patbattb.yougileapilib.domain.body;

import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import io.github.patbattb.yougileapilib.domain.ProjectUser;
import io.github.patbattb.yougileapilib.http.serialize.ProjectCreateBodySerializer;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NonNull;
import lombok.experimental.FieldDefaults;

import java.util.Arrays;
import java.util.List;

/**
 * Implementation of the {@link RequestBody} for POST request creates {@link io.github.patbattb.yougileapilib.domain.Project}
 */
@Getter
@FieldDefaults(level = AccessLevel.PRIVATE)
@JsonSerialize(using = ProjectCreateBodySerializer.class)
public class ProjectCreateBody extends RequestBody {

    final String title;
    List<ProjectUser> users;

    private ProjectCreateBody(String title) {
        this.title = title;
    }

    /**
     * Instantiates the builder for constructing {@link ProjectCreateBody}.
     * Required fields of the {@link ProjectCreateBody} needs to be passed as the arguments.
     * The remaining fields can be specified using the builder's methods.
     * @param title project name
     * @return the builder.
     */
    public static ProjectCreateBody.Builder builder(@NonNull String title) {
        return new Builder(new ProjectCreateBody(title));
    }

    public static class Builder extends BodyBuilder<ProjectCreateBody> {

        private Builder(ProjectCreateBody body) {
            super(body);
        }

        /**
         *
         * @param users {@link ProjectUser} User IDs with system or custom role IDs.
         *              Available system role IDs:
         *              <ul>
         *              <li>{@code admin}
         *              <li>{@code worker}
         *              <li>{@code observer}
         *              <li>{@code -} minus symbol to delete user from project.
         *              </ul>
         */
        public Builder users(ProjectUser... users) {
            body.users = Arrays.asList(users);
            return this;
        }
    }
}
