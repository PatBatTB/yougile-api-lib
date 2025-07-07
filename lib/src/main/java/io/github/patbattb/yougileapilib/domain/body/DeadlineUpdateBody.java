package io.github.patbattb.yougileapilib.domain.body;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.experimental.FieldDefaults;

/**
 * Implementation of the {@link RequestBody} for PUT request updates
 * {@link io.github.patbattb.yougileapilib.domain.Deadline} in the {@link io.github.patbattb.yougileapilib.domain.Task}
 */
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

    /**
     * Instantiates the builder for constructing {@link DeadlineUpdateBody}.
     * This builder has no parameters. All fields of the {@link DeadlineUpdateBody} can be specified using the builder's methods.
     * @return the builder
     */
    public static DeadlineUpdateBody.Builder builder() {
        return new Builder(new DeadlineUpdateBody());
    }

    public static class Builder extends BodyBuilder<DeadlineUpdateBody> {

        private Builder(DeadlineUpdateBody body) {
            super(body);
        }

        /**
         *
         * @param value deadline's timestamp.
         * @return the builder itself for continue constructing.
         */
        public Builder deadline(long value) {
            body.deadline = value;
            return this;
        }

        /**
         *
         * @param value task start's timestamp
         * @return the builder itself for continue constructing.
         */
        public Builder startDate(long value) {
            body.startDate = value;
            return this;
        }

        /**
         * Display the time on the sticker, or only the date
         * @param value if true. then time will be displayed.
         * @return the builder itself for continue constructing.
         */
        public Builder withTime(boolean value) {
            body.withTime = value;
            return this;
        }

        /**
         *
         * @param value if true, then the object will be deleted.
         * @return the builder itself for continue constructing.
         */
        public Builder deleted(boolean value) {
            body.deleted = value;
            return this;
        }
    }
}
