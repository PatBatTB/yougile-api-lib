## Overview
The "yougile-api-lib" library is used to interact with the REST API of the [YouGile](https://yougile.com) platform.

## Usage

All requests are sent through service instances from the `io.github.patbattb.yougileapilib.service` package.
Services may require query parameters or a specific body-class from the `io.github.patbattb.yougileapilib.domain.body` 
package in arguments to serialize it into the request body.
The body classes for the configuration have internal builder classes. 
Builders accept required arguments during initialization. Optional parameters can be added using class methods.
___
- Get the ID of the company you want to manage using the REST API 
(you need a username and password from your account in YouGile).
```java
AuthCompanyService acs = new AuthCompanyService();
AuthCompanyBody body = AuthCompanyBody.builder("email", "password").build();
PagingContainer<AuthCompany> authCompanyList = acs.getAuthCompanyList(QueryParams.empty(), body);
```
In variable `authCompanyList` will be the companies available for managing.

You can also use [web-form](https://ru.yougile.com/api-v2#/operations/getCompanies) for getting this list.
___

- Create an API key (you need a username and password for your YouGile account and a company ID).
```java
AuthKeyService aks = new AuthKeyService();
AuthKeyBody keyBody = AuthKeyBody.builder("login", "password", "companyID").build();
AuthKey authKey = aks.createAuthKey(keyBody);
```

You can also use [web-form](https://en.yougile.com/api-v2#/operations/AuthKeyController_create) for getting it.


After receiving the key, you can use other services to interact with the platform. 
For example, update the name of one of the projects:
```java
ProjectService ps = new ProjectService(authKey);
Project project = ps.getProjectById("projectId");
project.setTitle("NewProjectTitle");
ps.updateProject(project);
```

## Changelog
Can be found in [CHANGELOG](CHANGELOG.md).

## Authors
* Patrick Bates - [PatBatTB](https://github.com/PatBatTB)

## Code of Conduct
Please, follow [Code of Conduct](CODE_OF_CONDUCT.md) page.

## License
This project is MIT License - see the [LICENSE](LICENSE) file for details
