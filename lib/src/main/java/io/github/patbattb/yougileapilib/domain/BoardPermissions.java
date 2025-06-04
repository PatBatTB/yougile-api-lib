package io.github.patbattb.yougileapilib.domain;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import io.github.patbattb.yougileapilib.http.deserialize.BoardPermissionsDeserializer;
import lombok.*;
import lombok.experimental.FieldDefaults;

@Getter
@Setter
@FieldDefaults(level = AccessLevel.PRIVATE)
@AllArgsConstructor
@EqualsAndHashCode
@ToString
@JsonDeserialize(using = BoardPermissionsDeserializer.class)
@JsonInclude(JsonInclude.Include.NON_EMPTY)
public class BoardPermissions {
    boolean editTitle;
    boolean delete;
    boolean move;
    boolean showStickers;
    boolean editStickers;
    boolean addColumn;
    @NonNull
    @JsonProperty("columns")
    ColumnPermissions columnPermissions;
    boolean settings;
}
