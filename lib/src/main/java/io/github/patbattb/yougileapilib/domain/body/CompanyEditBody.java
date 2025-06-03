package io.github.patbattb.yougileapilib.domain.body;

import lombok.Getter;

@Getter
public class CompanyEditBody extends RequestBody {

    private boolean deleted;
    private String title;

    private CompanyEditBody() {
    }

    public static Builder builder() {
        return new Builder(new CompanyEditBody());
    }

    public static class Builder extends BodyBuilder<CompanyEditBody> {

        public Builder(CompanyEditBody body) {
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
