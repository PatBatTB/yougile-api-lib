package io.github.patbattb.yougileapilib.service;

import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.Setter;
import org.apache.http.client.fluent.Request;
import org.apache.http.client.fluent.Response;
import org.apache.http.client.utils.URIBuilder;
import org.apache.http.entity.ContentType;
import org.apache.http.message.BasicHeader;

import java.io.IOException;
import java.net.URI;
import java.nio.charset.StandardCharsets;
import java.util.Map;

public abstract class AbstractRequestService {

    private final String scheme = "https";
    private final String host = "ru.yougile.com";
    private final String apiPath = "api-v2";
    private final String endpoint;
    @Setter
    private int timeout = 10000;

    protected AbstractRequestService(String endpoint) {
        this.endpoint = endpoint;
    }

    protected URIBuilder configureURI() {
        String path = String.join("/", apiPath, endpoint);
            return new URIBuilder()
                    .setScheme(scheme)
                    .setHost(host)
                    .setPath(path)
                    .setCharset(StandardCharsets.UTF_8);
    }

    protected Response sendPostRequest(Map<String, Object> bodyMap, URI uri) throws IOException {
        Request request = generateBaseRequest(Request.Post(uri))
                .bodyString(new ObjectMapper().writeValueAsString(bodyMap), ContentType.APPLICATION_JSON);
        return request.execute();
    }

    protected Response sendDeleteRequest(URI uri) throws IOException {
        Request request = generateBaseRequest(Request.Delete(uri));
        return request.execute();
    }

    private Request generateBaseRequest(Request request) {
        return request.connectTimeout(timeout)
                .socketTimeout(timeout)
                .addHeader(new BasicHeader("Content-Type", "application/json"));
    }
}
