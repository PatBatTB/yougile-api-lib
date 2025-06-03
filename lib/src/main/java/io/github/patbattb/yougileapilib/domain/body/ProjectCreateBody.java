package io.github.patbattb.yougileapilib.domain.body;

import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import io.github.patbattb.yougileapilib.domain.ProjectUser;
import io.github.patbattb.yougileapilib.http.serialize.ProjectCreateBodySerializer;
import lombok.Getter;

import java.util.ArrayList;
import java.util.List;

@Getter
@JsonSerialize(using = ProjectCreateBodySerializer.class)
public class ProjectCreateBody extends RequestBody {
    private final String title;
    private final List<ProjectUser> users;

    private ProjectCreateBody(String title, List<ProjectUser> users) {
        this.title = title;
        this.users = users;
    }

    public static ProjectCreateBody.Builder builder(String title) {
        return new Builder(new ProjectCreateBody(title, new ArrayList<>()));
    }

    public static class Builder extends BodyBuilder<ProjectCreateBody> {

        public Builder(ProjectCreateBody body) {
            super(body);
        }

        public Builder users(ProjectUser user) {
            body.users.add(user);
            return this;
        }

        @Override
        public ProjectCreateBody build() {
            return new ProjectCreateBody(this.body.title, List.copyOf(this.body.users));
        }
    }
}
