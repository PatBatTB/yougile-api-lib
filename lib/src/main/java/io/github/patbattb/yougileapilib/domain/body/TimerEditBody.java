package io.github.patbattb.yougileapilib.domain.body;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.experimental.FieldDefaults;

@Getter
@FieldDefaults(level = AccessLevel.PRIVATE)
@JsonInclude(JsonInclude.Include.NON_EMPTY)
public class TimerEditBody extends RequestBody {

    Integer seconds;
    Boolean running;
    Boolean deleted;

    private TimerEditBody() {}

    public static TimerEditBody.Builder builder() {
        return new Builder(new TimerEditBody());
    }

    public static class Builder extends BodyBuilder<TimerEditBody> {

        private Builder(TimerEditBody body) {
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
