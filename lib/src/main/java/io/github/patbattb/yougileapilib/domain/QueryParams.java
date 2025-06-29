package io.github.patbattb.yougileapilib.domain;

import java.util.HashMap;
import java.util.Map;

/**
 * An entity for composing and transmitting Query parameters in a REST request.
 */
public class QueryParams {

    private final Map<String, Object> paramsMap;

    private QueryParams() {
        paramsMap = new HashMap<>();
    }

    /**
     * Method used for getting entity without any parameters.
     * @return an empty {@link QueryParams}
     */
    public static QueryParams empty() {
        return new QueryParams();
    }

    /**
     * Getter for a query parameters {@link Map} contained the query parameter's key as {@link String} Map's key
     * and the query parameter's value as {@link Object} Map's value.
     * @return Map with query parameters.
     */
    public Map<String, Object> getParams() {
        return Map.copyOf(paramsMap);
    }

    /**
     *  Builder for construct Query Parameters. Use {@link Builder#addParameter(String, Object)} to add new parameter
     *  to container. After adding all the necessary parameters use {@link Builder#build()} to get ready-made
     *  {@link QueryParams} instance.
     * @return new Builder for build {@link QueryParams} instance.
     */
    public static QueryParams.Builder builder() {
        return new Builder(new QueryParams());
    }

    public static class Builder {

        private final QueryParams parameters;

        private Builder(QueryParams params) {
            this.parameters = params;
        }

        /**
         * Add the parameter to container.
         * @param name name of the arbitrary query parameter.
         * @param value value of the arbitrary query parameter.
         * @return self for continue building.
         */
        public Builder addParameter(String name, Object value) {
           parameters.paramsMap.put(name, value);
           return this;
        }

        /**
         * The final method for building an instance.
         * @return new instance of {@link QueryParams}.
         */
        public QueryParams build()
        {
            return parameters;
        }

    }

}
