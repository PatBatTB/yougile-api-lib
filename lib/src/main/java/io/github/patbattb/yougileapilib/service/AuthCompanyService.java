package io.github.patbattb.yougileapilib.service;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.json.JsonMapper;
import com.fasterxml.jackson.databind.node.ArrayNode;
import io.github.patbattb.yougileapilib.domain.AuthCompany;
import io.github.patbattb.yougileapilib.domain.QueryParams;
import io.github.patbattb.yougileapilib.domain.body.AuthCompanyBody;
import io.github.patbattb.yougileapilib.http.YouGileResponseHandler;
import lombok.NonNull;
import org.apache.http.client.fluent.Content;
import org.apache.http.client.fluent.Response;

import java.io.IOException;
import java.net.URISyntaxException;
import java.util.ArrayList;
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
    public List<AuthCompany> getAuthCompanyList(@NonNull QueryParams params, @NonNull AuthCompanyBody body) throws URISyntaxException, IOException {
        Response response = sendPostRequest(configureURI(params).build(), body);
        Content content = response.handleResponse(YouGileResponseHandler::getJsonOKHandler);
        return handleContent(content);
    }

    /**
     * @param body {@link AuthCompanyBody} Request body.
     * @return {@link List} of {@link AuthCompany}
     * @throws URISyntaxException
     * @throws IOException
     */
    public List<AuthCompany> getAuthCompanyList(@NonNull AuthCompanyBody body) throws URISyntaxException, IOException {
        return getAuthCompanyList(QueryParams.empty(), body);
    }

    private List<AuthCompany> handleContent(Content content) throws JsonProcessingException {
            JsonMapper mapper = new JsonMapper();
            List<AuthCompany> authCompanyList = new ArrayList<>();
            JsonNode rootNode = mapper.readTree(content.asString());
            ArrayNode contentArrayNode = (ArrayNode) rootNode.get("content");
            for (JsonNode contentNode: contentArrayNode) {
                authCompanyList.add(mapper.readValue(contentNode.toString(), AuthCompany.class));
            }
            return authCompanyList;
    }
}
