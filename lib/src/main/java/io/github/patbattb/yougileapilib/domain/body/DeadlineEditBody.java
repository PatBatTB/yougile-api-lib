package io.github.patbattb.yougileapilib.domain.body;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.experimental.FieldDefaults;

import java.util.ArrayList;
import java.util.List;

@Getter
@FieldDefaults(level = AccessLevel.PRIVATE)
@JsonInclude(JsonInclude.Include.NON_EMPTY)
public class DeadlineEditBody extends RequestBody {

    Long deadline;
    Long startDate;
    Boolean withTime;
    final List<String> history;
    final List<String> blockedPoints;
    //TODO Можно передавать ID задачи в конструктор, то бы в списке была как минимум одна задача.
    final List<String> links;
    Boolean deleted;

    private DeadlineEditBody(List<String> history, List<String> blockedPoints, List<String> links) {
        this.history = history;
        this.blockedPoints = blockedPoints;
        this.links = links;
    }

    public static DeadlineEditBody.Builder builder() {
        return new Builder(new DeadlineEditBody(new ArrayList<>(), new ArrayList<>(), new ArrayList<>()));
    }

    public static class Builder extends BodyBuilder<DeadlineEditBody> {

        private Builder(DeadlineEditBody body) {
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

        public Builder addHistory(String historyPoint) {
            body.history.add(historyPoint);
            return this;
        }

        public Builder addBlockedPoint(String point) {
            body.blockedPoints.add(point);
            return this;
        }

        public Builder addLink(String taskId) {
            body.links.add(taskId);
            return this;
        }

        public Builder deleted(boolean value) {
            body.deleted = value;
            return this;
        }
    }
}
