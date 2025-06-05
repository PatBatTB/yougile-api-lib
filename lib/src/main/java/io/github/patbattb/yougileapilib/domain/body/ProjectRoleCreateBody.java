package io.github.patbattb.yougileapilib.domain.body;

import com.fasterxml.jackson.annotation.JsonInclude;
import io.github.patbattb.yougileapilib.domain.ProjectPermissions;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.experimental.FieldDefaults;

@Getter
@FieldDefaults(level = AccessLevel.PRIVATE)
@JsonInclude(JsonInclude.Include.NON_EMPTY)
public class ProjectRoleCreateBody extends RequestBody {

    final String name;
    String description;
    final ProjectPermissions permissions;

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
