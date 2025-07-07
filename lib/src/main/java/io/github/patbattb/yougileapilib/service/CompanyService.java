package io.github.patbattb.yougileapilib.service;

import io.github.patbattb.yougileapilib.domain.AuthKey;
import io.github.patbattb.yougileapilib.domain.Company;
import io.github.patbattb.yougileapilib.domain.Id;
import io.github.patbattb.yougileapilib.domain.body.CompanyUpdateBody;
import io.github.patbattb.yougileapilib.http.ResponseHandlerProvider;
import lombok.NonNull;
import org.apache.http.client.fluent.Content;
import org.apache.http.client.fluent.Response;

import java.io.IOException;
import java.net.URISyntaxException;

/*
ERROR on this endpoint
https://ru.yougile.com/api-v2#/operations/CompanyController_get
1) endpoint в документации указан /api-v2/companies/{id}
Но в PathParams не обязательно указывать ИД компании.
Вместо {id} можно подставить что угодно.
Пробовал отправлять GET на companies/id и companies/hello_world - возвращается ОК и компания, для которой создан токен.
При этом, если кинуть GET на /api-v2/companies/ - возвращается 404
2) Поле apiData в ответе указано как required, но в ответе его нет.
Вот пример ответа:
200 OK
{
  "title": "PatBatTB",
  "timestamp": 1743340117657,
  "id": "f2c0360a-ed75-4e8e-910a-36b0d664a5b8"
}
 */

/**
 * The service for managing of companies.
 */
public class CompanyService extends AbstractRequestService {

    //TODO temporarily added “/id” to the endpoint. You can actually substitute any value instead of id.
    //I am waiting for a reply from tech support on how this endpoint works

    /**
     * If the service constructs with {@link AuthKey}, you can use methods without key in parameters.
     * The passed key in constructor will be used by default.
     * If you want to send request with separate key, but without new service creating,
     * you can also use methods with {@link AuthKey} in parameters.
     * @param authKey yougile key for using by default in the Service instance.
     */
    public CompanyService(AuthKey authKey) {
        super("companies/id", authKey);
    }

    /**
     * If the service constructs without {@link AuthKey}, key must be passed to each method as argument.
     */
    public CompanyService() {
        this(null);
    }

    /**
     * The request gets {@link Company} for which the key was created.
     * @param authKey yougile key.
     * @return company.
     * @throws IOException then the json cannot be parsed correctly
     */
    public Company getCompany(AuthKey authKey) throws URISyntaxException, IOException {
        Response response = sendGetRequest(configureURI().build(), authKey);
        Content content = response.handleResponse(ResponseHandlerProvider::okJsonHandler);
        return ContentHandler.handleCompany(content);
    }

    /**
     * The request gets {@link Company} for which the key was created.
     * The passed key in constructor will be used by default.
     * @return company.
     * @throws IOException then the json cannot be parsed correctly
     */
    public Company getCompany() throws URISyntaxException, IOException {
        if (authKey == null) {
            throw new NullPointerException(noAuthKeyMessage);
        }
        return getCompany(authKey);
    }

    /**
     * The request updates the company. Company ID doesn't need to be passed.
     * Updates the company for witch the passed key was created.
     * @param body update body.
     * @param authKey yougile key.
     * @return ID of the updated company.
     * @throws IOException then the json cannot be parsed correctly
     */
    public Id updateCompany(@NonNull CompanyUpdateBody body, @NonNull AuthKey authKey) throws URISyntaxException, IOException {
        Response response = sendPutRequest(configureURI().build(), body, authKey);
        Content content = response.handleResponse(ResponseHandlerProvider::okJsonHandler);
        return ContentHandler.handleId(content);
    }

    /**
     * The request updates the company. Company ID doesn't need to be passed.
     * Updates the company for witch the passed key was created.
     * The passed key in constructor will be used by default.
     * @param body update body.
     * @return ID of the updated company.
     * @throws IOException then the json cannot be parsed correctly
     */
    public Id updateCompany(@NonNull CompanyUpdateBody body) throws URISyntaxException, IOException {
        if (authKey == null) {
            throw new NullPointerException(noAuthKeyMessage);
        }
        return updateCompany(body, authKey);
    }

    /**
     * The request updates the company.
     * Updates the company's deleted flag and title for company for witch the passed key was created.
     * @param company update body.
     * @param authKey yougile key.
     * @return ID of the updated company.
     * @throws IOException then the json cannot be parsed correctly
     */
    public Id updateCompany(@NonNull Company company, @NonNull AuthKey authKey) throws URISyntaxException, IOException {
        CompanyUpdateBody body = CompanyUpdateBody.builder()
                .deleted(company.isDeleted())
                .title(company.getTitle())
                .build();
        return updateCompany(body, authKey);
    }

    /**
     * The request updates the company.
     * Updates the company's deleted flag and title for company for witch the passed key was created.
     * The passed key in constructor will be used by default.
     * @param company update body.
     * @return ID of the updated company.
     * @throws IOException then the json cannot be parsed correctly
     */
    public Id updateCompany(@NonNull Company company) throws URISyntaxException, IOException {
        if (authKey == null) {
            throw new NullPointerException(noAuthKeyMessage);
        }
        return updateCompany(company, authKey);
    }
}
