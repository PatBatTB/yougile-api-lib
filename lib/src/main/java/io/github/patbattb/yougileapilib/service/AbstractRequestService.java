package io.github.patbattb.yougileapilib.service;

import com.fasterxml.jackson.databind.json.JsonMapper;
import io.github.patbattb.yougileapilib.domain.AuthKey;
import io.github.patbattb.yougileapilib.domain.QueryParams;
import io.github.patbattb.yougileapilib.domain.body.RequestBody;
import lombok.NonNull;
import lombok.Setter;
import org.apache.http.HttpHeaders;
import org.apache.http.NameValuePair;
import org.apache.http.client.fluent.Request;
import org.apache.http.client.fluent.Response;
import org.apache.http.client.utils.URIBuilder;
import org.apache.http.entity.ContentType;
import org.apache.http.message.BasicHeader;
import org.apache.http.message.BasicNameValuePair;

import java.io.IOException;
import java.net.URI;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * This abstract class contains base parameters and base implementation for send requests.
 */
abstract class AbstractRequestService {

    private final String scheme = "https";
    private final String host = "ru.yougile.com";
    private final String apiPath = "api-v2";
    private final String endpoint;
    @Setter
    private int timeout = 10000;

    /**
     * The key with the yougile token.
     */
    protected final AuthKey authKey;

    /**
     * Standard message if the authKey doesn't specify on service's field or method's arguments.
     */
    protected final String noAuthKeyMessage = "\"Service doesn't have AuthKey. You need Service instance with AuthKey\"";

    /**
     * Constructor without Authkey. When this constructor uses, authKey must be passed to each method directly.
     * Service already has scheme, host and apiPath. You need to pass only endpoint part of the URL.
     * For example: for URL {@code https://ru.yougile.com/api-v2/departments} you need to pass only "departments" to the constructor.
     * @param endpoint endpoint of the REST API
     */
    protected AbstractRequestService(String endpoint) {
        this(endpoint, null);
    }

    /**
     * Constructor with Authkey. You can use this key as default to avoid to pass it to each method directly.
     * Service already has scheme, host and apiPath. You need to pass only endpoint part of the URL.
     * For example: for URL {@code https://ru.yougile.com/api-v2/departments} you need to pass only "departments" to the constructor.
     * @param endpoint endpoint of the REST API
     */
    protected AbstractRequestService(String endpoint, AuthKey authKey) {
        this.endpoint = endpoint;
        this.authKey = authKey;
    }

    /**
     * The method performs base configuration for the URL.
     * It adds default scheme, host, apiPath and <u>endpointPath</u> (passed on constructor) to the {@link URIBuilder}
     * and sets charset - UTF-8.
     * The method can be used for simple requests without path parameters and query parameters.
     * For methods with path parameters use overloaded method {@link AbstractRequestService#configureURI(String)}.
     * For methods with query parameters use overloaded method {@link AbstractRequestService#configureURI(QueryParams)}.
     * @return performed URIBuilder.
     */
    protected URIBuilder configureURI() {
        String path = String.join("/", apiPath, endpoint);
            return new URIBuilder()
                    .setScheme(scheme)
                    .setHost(host)
                    .setPath(path)
                    .setCharset(StandardCharsets.UTF_8);
    }

    /**
     * The method performs base configuration for the URL with path parameters.
     * It adds default scheme, host, apiPath and <u>endpointPath</u> (passed on constructor) to the {@link URIBuilder}
     * and sets charset - UTF-8.
     * The method can be used for prepare URL with path parameters. It adds {@param pathParam} to the end of the URL.
     * You can use this method if you need to prepare URL with entity ID passed in URL string.
     * For methods without path parameters or query parameters use overloaded method {@link AbstractRequestService#configureURI()}.
     * For methods with query parameters use overloaded method {@link AbstractRequestService#configureURI(QueryParams)}.
     * @param pathParam the string to be added as a path parameter
     * @return performed URIBuilder.
     */
    protected URIBuilder configureURI(@NonNull String pathParam) {
        String path = configureURI().getPath();
        return configureURI().setPath(String.join("/", path, pathParam));
    }

    /**
     * The method performs base configuration for the URL with query parameters.
     * It adds default scheme, host, apiPath and <u>endpointPath</u> (passed on constructor) to the {@link URIBuilder}
     * and sets charset - UTF-8.
     * The method can be used for prepare URL with query parameters.
     * For methods without path parameters or query parameters use overloaded method {@link AbstractRequestService#configureURI()}.
     * For methods with path parameters use overloaded method {@link AbstractRequestService#configureURI(String)}.
     * @param params kae-value based object {@link QueryParams} contained param names and values for them.
     * @return performed URIBuilder.
     */
    protected URIBuilder configureURI(@NonNull  QueryParams params) {
        List<NameValuePair> parameters = new ArrayList<>();
        for (Map.Entry<String, Object> entry: params.getParams().entrySet()) {
            parameters.add(new BasicNameValuePair(entry.getKey(), entry.getValue().toString()));
        }
        return configureURI().addParameters(parameters);
    }

    /**
     * Executes GET request with the base configuration:
     * <ul>
     * <li>default timeout = 10s.
     * <li>with header: "ContentType":"application/json".
     * </ul>
     * @param uri URI to execute GET request.
     * @return response from server.
     */
    protected Response sendGetRequest(@NonNull URI uri) throws IOException {
        Request request = generateBaseRequest(
                Request.Get(uri));
        return request.execute();
    }

    /**
     * Executes GET request with the base configuration:
     * <ul>
     * <li>default timeout = 10s.
     * <li>with header: "ContentType":"application/json".
     * <li>with header: "Authorization": "Bearer {@literal <token_key>}".
     * </ul>
     * @param uri URI to execute GET request.
     * @param authKey yougile key.
     * @return response from server.
     */
    protected Response sendGetRequest(@NonNull URI uri, @NonNull AuthKey authKey) throws IOException {
        Request request = Request.Get(uri)
                .addHeader(getAuthHeader(authKey));
        return request.execute();
    }

    /**
     * Executes POST request with the base configuration:
     * <ul>
     * <li>default timeout = 10s.
     * <li>with header: "ContentType":"application/json".
     * <li>and the serialized body as json.
     * </ul>
     * @param uri URI to execute POST request.
     * @param body body object for serializing to json.
     * @return response from server.
     */
    protected Response sendPostRequest(@NonNull URI uri, @NonNull RequestBody body) throws IOException {
        //TODO json-annotation warnings occur. To avoid this, you need to connect the jenkins-annotations dependency to your app
        String bodyString = new JsonMapper().writeValueAsString(body);
        Request request = generateBaseRequest(Request.Post(uri))
                .bodyString(bodyString, ContentType.APPLICATION_JSON);
        return request.execute();
    }

    /**
     * Executes POST request with the base configuration:
     * <ul>
     * <li>default timeout = 10s.
     * <li>with header: "ContentType":"application/json".
     * <li>with header: "Authorization": "Bearer {@literal <token_key>}".
     * <li>and the serialized body as json.
     * </ul>
     * @param uri URI to execute POST request.
     * @param body body object for serializing to json.
     * @param authKey yougile key.
     * @return response from server.
     */
    protected Response sendPostRequest(@NonNull URI uri, @NonNull RequestBody body, @NonNull AuthKey authKey) throws IOException {
        String bodyString = new JsonMapper().writeValueAsString(body);
        Request request = generateBaseRequest(Request.Post(uri))
                .bodyString(bodyString, ContentType.APPLICATION_JSON)
                .addHeader(getAuthHeader(authKey));
        return  request.execute();
    }

    /**
     * Executes PUT request with the base configuration:
     * <ul>
     * <li>default timeout = 10s.
     * <li>with header: "ContentType":"application/json".
     * <li>with header: "Authorization": "Bearer {@literal <token_key>}".
     * <li>and the serialized body as json.
     * </ul>
     * @param uri URI to execute PUT request.
     * @param body body object for serializing to json.
     * @param authKey yougile key.
     * @return response from server.
     */
    protected Response sendPutRequest(@NonNull URI uri, @NonNull RequestBody body, @NonNull AuthKey authKey) throws IOException {
        String bodyString = new JsonMapper().writeValueAsString(body);
        Request request = generateBaseRequest(Request.Put(uri))
                .bodyString(bodyString, ContentType.APPLICATION_JSON)
                .addHeader(getAuthHeader(authKey));
        return request.execute();
    }

    /**
     * Executes DELETE request with the base configuration:
     * <ul>
     * <li>default timeout = 10s.
     * <li>with header: "ContentType":"application/json".
     * </ul>
     * @param uri URI to execute DELETE request.
     * @return response from server.
     */
    protected Response sendDeleteRequest(@NonNull URI uri) throws IOException {
        Request request = generateBaseRequest(Request.Delete(uri));
        return request.execute();
    }

    /**
     * Executes DELETE request with the base configuration:
     * <ul>
     * <li>default timeout = 10s.
     * <li>with header: "ContentType":"application/json".
     * <li>with header: "Authorization": "Bearer {@literal <token_key>}".
     * </ul>
     * @param uri URI to execute DELETE request.
     * @return response from server.
     */
    protected Response sendDeleteRequest(@NonNull URI uri, @NonNull AuthKey authKey) throws IOException {
        Request request = generateBaseRequest(Request.Delete(uri))
                .addHeader(getAuthHeader(authKey));
        return request.execute();
    }

    private Request generateBaseRequest(@NonNull Request request) {
        return request.connectTimeout(timeout)
                .socketTimeout(timeout)
                .addHeader(new BasicHeader(HttpHeaders.CONTENT_TYPE, "application/json"));
    }

    private BasicHeader getAuthHeader(@NonNull AuthKey authKey) {
        return new BasicHeader(HttpHeaders.AUTHORIZATION, "Bearer " + authKey.key());
    }
}
