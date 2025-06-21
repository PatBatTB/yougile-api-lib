package io.github.patbattb.yougileapilib.domain.body;

import com.fasterxml.jackson.annotation.JsonGetter;
import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.AccessLevel;
import lombok.experimental.FieldDefaults;

@JsonInclude(JsonInclude.Include.NON_NULL)
@FieldDefaults(level = AccessLevel.PRIVATE)
public class UserUpdateBody extends RequestBody {

    final Boolean isAdmin;

    private UserUpdateBody(boolean isAdmin) {
        this.isAdmin = isAdmin;
    }

    @JsonGetter("isAdmin")
    public boolean isAdmin() {
        return isAdmin;
    }



    public static UserUpdateBody.Builder builder(boolean isAdmin) {
        return new Builder(new UserUpdateBody(isAdmin));
    }

    public static class Builder extends  BodyBuilder<UserUpdateBody> {

        private Builder(UserUpdateBody body) {
            super(body);
        }
    }
}
