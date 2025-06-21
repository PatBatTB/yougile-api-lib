package io.github.patbattb.yougileapilib.domain.body;

import com.fasterxml.jackson.annotation.JsonInclude;
import io.github.patbattb.yougileapilib.domain.ProjectPermissions;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.Setter;
import lombok.experimental.FieldDefaults;

@Getter
@Setter
@FieldDefaults(level = AccessLevel.PRIVATE)
@JsonInclude(JsonInclude.Include.NON_NULL)
public class ProjectRoleUpdateBody extends RequestBody {

    String name;
    String description;
    ProjectPermissions permissions;

    private ProjectRoleUpdateBody() {
    }

    public static ProjectRoleUpdateBody.Builder builder() {
        return new Builder(new ProjectRoleUpdateBody());
    }

    public static class Builder extends BodyBuilder<ProjectRoleUpdateBody> {

        private Builder(ProjectRoleUpdateBody body) {
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
