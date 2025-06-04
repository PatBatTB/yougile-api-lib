package io.github.patbattb.yougileapilib.service;

import io.github.patbattb.yougileapilib.domain.AuthCompany;
import io.github.patbattb.yougileapilib.domain.PagingContainer;
import io.github.patbattb.yougileapilib.domain.QueryParams;
import io.github.patbattb.yougileapilib.domain.body.AuthCompanyBody;
import io.github.patbattb.yougileapilib.http.ResponseHandlerProvider;
import lombok.NonNull;
import org.apache.http.client.fluent.Content;
import org.apache.http.client.fluent.Response;

import java.io.IOException;
import java.net.URISyntaxException;
import java.util.List;


public class AuthCompanyService extends AbstractRequestService{

    public AuthCompanyService() {
        super("auth/companies");
    }

    /**
     * @param body {@link AuthCompanyBody} Request body.
     * @param params {@link QueryParams} Request parameters<p>
     *                                   Available parameter names:<ul>
     *                                   <li>{@code limit} - number
     *                                   <li>{@code offset} - number</ul>
     *
     * @return {@link List} of {@link AuthCompany}
     * @throws URISyntaxException
     * @throws IOException
     */
    public PagingContainer<AuthCompany> getAuthCompanyList(@NonNull QueryParams params, @NonNull AuthCompanyBody body) throws URISyntaxException, IOException {
        Response response = sendPostRequest(configureURI(params).build(), body);
        Content content = response.handleResponse(ResponseHandlerProvider::okJsonHandler);
        return ContentHandler.handleAuthCompanyList(content);
    }

    /**
     * @param body {@link AuthCompanyBody} Request body.
     * @return {@link List} of {@link AuthCompany}
     * @throws URISyntaxException
     * @throws IOException
     */
    public PagingContainer<AuthCompany> getAuthCompanyList(@NonNull AuthCompanyBody body) throws URISyntaxException, IOException {
        return getAuthCompanyList(QueryParams.empty(), body);
    }
}
