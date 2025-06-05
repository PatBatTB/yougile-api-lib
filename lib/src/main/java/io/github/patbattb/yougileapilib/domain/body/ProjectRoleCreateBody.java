package io.github.patbattb.yougileapilib.domain.body;

import io.github.patbattb.yougileapilib.domain.ProjectPermissions;
import lombok.Getter;

@Getter
public class ProjectRoleCreateBody extends RequestBody {

    private final String name;
    private String description;
    private final ProjectPermissions permissions;

    private ProjectRoleCreateBody(String name, ProjectPermissions permissions) {
        this.name = name;
        this.permissions = permissions;
    }

    public static ProjectRoleCreateBody.Builder builder(String name, ProjectPermissions permissions) {
        return new Builder(new ProjectRoleCreateBody(name, permissions));
    }

    public static class Builder extends BodyBuilder<ProjectRoleCreateBody> {

        public Builder(ProjectRoleCreateBody body) {
            super(body);
        }

        public Builder description(String value) {
            body.description = value;
            return this;
        }
    }
}
