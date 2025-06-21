package io.github.patbattb.yougileapilib.domain.body;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.experimental.FieldDefaults;

@Getter
@JsonInclude(JsonInclude.Include.NON_NULL)
@FieldDefaults(level = AccessLevel.PRIVATE)
public class CompanyUpdateBody extends RequestBody {

    Boolean deleted;
    String title;

    private CompanyUpdateBody() {
    }

    public static Builder builder() {
        return new Builder(new CompanyUpdateBody());
    }

    public static class Builder extends BodyBuilder<CompanyUpdateBody> {

        private Builder(CompanyUpdateBody body) {
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
