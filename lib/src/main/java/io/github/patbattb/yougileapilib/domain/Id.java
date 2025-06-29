package io.github.patbattb.yougileapilib.domain;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import io.github.patbattb.yougileapilib.http.deserialize.IdDeserializer;

/**
 * Record represents an ID of any entity.
 * This may be the ID of {@link Company}, {@link Task} or others...
 * This entity often returned by service's create, edit, delete method that the success confirmation.
 * @param id ID value of any entity.
 */
@JsonDeserialize(using = IdDeserializer.class)
public record Id(String id) {
}
