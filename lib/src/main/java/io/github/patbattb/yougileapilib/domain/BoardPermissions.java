package io.github.patbattb.yougileapilib.domain;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import io.github.patbattb.yougileapilib.http.deserialize.BoardPermissionsDeserializer;
import lombok.*;
import lombok.experimental.FieldDefaults;

/**
 * Permissions available on the {@link Board}
 * It contains {@link ColumnPermissions}.
 * It's part of {@link ProjectPermissions}.
 */
@Getter
@Setter
@FieldDefaults(level = AccessLevel.PRIVATE)
@AllArgsConstructor
@EqualsAndHashCode
@ToString
@JsonDeserialize(using = BoardPermissionsDeserializer.class)
@JsonInclude(JsonInclude.Include.NON_NULL)
public class BoardPermissions {
    /**
     * Can the board title be changed?
     */
    boolean editTitle;
    /**
     * Can the board be deleted?
     */
    boolean delete;
    /**
     * Can the board be moved?
     */
    boolean move;
    /**
     * Displaying the sticker panel.
     */
    boolean showStickers;
    /**
     * Can the board stickers be edited?
     */
    boolean editStickers;
    /**
     * Can the column be added on the board?
     */
    boolean addColumn;
    /**
     * Permissions of columns.
     */
    @NonNull
    @JsonProperty("columns")
    ColumnPermissions columnPermissions;
    /**
     * Can manage the basic board settings?
     */
    boolean settings;
}
