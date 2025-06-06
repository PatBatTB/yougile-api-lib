package io.github.patbattb.yougileapilib.domain.body;

import com.fasterxml.jackson.annotation.JsonInclude;
import io.github.patbattb.yougileapilib.domain.ProjectPermissions;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.experimental.FieldDefaults;

@Getter
@FieldDefaults(level = AccessLevel.PRIVATE)
@JsonInclude(JsonInclude.Include.NON_EMPTY)
public class ProjectRoleEditBody extends RequestBody {

    String name;
    String description;
    ProjectPermissions permissions;

    private ProjectRoleEditBody() {
    }

    public static ProjectRoleEditBody.Builder builder() {
        return new Builder(new ProjectRoleEditBody());
    }

    public static class Builder extends BodyBuilder<ProjectRoleEditBody> {

        private Builder(ProjectRoleEditBody body) {
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
