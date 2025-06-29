package io.github.patbattb.yougileapilib.domain;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import io.github.patbattb.yougileapilib.http.deserialize.CompanyDeserializer;
import lombok.*;
import lombok.experimental.FieldDefaults;

/**
 * The company that contained  {@link Project}
 */
@Getter
@FieldDefaults(level = AccessLevel.PRIVATE)
@AllArgsConstructor
@EqualsAndHashCode
@ToString
@JsonDeserialize(using = CompanyDeserializer.class)
public class Company {
    /**
     * If true, then the company has been deleted.
     */
    @Setter
    boolean deleted;
    /**
     * Company ID.
     */
    String id;
    /**
     * Company title.
     */
    @Setter
    String title;
    /**
     * Company creation time
     */
    long created;
}
