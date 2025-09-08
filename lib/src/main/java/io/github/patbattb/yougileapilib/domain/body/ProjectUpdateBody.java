package io.github.patbattb.yougileapilib.domain.body;

import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import io.github.patbattb.yougileapilib.domain.ProjectUser;
import io.github.patbattb.yougileapilib.http.serialize.ProjectUpdateBodySerializer;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.experimental.FieldDefaults;

import java.util.Arrays;
import java.util.List;

/**
 * Implementation of the {@link RequestBody} for PUT request updates {@link io.github.patbattb.yougileapilib.domain.Project}
 */
@Getter
@FieldDefaults(level = AccessLevel.PRIVATE)
@JsonSerialize(using = ProjectUpdateBodySerializer.class)
public class ProjectUpdateBody implements RequestBody {

    Boolean deleted;
    String title;
    List<ProjectUser> users;

    private ProjectUpdateBody() {
    }

    /**
     * Instantiates the builder for constructing {@link ProjectUpdateBody}.
     * This builder has no parameters. All fields of the {@link ProjectUpdateBody} can be specified using the builder's methods.
     * @return the builder
     */
    public static ProjectUpdateBody.Builder builder() {
        return new Builder(new ProjectUpdateBody());
    }

    public static class Builder extends BodyBuilder<ProjectUpdateBody> {

        private Builder(ProjectUpdateBody body) {
            super(body);
        }

        /**
         *
         * @param value if true, then object will be deleted.
         * @return the builder itself for continue constructing.
         */
        public Builder deleted(Boolean value) {
            body.deleted = value;
            return this;
        }

        /**
         *
         * @param value project name.
         * @return the builder itself for continue constructing.
         */
        public Builder title(String value) {
            body.title = value;
            return this;
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
