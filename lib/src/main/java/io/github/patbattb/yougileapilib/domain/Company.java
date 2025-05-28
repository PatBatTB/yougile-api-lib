package io.github.patbattb.yougileapilib.domain;

import lombok.*;
import lombok.experimental.FieldDefaults;

@Getter
@FieldDefaults(level = AccessLevel.PRIVATE)
@AllArgsConstructor
@EqualsAndHashCode
@ToString
public class Company {
    @Setter
    boolean deleted;
    String id;
    @Setter
    String title;
    long created; //timestamp
    //@Setter
    //Object apiData;
}
