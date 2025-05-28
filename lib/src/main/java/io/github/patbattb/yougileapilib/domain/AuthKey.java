package io.github.patbattb.yougileapilib.domain;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import io.github.patbattb.yougileapilib.http.deserialize.AuthKeyDeserializer;

@JsonDeserialize(using = AuthKeyDeserializer.class)
public record AuthKey(String key) {
}
