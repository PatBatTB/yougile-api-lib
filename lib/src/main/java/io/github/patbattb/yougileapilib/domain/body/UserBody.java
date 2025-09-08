package io.github.patbattb.yougileapilib.domain.body;

import com.fasterxml.jackson.annotation.JsonGetter;
import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NonNull;
import lombok.experimental.FieldDefaults;

/**
 * Implementation of the {@link RequestBody} for POST request to invite {@link io.github.patbattb.yougileapilib.domain.User}
 * to the {@link io.github.patbattb.yougileapilib.domain.Company}.
 * The general ID of the user is email (the email may be specified random value).
 * If a user with the email not registered on the YouGile, an invitation will be sent to their email address.
 */
@JsonInclude(JsonInclude.Include.NON_NULL)
@FieldDefaults(level = AccessLevel.PRIVATE)
public class UserBody implements RequestBody {

    @Getter
    final String email;
    /**
     * Has the user admin rights?
     */
    Boolean isAdmin;

    private UserBody(String email) {
        this.email = email;
    }

    /**
     * Instantiates the builder for constructing {@link UserBody}.
     * Required fields of the {@link UserBody} needs to be passed as the arguments.
     * The remaining fields can be specified using the builder's methods.
     * @param email user email
     * @return the builder.
     */
    public static UserBody.Builder builder(@NonNull String email) {
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

        /**
         *
         * @param value Has the user admin rights?
         * @return the builder itself for continue constructing.
         */
        public Builder isAdmin(Boolean value) {
            body.isAdmin = value;
            return this;
        }
    }
}


