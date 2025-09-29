package io.github.patbattb.yougileapilib.domain;

import lombok.*;
import lombok.experimental.FieldDefaults;

import java.util.List;

/**
 * This container contains a list of the entities and the pagination information of the YouGile service response.
 * @param <T> the type of elements in this container.
 */
@Getter
@FieldDefaults(level = AccessLevel.PRIVATE)
@AllArgsConstructor
@EqualsAndHashCode
@ToString
public class PagingContainer<T> {

    /**
     * The number of elements in the result.
     */
    int count;
    /**
     * The number of elements per page.
     */
    int limit;
    /**
     * Index of the first element.
     */
    int offset;
    /**
     * Are there any elements after this page?
     */
    boolean next;

    /**
     * List of elements.
     */
    List<T> content;
}
