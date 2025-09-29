package io.github.patbattb.yougileapilib.domain;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import io.github.patbattb.yougileapilib.http.deserialize.PagingDataDeserializer;

/**
 * the pagination information of the YouGile service response.
 * @param count the number of elements in the result.
 * @param limit the number of elements per page.
 * @param offset index of the first element.
 * @param next are there any elements after this page.
 */
@JsonDeserialize(using = PagingDataDeserializer.class)
public record PagingData(int count, int limit, int offset, boolean next) {
}
