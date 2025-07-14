package io.github.patbattb.yougileapilib.domain.body;

import com.fasterxml.jackson.annotation.JsonInclude;
import io.github.patbattb.yougileapilib.domain.AuthKey;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NonNull;
import lombok.experimental.FieldDefaults;

/**
 * Implementation of the {@link RequestBody} for POST request gets List of {@link AuthKey}
 */
@Getter
@JsonInclude(JsonInclude.Include.NON_NULL)
@FieldDefaults(level = AccessLevel.PRIVATE)
public class AuthKeyBody implements RequestBody {

    final String login;
    final String password;
    final String companyId;

    private AuthKeyBody(String login, String password, String companyId) {
        this.login = login;
        this.password = password;
        this.companyId = companyId;
    }

    /**
     * Instantiates the builder for constructing {@link AuthKeyBody}.
     * Required fields of the AuthKeyBody needs to be passed as the arguments.
     * The remaining fields can be specified using the builder's methods.
     * @param login user login
     * @param password user password
     * @param companyId company ID
     * @return the builder.
     */
    public static AuthKeyBody.Builder builder(@NonNull String login, @NonNull String password, @NonNull String companyId) {
        return new Builder(new AuthKeyBody(login, password, companyId));
    }

    public static class Builder extends BodyBuilder<AuthKeyBody> {

        private Builder(AuthKeyBody body) {
            super(body);
        }
    }

}
