package io.github.patbattb.yougileapilib.domain.body;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.experimental.FieldDefaults;

@Getter
@FieldDefaults(level = AccessLevel.PRIVATE)
@JsonInclude(JsonInclude.Include.NON_NULL)
public class StopwatchUpdateBody extends RequestBody {

    Boolean running;
    Boolean deleted;

    private StopwatchUpdateBody() {
    }

    public static StopwatchUpdateBody.Builder builder() {
        return new Builder(new StopwatchUpdateBody());
    }

    public static class Builder extends BodyBuilder<StopwatchUpdateBody> {

        private Builder(StopwatchUpdateBody body) {
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
