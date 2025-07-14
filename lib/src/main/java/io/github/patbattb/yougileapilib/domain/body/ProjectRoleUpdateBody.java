package io.github.patbattb.yougileapilib.domain.body;

import com.fasterxml.jackson.annotation.JsonInclude;
import io.github.patbattb.yougileapilib.domain.ProjectPermissions;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.Setter;
import lombok.experimental.FieldDefaults;

/**
 * Implementation of the {@link RequestBody} for PUT request updates {@link io.github.patbattb.yougileapilib.domain.ProjectRole}
 */
@Getter
@Setter
@FieldDefaults(level = AccessLevel.PRIVATE)
@JsonInclude(JsonInclude.Include.NON_NULL)
public class ProjectRoleUpdateBody implements RequestBody {

    String name;
    String description;
    ProjectPermissions permissions;

    private ProjectRoleUpdateBody() {
    }

    /**
     * Instantiates the builder for constructing {@link ProjectRoleUpdateBody}.
     * This builder has no parameters. All fields of the {@link ProjectRoleUpdateBody} can be specified using the builder's methods.
     * @return the builder
     */
    public static ProjectRoleUpdateBody.Builder builder() {
        return new Builder(new ProjectRoleUpdateBody());
    }

    public static class Builder extends BodyBuilder<ProjectRoleUpdateBody> {

        private Builder(ProjectRoleUpdateBody body) {
            super(body);
        }

        /**
         *
         * @param value project role's name
         * @return the builder itself for continue constructing.
         */
        public Builder name(String value) {
            body.name = value;
            return this;
        }

        /**
         *
         * @param value project role's description.
         * @return the builder itself for continue constructing.
         */
        public Builder description(String value) {
            body.description = value;
            return this;
        }

        /**
         *
         * @param value Permissions in the project.
         * @return the builder itself for continue constructing.
         */
        public Builder projectPermissions(ProjectPermissions value) {
            body.permissions = value;
            return this;
        }
    }
}
