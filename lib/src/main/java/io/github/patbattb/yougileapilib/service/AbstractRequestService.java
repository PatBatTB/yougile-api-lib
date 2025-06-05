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

abstract class AbstractRequestService {

    private final String scheme = "https";
    private final String host = "ru.yougile.com";
    private final String apiPath = "api-v2";
    private final String endpoint;
    @Setter
    private int timeout = 10000;

    protected final AuthKey authKey;

    protected final String noAuthKeyMessage = "\"Service doesn't have AuthKey. You need Service instance with AuthKey\"";

    protected AbstractRequestService(String endpoint) {
        this(endpoint, null);
    }

    protected AbstractRequestService(String endpoint, AuthKey authKey) {
        this.endpoint = endpoint;
        this.authKey = authKey;
    }

    protected URIBuilder configureURI() {
        String path = String.join("/", apiPath, endpoint);
            return new URIBuilder()
                    .setScheme(scheme)
                    .setHost(host)
                    .setPath(path)
                    .setCharset(StandardCharsets.UTF_8);
    }

    protected URIBuilder configureURI(@NonNull String pathParam) {
        String path = configureURI().getPath();
        return configureURI().setPath(String.join("/", path, pathParam));
    }

    protected URIBuilder configureURI(@NonNull  QueryParams params) {
        List<NameValuePair> parameters = new ArrayList<>();
        for (Map.Entry<String, Object> entry: params.getParams().entrySet()) {
            parameters.add(new BasicNameValuePair(entry.getKey(), entry.getValue().toString()));
        }
        return configureURI().addParameters(parameters);
    }

    protected Response sendGetRequest(@NonNull URI uri) throws IOException {
        Request request = generateBaseRequest(
                Request.Get(uri));
        return request.execute();
    }
    protected Response sendGetRequest(@NonNull URI uri, @NonNull AuthKey authKey) throws IOException {
        Request request = Request.Get(uri)
                .addHeader(getAuthHeader(authKey));
        return request.execute();
    }

    protected Response sendPostRequest(@NonNull URI uri, @NonNull RequestBody body) throws IOException {
        //TODO json-annotation warnings occur. To avoid this, you need to connect the jenkins-annotations dependency to your app
        String bodyString = new JsonMapper().writeValueAsString(body);
        Request request = generateBaseRequest(Request.Post(uri))
                .bodyString(bodyString, ContentType.APPLICATION_JSON);
        return request.execute();
    }

    protected Response sendPostRequest(@NonNull URI uri, @NonNull RequestBody body, @NonNull AuthKey authKey) throws IOException {
        String bodyString = new JsonMapper().writeValueAsString(body);
        Request request = generateBaseRequest(Request.Post(uri))
                .bodyString(bodyString, ContentType.APPLICATION_JSON)
                .addHeader(getAuthHeader(authKey));
        return  request.execute();
    }

    protected Response sendPutRequest(@NonNull URI uri, @NonNull RequestBody body, @NonNull AuthKey authKey) throws IOException {
        String bodyString = new JsonMapper().writeValueAsString(body);
        Request request = generateBaseRequest(Request.Put(uri))
                .bodyString(bodyString, ContentType.APPLICATION_JSON)
                .addHeader(getAuthHeader(authKey));
        return request.execute();
    }

    protected Response sendDeleteRequest(@NonNull URI uri) throws IOException {
        Request request = generateBaseRequest(Request.Delete(uri));
        return request.execute();
    }

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
