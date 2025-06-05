package io.github.patbattb.yougileapilib.domain.body;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.experimental.FieldDefaults;

@Getter
@JsonInclude(JsonInclude.Include.NON_EMPTY)
@FieldDefaults(level = AccessLevel.PRIVATE)
public class CompanyEditBody extends RequestBody {

    boolean deleted;
    String title;

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
