package io.github.patbattb.yougileapilib.domain.body;

import com.fasterxml.jackson.annotation.JsonInclude;
import io.github.patbattb.yougileapilib.domain.Company;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.experimental.FieldDefaults;

/**
 * Implementation of the {@link RequestBody} for PUT request updates {@link Company}
 */
@Getter
@JsonInclude(JsonInclude.Include.NON_NULL)
@FieldDefaults(level = AccessLevel.PRIVATE)
public class CompanyUpdateBody extends RequestBody {

    Boolean deleted;
    String title;

    private CompanyUpdateBody() {
    }

    /**
     * Instantiates the builder for constructing {@link CompanyUpdateBody}.
     * This builder has no parameters. All fields of the {@link CompanyUpdateBody} can be specified using the builder's methods.
     * @return the builder
     */
    public static Builder builder() {
        return new Builder(new CompanyUpdateBody());
    }

    public static class Builder extends BodyBuilder<CompanyUpdateBody> {

        private Builder(CompanyUpdateBody body) {
            super(body);
        }

        /**
         *
         * @param value if true, then object will be deleted.
         * @return the builder itself for continue constructing.
         */
        public Builder deleted(boolean value) {
            body.deleted = value;
            return this;
        }

        /**
         *
         * @param value company new name
         * @return the builder itself for continue constructing.
         */
        public Builder title(String value) {
            body.title = value;
            return this;
        }
    }
}
