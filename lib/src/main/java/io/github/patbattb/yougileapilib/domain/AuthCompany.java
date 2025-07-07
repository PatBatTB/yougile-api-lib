package io.github.patbattb.yougileapilib.domain;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import io.github.patbattb.yougileapilib.http.deserialize.AuthCompanyDeserializer;
import io.github.patbattb.yougileapilib.service.AuthCompanyService;
import lombok.*;
import lombok.experimental.FieldDefaults;

/**
 * The company that is available for authorization via the API.
 * It can be requested via the {@link AuthCompanyService} using the username and password
 * of the user on YouGile.
 */
@Getter
@FieldDefaults(level = AccessLevel.PRIVATE)
@AllArgsConstructor
@EqualsAndHashCode
@ToString
@JsonDeserialize(using = AuthCompanyDeserializer.class)
public class AuthCompany {
    /**
     * Object ID.
     */
    String id;
    /**
     * Company name.
     */
    String name;
    /**
     * Administrative rights in the company.
     */
    boolean isAdmin;
}
