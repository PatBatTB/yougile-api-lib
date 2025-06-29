package io.github.patbattb.yougileapilib.domain;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import io.github.patbattb.yougileapilib.http.deserialize.AuthKeyDetailsDeserializer;
import lombok.*;
import lombok.experimental.FieldDefaults;

/**
 * Detailed authorization key of API.
 */
@Getter
@FieldDefaults(level = AccessLevel.PRIVATE)
@AllArgsConstructor
@EqualsAndHashCode
@ToString
@JsonDeserialize(using = AuthKeyDetailsDeserializer.class)
public class AuthKeyDetails {
    /**
     * Authorization key.
     */
    String key;
    /**
     * Company ID.
     */
    String companyId;
    /**
     * Creation time.
     */
    long created;
    /**
     * The key is deleted - yes/no
     */
    boolean deleted;
}
