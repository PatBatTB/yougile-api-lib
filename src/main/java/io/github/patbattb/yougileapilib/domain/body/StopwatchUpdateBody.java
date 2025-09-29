package io.github.patbattb.yougileapilib.domain.body;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.experimental.FieldDefaults;

/**
 * Implementation of the {@link RequestBody} for PUT request updates
 * {@link io.github.patbattb.yougileapilib.domain.Stopwatch} in the {@link io.github.patbattb.yougileapilib.domain.Task}
 */
@Getter
@FieldDefaults(level = AccessLevel.PRIVATE)
@JsonInclude(JsonInclude.Include.NON_NULL)
public class StopwatchUpdateBody implements RequestBody {

    Boolean running;
    Boolean deleted;

    private StopwatchUpdateBody() {
    }

    /**
     * Instantiates the builder for constructing {@link StopwatchUpdateBody}.
     * This builder has no parameters. All fields of the {@link StopwatchUpdateBody} can be specified using the builder's methods.
     * @return the builder
     */
    public static StopwatchUpdateBody.Builder builder() {
        return new Builder(new StopwatchUpdateBody());
    }

    public static class Builder extends BodyBuilder<StopwatchUpdateBody> {

        private Builder(StopwatchUpdateBody body) {
            super(body);
        }

        /**
         *
         * @param value Stopwatch status - started (true) / stopped (false)
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
