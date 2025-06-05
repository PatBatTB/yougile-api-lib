package io.github.patbattb.yougileapilib.domain;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import io.github.patbattb.yougileapilib.http.deserialize.PagingDataDeserializer;

@JsonDeserialize(using = PagingDataDeserializer.class)
public record PagingData(int count, int limit, int offset, boolean next) {
}
