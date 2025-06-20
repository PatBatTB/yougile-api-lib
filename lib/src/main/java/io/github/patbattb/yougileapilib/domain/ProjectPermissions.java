package io.github.patbattb.yougileapilib.domain;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import io.github.patbattb.yougileapilib.http.deserialize.ProjectPermissionsDeserializer;
import lombok.*;
import lombok.experimental.FieldDefaults;

@Getter
@Setter
@FieldDefaults(level = AccessLevel.PRIVATE)
@AllArgsConstructor
@EqualsAndHashCode
@ToString
@JsonDeserialize(using = ProjectPermissionsDeserializer.class)
@JsonInclude(JsonInclude.Include.NON_NULL)
public class ProjectPermissions {
    boolean editTitle;
    boolean delete;
    boolean addBoard;
    @NonNull
    @JsonProperty("boards")
    BoardPermissions boardPermissions;
    ProjectPermissions children; //Непонятно, что это. Может не быть в ответе.
}
