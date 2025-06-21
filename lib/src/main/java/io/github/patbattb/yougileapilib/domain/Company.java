package io.github.patbattb.yougileapilib.domain;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import io.github.patbattb.yougileapilib.http.deserialize.CompanyDeserializer;
import lombok.*;
import lombok.experimental.FieldDefaults;

@Getter
@FieldDefaults(level = AccessLevel.PRIVATE)
@AllArgsConstructor
@EqualsAndHashCode
@ToString
@JsonDeserialize(using = CompanyDeserializer.class)
public class Company {
    @Setter
    boolean deleted;
    String id;
    @Setter
    String title;
    long created;
}
