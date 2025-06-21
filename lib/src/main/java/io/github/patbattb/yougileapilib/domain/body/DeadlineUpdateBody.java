package io.github.patbattb.yougileapilib.domain.body;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.experimental.FieldDefaults;

@Getter
@FieldDefaults(level = AccessLevel.PRIVATE)
@JsonInclude(JsonInclude.Include.NON_NULL)
public class DeadlineUpdateBody extends RequestBody {

    Long deadline;
    Long startDate;
    Boolean withTime;
    Boolean deleted;

    private DeadlineUpdateBody() {
    }

    public static DeadlineUpdateBody.Builder builder() {
        return new Builder(new DeadlineUpdateBody());
    }

    public static class Builder extends BodyBuilder<DeadlineUpdateBody> {

        private Builder(DeadlineUpdateBody body) {
            super(body);
        }

        public Builder deadline(long value) {
            body.deadline = value;
            return this;
        }

        public Builder startDate(long value) {
            body.startDate = value;
            return this;
        }

        public Builder withTime(boolean value) {
            body.withTime = value;
            return this;
        }

        public Builder deleted(boolean value) {
            body.deleted = value;
            return this;
        }
    }
}
