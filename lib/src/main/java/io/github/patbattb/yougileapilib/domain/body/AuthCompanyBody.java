package io.github.patbattb.yougileapilib.domain.body;

import com.fasterxml.jackson.annotation.JsonInclude;
import io.github.patbattb.yougileapilib.domain.AuthCompany;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NonNull;
import lombok.experimental.FieldDefaults;

/**
 * Implementation of the {@link RequestBody} for POST request gets List of {@link AuthCompany}
 */
@Getter
@JsonInclude(JsonInclude.Include.NON_NULL)
@FieldDefaults(level = AccessLevel.PRIVATE)
public class AuthCompanyBody extends RequestBody{

    final String login;
    final String password;
    String name;

    private AuthCompanyBody(String login, String password) {
        this.login = login;
        this.password = password;
    }

    /**
     * Instantiates the builder for constructing {@link AuthCompanyBody}.
     * Required fields of the authCompanyBody needs to be passed as the arguments.
     * The remaining fields can be specified using the builder's methods.
     * @param login user login.
     * @param password user password
     * @return the builder.
     */
    public static AuthCompanyBody.Builder builder(@NonNull String login, @NonNull String password) {
        return new Builder(new AuthCompanyBody(login, password));
    }

    public static class Builder extends BodyBuilder<AuthCompanyBody> {

        private Builder(AuthCompanyBody body) {
            super(body);
        }

        /**
         * @param value Company name.
         * @return the builder itself for continue constructing.
         */
        public Builder name(String value) {
            body.name = value;
            return this;
        }
    }
}
