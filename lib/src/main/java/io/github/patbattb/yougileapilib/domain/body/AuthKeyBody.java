package io.github.patbattb.yougileapilib.domain.body;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Getter;

@Getter
@JsonInclude(JsonInclude.Include.NON_NULL)
public class AuthKeyBody extends RequestBody {

    private final String login;
    private final String password;
    private final String companyId;

    private AuthKeyBody(String login, String password, String companyId) {
        this.login = login;
        this.password = password;
        this.companyId = companyId;
    }

    public static AuthKeyBody.Builder builder(String login, String password, String companyId) {
        return new Builder(new AuthKeyBody(login, password, companyId));
    }

    public static class Builder extends BodyBuilder<AuthKeyBody> {

        public Builder(AuthKeyBody body) {
            super(body);
        }
    }

}
