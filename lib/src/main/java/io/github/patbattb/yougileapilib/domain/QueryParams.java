package io.github.patbattb.yougileapilib.domain;

import java.util.HashMap;
import java.util.Map;


public class QueryParams {

    private final Map<String, Object> paramsMap;

    public static QueryParams empty() {
        return new QueryParams();
    }

    private QueryParams() {
        paramsMap = new HashMap<>();
    }

    public Map<String, Object> getParams() {
        return Map.copyOf(paramsMap);
    }

    public static QueryParams.Builder builder() {
        return new Builder(new QueryParams());
    }

    public static class Builder {

        private final QueryParams paremeters;

        public Builder(QueryParams params) {
            this.paremeters = params;
        }

        public Builder addParameter(String name, Object value) {
           paremeters.paramsMap.put(name, value);
           return this;
        }

        public QueryParams build()
        {
            return paremeters;
        }

    }

}
