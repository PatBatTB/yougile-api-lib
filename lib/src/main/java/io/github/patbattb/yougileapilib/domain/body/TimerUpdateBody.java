package io.github.patbattb.yougileapilib.domain.body;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.experimental.FieldDefaults;

@Getter
@FieldDefaults(level = AccessLevel.PRIVATE)
@JsonInclude(JsonInclude.Include.NON_NULL)
public class TimerUpdateBody extends RequestBody {

    Integer seconds;
    Boolean running;
    Boolean deleted;

    private TimerUpdateBody() {}

    public static TimerUpdateBody.Builder builder() {
        return new Builder(new TimerUpdateBody());
    }

    public static class Builder extends BodyBuilder<TimerUpdateBody> {

        private Builder(TimerUpdateBody body) {
            super(body);
        }

        public Builder seconds(int value) {
            body.seconds = value;
            return this;
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
