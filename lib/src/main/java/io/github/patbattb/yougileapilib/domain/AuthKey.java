package io.github.patbattb.yougileapilib.domain;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import io.github.patbattb.yougileapilib.http.deserialize.AuthKeyDeserializer;

/**
 * The authorization key of API.
 * @param key the key value.
 */
@JsonDeserialize(using = AuthKeyDeserializer.class)
public record AuthKey(String key) {
}
