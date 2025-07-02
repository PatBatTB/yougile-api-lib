package io.github.patbattb.yougileapilib.domain.body;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.experimental.FieldDefaults;

/**
 * Implementation of the {@link RequestBody} for PUT request updates {@link io.github.patbattb.yougileapilib.domain.TimeTracking}
 */
@Getter
@FieldDefaults(level = AccessLevel.PRIVATE)
@JsonInclude(JsonInclude.Include.NON_NULL)
public class TimeTrackingUpdateBody extends RequestBody {

    Double plan;
    Double work;
    Boolean deleted;

    private TimeTrackingUpdateBody() {
    }

    /**
     * Instantiates the builder for constructing {@link TimeTrackingUpdateBody}.
     * This builder has no parameters. All fields of the {@link TimeTrackingUpdateBody} can be specified using the builder's methods.
     * @return the builder
     */
    public static TimeTrackingUpdateBody.Builder builder() {
        return new Builder(new TimeTrackingUpdateBody());
    }

    public static class Builder extends BodyBuilder<TimeTrackingUpdateBody> {

        private Builder(TimeTrackingUpdateBody body) {
            super(body);
        }

        /**
         *
         * @param value How many hours were scheduled to complete the task.
         * @return the builder itself for continue constructing.
         */
        public Builder plan(double value) {
            body.plan = value;
            return this;
        }

        /**
         *
         * @param value How many hours were spent on the task.
         * @return the builder itself for continue constructing.
         */
        public Builder work(double value) {
            body.work = value;
            return this;
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
    }
}
