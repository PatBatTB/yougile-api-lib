package io.github.patbattb.yougileapilib.domain.body;

import lombok.Getter;

@Getter
public class EditCompanyBody extends RequestBody {

    private boolean deleted;
    private String title;

    private EditCompanyBody() {
    }

    public static Builder builder() {
        return new Builder(new EditCompanyBody());
    }

    public static class Builder extends BodyBuilder<EditCompanyBody> {

        public Builder(EditCompanyBody body) {
            super(body);
        }

        public Builder deleted(boolean value) {
            body.deleted = value;
            return this;
        }

        public Builder title(String value) {
            body.title = value;
            return this;
        }
    }
}
