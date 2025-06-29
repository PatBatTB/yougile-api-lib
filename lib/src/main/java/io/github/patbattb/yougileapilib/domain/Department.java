package io.github.patbattb.yougileapilib.domain;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import io.github.patbattb.yougileapilib.http.deserialize.DepartmentDeserializer;
import lombok.*;
import lombok.experimental.FieldDefaults;

import java.util.List;

/**
 * Department of the {@link Company}
 * It contains list of {@link DepartmentUser}.
 * Department may be part of other Department.
 * In this case the ID of the parent department must be indicated in the {@link Department#parentId} field.
 */
@Getter
@FieldDefaults(level = AccessLevel.PRIVATE)
@AllArgsConstructor
@EqualsAndHashCode
@ToString
@JsonDeserialize(using = DepartmentDeserializer.class)
public class Department {
    /**
     * If true that the department has been deleted.
     */
    @Setter
    boolean deleted;
    /**
     * Department ID.
     */
    String id;
    /**
     * Department title.
     */
    @Setter
    String title;
    /**
     * ID of the parent department.
     * Must be {@code null} or equals "-", if that top-leveled department.
     */
    @Setter
    String parentId;
    /**
     * List of {@link DepartmentUser}.
     * Users in the department and their roles.
     */
    @Setter
    List<DepartmentUser> users;
}
