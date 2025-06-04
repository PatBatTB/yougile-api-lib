package io.github.patbattb.yougileapilib.domain;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import io.github.patbattb.yougileapilib.http.deserialize.ProjectRoleDeserializer;
import lombok.*;
import lombok.experimental.FieldDefaults;

@Getter
@FieldDefaults(level = AccessLevel.PRIVATE)
@AllArgsConstructor
@EqualsAndHashCode
@ToString
@JsonDeserialize(using = ProjectRoleDeserializer.class)
public class ProjectRole {
    String id;
    @Setter
    String name;
    @Setter
    String description;
    @Setter
    ProjectPermissions projectPermissions;
}
