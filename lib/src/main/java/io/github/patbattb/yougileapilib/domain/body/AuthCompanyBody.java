package io.github.patbattb.yougileapilib.domain.body;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.experimental.FieldDefaults;

@Getter
@JsonInclude(JsonInclude.Include.NON_EMPTY)
@FieldDefaults(level = AccessLevel.PRIVATE)
public class AuthCompanyBody extends RequestBody{

    final String login;
    final String password;
    String name;

    private AuthCompanyBody(String login, String password) {
        this.login = login;
        this.password = password;
    }

    public static AuthCompanyBody.Builder builder(String login, String password) {
        return new Builder(new AuthCompanyBody(login, password));
    }

    public static class Builder extends BodyBuilder<AuthCompanyBody> {

        private Builder(AuthCompanyBody body) {
            super(body);
        }

        public Builder name(String value) {
            body.name = value;
            return this;
        }
    }
}
