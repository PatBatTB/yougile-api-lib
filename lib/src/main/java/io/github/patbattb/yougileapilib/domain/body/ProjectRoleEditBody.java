package io.github.patbattb.yougileapilib.domain.body;

import io.github.patbattb.yougileapilib.domain.ProjectPermissions;
import lombok.Getter;

@Getter
public class ProjectRoleEditBody extends RequestBody {

    private String name;
    private String description;
    private ProjectPermissions permissions;

    private ProjectRoleEditBody() {
    }

    public static ProjectRoleEditBody.Builder builder() {
        return new Builder(new ProjectRoleEditBody());
    }

    public static class Builder extends BodyBuilder<ProjectRoleEditBody> {

        public Builder(ProjectRoleEditBody body) {
            super(body);
        }

        public Builder name(String value) {
            body.name = value;
            return this;
        }

        public Builder description(String value) {
            body.description = value;
            return this;
        }

        public Builder projectPermissions(ProjectPermissions value) {
            body.permissions = value;
            return this;
        }
    }
}
