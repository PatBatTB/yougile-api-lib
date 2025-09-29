package io.github.patbattb.yougileapilib.domain.body;

import com.fasterxml.jackson.annotation.JsonInclude;
import io.github.patbattb.yougileapilib.domain.ProjectPermissions;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NonNull;
import lombok.experimental.FieldDefaults;

/**
 * Implementation of the {@link RequestBody} for POST request creates {@link io.github.patbattb.yougileapilib.domain.ProjectRole}
 */
@Getter
@FieldDefaults(level = AccessLevel.PRIVATE)
@JsonInclude(JsonInclude.Include.NON_NULL)
public class ProjectRoleCreateBody implements RequestBody {

    final String name;
    String description;
    final ProjectPermissions permissions;

    private ProjectRoleCreateBody(String name, ProjectPermissions permissions) {
        this.name = name;
        this.permissions = permissions;
    }

    /**
     * Instantiates the builder for constructing {@link ProjectRoleCreateBody}.
     * Required fields of the {@link ProjectRoleCreateBody} needs to be passed as the arguments.
     * The remaining fields can be specified using the builder's methods.
     * @param name project role's name
     * @param permissions Permissions in the project.
     * @return the builder.
     */
    public static ProjectRoleCreateBody.Builder builder(@NonNull String name, @NonNull ProjectPermissions permissions) {
        return new Builder(new ProjectRoleCreateBody(name, permissions));
    }

    public static class Builder extends BodyBuilder<ProjectRoleCreateBody> {

        private Builder(ProjectRoleCreateBody body) {
            super(body);
        }

        /**
         *
         * @param value project role's description.
         * @return the builder itself for continue constructing.
         */
        public Builder description(@NonNull String value) {
            body.description = value;
            return this;
        }
    }
}
