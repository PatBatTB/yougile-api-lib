package io.github.patbattb.yougileapilib.domain.body;

import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import io.github.patbattb.yougileapilib.domain.UserRole;
import io.github.patbattb.yougileapilib.http.serialize.ProjectEditBodySerializer;
import lombok.Getter;

import java.util.ArrayList;
import java.util.List;

@Getter
@JsonSerialize(using = ProjectEditBodySerializer.class)
public class ProjectEditBody extends RequestBody {
    private boolean deleted;
    private String title;
    private List<UserRole> users;

    private ProjectEditBody(List<UserRole> users) {
        this.users = users;
    }

    public static ProjectEditBody.Builder builder() {
        return new Builder(new ProjectEditBody(new ArrayList<>()));
    }

    public static class Builder extends BodyBuilder<ProjectEditBody> {

        public Builder(ProjectEditBody body) {
            super(body);
        }

        public Builder deleted(boolean value) {
            body.deleted = value;
            return this;
        }

        public Builder title(String value) {
            body.title = value;
            return this;
        }

        public Builder users(UserRole user) {
            body.users.add(user);
            return this;
        }

        @Override
        public ProjectEditBody build() {
            body.users = List.copyOf(body.users);
            return body;
        }
    }
}
