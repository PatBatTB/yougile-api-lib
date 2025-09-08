package io.github.patbattb.yougileapilib.domain.body;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.experimental.FieldDefaults;

/**
 * Implementation of the {@link RequestBody} for PUT request updates
 * {@link io.github.patbattb.yougileapilib.domain.Timer} in the {@link io.github.patbattb.yougileapilib.domain.Task}
 */
@Getter
@FieldDefaults(level = AccessLevel.PRIVATE)
@JsonInclude(JsonInclude.Include.NON_NULL)
public class TimerUpdateBody implements RequestBody {

    Integer seconds;
    Boolean running;
    Boolean deleted;

    private TimerUpdateBody() {}

    /**
     * Instantiates the builder for constructing {@link TimerUpdateBody}.
     * This builder has no parameters. All fields of the {@link TimerUpdateBody} can be specified using the builder's methods.
     * @return the builder
     */
    public static TimerUpdateBody.Builder builder() {
        return new Builder(new TimerUpdateBody());
    }

    public static class Builder extends BodyBuilder<TimerUpdateBody> {

        private Builder(TimerUpdateBody body) {
            super(body);
        }

        /**
         *
         * @param value How many seconds remain for the timer finish.
         * @return the builder itself for continue constructing.
         */
        public Builder seconds(Integer value) {
            body.seconds = value;
            return this;
        }

        /**
         *
         * @param value Timer status - running / stopped.
         * @return the builder itself for continue constructing.
         */
        public Builder running(Boolean value) {
            body.running = value;
            return this;
        }

        /**
         *
         * @param value if true, then object will be deleted.
         * @return the builder itself for continue constructing.
         */
        public Builder deleted(Boolean value) {
            body.deleted = value;
            return this;
        }
    }
}
