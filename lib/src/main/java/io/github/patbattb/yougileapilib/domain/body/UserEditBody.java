package io.github.patbattb.yougileapilib.domain.body;

import com.fasterxml.jackson.annotation.JsonGetter;
import com.fasterxml.jackson.annotation.JsonInclude;

@JsonInclude(JsonInclude.Include.NON_EMPTY)
public class UserEditBody extends RequestBody {

    private final boolean isAdmin;

    private UserEditBody(boolean isAdmin) {
        this.isAdmin = isAdmin;
    }

    @JsonGetter("isAdmin")
    public boolean isAdmin() {
        return isAdmin;
    }



    public static UserEditBody.Builder builder(boolean isAdmin) {
        return new Builder(new UserEditBody(isAdmin));
    }

    public static class Builder extends  BodyBuilder<UserEditBody> {

        public Builder(UserEditBody body) {
            super(body);
        }
    }
}
