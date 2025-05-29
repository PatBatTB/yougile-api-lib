package io.github.patbattb.yougileapilib.service;

import io.github.patbattb.yougileapilib.domain.AuthKey;
import io.github.patbattb.yougileapilib.domain.Company;
import io.github.patbattb.yougileapilib.domain.Id;
import io.github.patbattb.yougileapilib.domain.body.EditCompanyBody;
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
public class CompanyService extends AbstractRequestService {

    //TODO временно  добавил /id  к эндпоинту. На самом деле вместо id можно подставить любое значение.
    // Жду ответа от техподдержки по поводу работы эндпоинта
    public CompanyService(AuthKey authKey) {
        super("companies/id", authKey);
    }

    public CompanyService() {
        this(null);
    }

    public Company getCompany(AuthKey authKey) throws URISyntaxException, IOException {
        Response response = sendGetRequest(configureURI().build(), authKey);
        Content content = response.handleResponse(ResponseHandlerProvider::OKJsonHandler);
        return ContentHandler.handleCompany(content);
    }

    public Company getCompany() throws URISyntaxException, IOException {
        if (authKey == null) {
            throw new NullPointerException(noAuthKeyMessage);
        }
        return getCompany(authKey);
    }

    public Id editCompany(@NonNull EditCompanyBody body, AuthKey authKey) throws URISyntaxException, IOException {
        Response response = sendPutRequest(configureURI().build(), body, authKey);
        Content content = response.handleResponse(ResponseHandlerProvider::OKJsonHandler);
        return ContentHandler.handleId(content);
    }

    public Id editCompany(@NonNull EditCompanyBody body) throws URISyntaxException, IOException {
        if (authKey == null) {
            throw new NullPointerException(noAuthKeyMessage);
        }
        return editCompany(body, authKey);
    }
}
