package io.github.patbattb.yougileapilib.domain.body;

import io.github.patbattb.yougileapilib.domain.ProjectPermissions;
import lombok.Getter;

@Getter
public class ProjectRoleBody extends RequestBody {

    private final String name;
    private String description;
    private final ProjectPermissions permissions;

    private ProjectRoleBody(String name, ProjectPermissions permissions) {
        this.name = name;
        this.permissions = permissions;
    }

    public static ProjectRoleBody.Builder builder(String name, ProjectPermissions permissions) {
        return new Builder(new ProjectRoleBody(name, permissions));
    }

    public static class Builder extends BodyBuilder<ProjectRoleBody> {

        public Builder(ProjectRoleBody body) {
            super(body);
        }

        public Builder description(String value) {
            body.description = value;
            return this;
        }
    }
}
