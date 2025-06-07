package io.github.patbattb.yougileapilib.domain.body;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.experimental.FieldDefaults;

@Getter
@FieldDefaults(level = AccessLevel.PRIVATE)
@JsonInclude(JsonInclude.Include.NON_EMPTY)
public class TimeTrackingEditBody extends RequestBody {

    Integer plan;
    Integer work;
    Boolean deleted;

    private TimeTrackingEditBody() {
    }

    public static TimeTrackingEditBody.Builder builder() {
        return new Builder(new TimeTrackingEditBody());
    }

    public static class Builder extends BodyBuilder<TimeTrackingEditBody> {

        private Builder(TimeTrackingEditBody body) {
            super(body);
        }

        public Builder plan(int value) {
            body.plan = value;
            return this;
        }

        public Builder work(int value) {
            body.work = value;
            return this;
        }

        public Builder deleted(boolean value) {
            body.deleted = value;
            return this;
        }
    }
}
