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

/**
 * Service for managing of companies in the authorization section.
 */
public class AuthCompanyService extends AbstractRequestService{

    public AuthCompanyService() {
        super("auth/companies");
    }

    /**
     * The request gets container with {@link AuthCompany} list.
     * @param body {@link AuthCompanyBody} Request body.
     * @param params {@link QueryParams} Request parameters<p>
     *                                   Available parameter names:<ul>
     *                                   <li>{@code limit} - number - The number of items you want to receive. Maximum 1000.
     *                                   <li>{@code offset} - number - The index of the first element.
     *                                   </ul>
     *
     * @return the list of {@link AuthCompany}
     * @throws IOException then the json cannot be parsed correctly
     */
    public PagingContainer<AuthCompany> getAuthCompanyList(@NonNull QueryParams params, @NonNull AuthCompanyBody body) throws URISyntaxException, IOException {
        Response response = sendPostRequest(configureURI(params).build(), body);
        Content content = response.handleResponse(ResponseHandlerProvider::okJsonHandler);
        return ContentHandler.handleAuthCompanyList(content);
    }
}
