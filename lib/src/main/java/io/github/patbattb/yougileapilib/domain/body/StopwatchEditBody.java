package io.github.patbattb.yougileapilib.domain.body;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.experimental.FieldDefaults;

@Getter
@FieldDefaults(level = AccessLevel.PRIVATE)
@JsonInclude(JsonInclude.Include.NON_EMPTY)
public class StopwatchEditBody extends RequestBody {

    Boolean running;
    Boolean deleted;

    private StopwatchEditBody() {
    }

    public static StopwatchEditBody.Builder builder() {
        return new Builder(new StopwatchEditBody());
    }

    public static class Builder extends BodyBuilder<StopwatchEditBody> {

        private Builder(StopwatchEditBody body) {
            super(body);
        }

        public Builder running(boolean value) {
            body.running = value;
            return this;
        }

        public Builder deleted(boolean value) {
            body.deleted = value;
            return this;
        }
    }
}
