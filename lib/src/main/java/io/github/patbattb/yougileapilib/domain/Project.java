package io.github.patbattb.yougileapilib.domain;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import io.github.patbattb.yougileapilib.http.deserialize.ProjectDeserializer;
import lombok.*;
import lombok.experimental.FieldDefaults;

import java.util.List;

@Getter
@FieldDefaults(level = AccessLevel.PRIVATE)
@AllArgsConstructor
@EqualsAndHashCode
@ToString
@JsonDeserialize(using = ProjectDeserializer.class)
//TODO провести ручной тест сериализации и десериализации users
public class Project {
    @Setter
    boolean deleted;
    String id;
    @Setter
    String title;
    long created;
    @Setter
    List<ProjectUser> users;
}
