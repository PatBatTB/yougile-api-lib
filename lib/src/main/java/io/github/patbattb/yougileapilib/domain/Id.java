package io.github.patbattb.yougileapilib.domain;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import io.github.patbattb.yougileapilib.http.deserialize.IdDeserializer;

@JsonDeserialize(using = IdDeserializer.class)
public record Id(String id) {
}
