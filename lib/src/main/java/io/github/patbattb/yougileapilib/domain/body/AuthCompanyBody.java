package io.github.patbattb.yougileapilib.domain.body;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Getter;

@Getter
@JsonInclude(JsonInclude.Include.NON_NULL)
public class AuthCompanyBody extends RequestBody{

    private final String login;
    private final String password;
    private String name;

    private AuthCompanyBody(String login, String password) {
        this.login = login;
        this.password = password;
    }

    public static AuthCompanyBody.Builder builder(String login, String password) {
        return new Builder(new AuthCompanyBody(login, password));
    }

    public static class Builder extends BodyBuilder<AuthCompanyBody> {

        public Builder(AuthCompanyBody body) {
            super(body);
        }

        public Builder setName(String name) {
            body.name = name;
            return this;
        }
    }
}
