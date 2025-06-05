package io.github.patbattb.yougileapilib.domain;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import io.github.patbattb.yougileapilib.http.deserialize.DepartmentDeserializer;
import lombok.*;
import lombok.experimental.FieldDefaults;

import java.util.List;

@Getter
@FieldDefaults(level = AccessLevel.PRIVATE)
@AllArgsConstructor
@EqualsAndHashCode
@ToString
@JsonDeserialize(using = DepartmentDeserializer.class)
public class Department {
    @Setter
    boolean deleted;
    String id;
    @Setter
    String title;
    @Setter
    String parentId;
    @Setter
    List<UserRole> users;
}
