package io.github.patbattb.yougileapilib.domain.body;

import com.fasterxml.jackson.annotation.JsonGetter;
import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.experimental.FieldDefaults;


@JsonInclude(JsonInclude.Include.NON_EMPTY)
@FieldDefaults(level = AccessLevel.PRIVATE)
public class UserBody extends RequestBody {

    @Getter
    final String email;
    Boolean isAdmin;

    private UserBody(String email) {
        this.email = email;
    }

    public static UserBody.Builder builder(String email) {
        return new Builder(new UserBody(email));
    }

    @JsonGetter("isAdmin")
    public Boolean isAdmin() {
        return isAdmin;
    }

    public static class Builder extends BodyBuilder<UserBody> {

        private Builder(UserBody body) {
            super(body);
        }

        public Builder isAdmin(boolean value) {
            body.isAdmin = value;
            return this;
        }
    }
}

