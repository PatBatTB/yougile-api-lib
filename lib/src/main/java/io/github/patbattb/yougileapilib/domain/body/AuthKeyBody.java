package io.github.patbattb.yougileapilib.domain.body;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.experimental.FieldDefaults;

@Getter
@JsonInclude(JsonInclude.Include.NON_EMPTY)
@FieldDefaults(level = AccessLevel.PRIVATE)
public class AuthKeyBody extends RequestBody {

    final String login;
    final String password;
    final String companyId;

    private AuthKeyBody(String login, String password, String companyId) {
        this.login = login;
        this.password = password;
        this.companyId = companyId;
    }

    public static AuthKeyBody.Builder builder(String login, String password, String companyId) {
        return new Builder(new AuthKeyBody(login, password, companyId));
    }

    public static class Builder extends BodyBuilder<AuthKeyBody> {

        private Builder(AuthKeyBody body) {
            super(body);
        }
    }

}
