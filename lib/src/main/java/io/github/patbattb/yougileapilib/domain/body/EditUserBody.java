package io.github.patbattb.yougileapilib.domain.body;

import com.fasterxml.jackson.annotation.JsonGetter;
import com.fasterxml.jackson.annotation.JsonInclude;

@JsonInclude(JsonInclude.Include.NON_EMPTY)
public class EditUserBody extends RequestBody {

    private final boolean isAdmin;

    private EditUserBody(boolean isAdmin) {
        this.isAdmin = isAdmin;
    }

    @JsonGetter("isAdmin")
    public boolean isAdmin() {
        return isAdmin;
    }



    public static EditUserBody.Builder builder(boolean isAdmin) {
        return new Builder(new EditUserBody(isAdmin));
    }

    public static class Builder extends  BodyBuilder<EditUserBody> {

        public Builder(EditUserBody body) {
            super(body);
        }
    }
}
