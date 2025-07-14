package io.github.patbattb.yougileapilib.domain.body;

import com.fasterxml.jackson.annotation.JsonGetter;
import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.AccessLevel;
import lombok.experimental.FieldDefaults;

/**
 * Implementation of the {@link RequestBody} for PUT request updates {@link io.github.patbattb.yougileapilib.domain.User}
 */
@JsonInclude(JsonInclude.Include.NON_NULL)
@FieldDefaults(level = AccessLevel.PRIVATE)
public class UserUpdateBody implements RequestBody {

    /**
     * Has the user admin rights?
     */
    final Boolean isAdmin;

    private UserUpdateBody(boolean isAdmin) {
        this.isAdmin = isAdmin;
    }

    @JsonGetter("isAdmin")
    public boolean isAdmin() {
        return isAdmin;
    }

    /**
     * Instantiates the builder for constructing {@link UserUpdateBody}.
     * Required fields of the {@link UserUpdateBody} needs to be passed as the arguments.
     * @param isAdmin Has the user admin rights?
     * @return the builder.
     */
    public static UserUpdateBody.Builder builder(boolean isAdmin) {
        return new Builder(new UserUpdateBody(isAdmin));
    }

    public static class Builder extends  BodyBuilder<UserUpdateBody> {

        private Builder(UserUpdateBody body) {
            super(body);
        }
    }
}
