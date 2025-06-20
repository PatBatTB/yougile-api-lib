package io.github.patbattb.yougileapilib.domain.body;

import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import io.github.patbattb.yougileapilib.domain.UserRole;
import io.github.patbattb.yougileapilib.http.serialize.ProjectUpdateBodySerializer;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.experimental.FieldDefaults;

import java.util.Arrays;
import java.util.List;

@Getter
@FieldDefaults(level = AccessLevel.PRIVATE)
@JsonSerialize(using = ProjectUpdateBodySerializer.class)
public class ProjectUpdateBody extends RequestBody {

    Boolean deleted;
    String title;
    List<UserRole> users;

    private ProjectUpdateBody() {
    }

    public static ProjectUpdateBody.Builder builder() {
        return new Builder(new ProjectUpdateBody());
    }

    public static class Builder extends BodyBuilder<ProjectUpdateBody> {

        private Builder(ProjectUpdateBody body) {
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

        public Builder users(UserRole... users) {
            body.users = Arrays.asList(users);
            return this;
        }
    }
}
