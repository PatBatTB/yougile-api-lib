package io.github.patbattb.yougileapilib.service;

import com.fasterxml.jackson.core.JsonProcessingException;
import io.github.patbattb.yougileapilib.domain.Id;
import io.github.patbattb.yougileapilib.http.deserialize.AbstractDeserializerTest;
import org.apache.http.client.fluent.Content;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Collections;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

class ContentHandlerTest extends AbstractDeserializerTest {

    static Content content;

    @BeforeEach
    void setUp() {
        content = mock(Content.class);
    }

    @Test
    @DisplayName("handleResult returns true")
    void handleResultTrue() throws JsonProcessingException {
        String jsonString = """
                {
                    "result": "ok"
                }
                """;
        when(content.toString()).thenReturn(jsonString);
        assertThat(ContentHandler.handleResult(content)).isEqualTo(true);
    }

    @Test
    @DisplayName("handleResult returns false")
    void handleResultFalse() throws JsonProcessingException {
        String jsonString = """
                {
                    "result": "randomValue"
                }
                """;
        when(content.toString()).thenReturn(jsonString);
        assertThat(ContentHandler.handleResult(content)).isEqualTo(false);
    }

    @Test
    @DisplayName("handleIdList() returns valid IdList")
    void handleIdListValid() throws JsonProcessingException {
        String keyOne = "idKey1";
        String keyTwo = "idKey2";
        String jsonString = String.format("""
                [
                    "%s",
                    "%s"
                ]
                """, keyOne, keyTwo);
        when(content.toString()).thenReturn(jsonString);
        var idList = ContentHandler.handleIdList(content);
        assertThat(idList).isInstanceOf(List.class);
        assertThat(idList).contains(new Id(keyOne), new Id(keyTwo));
    }

    @Test
    @DisplayName("handleIdList() returns null when json string is empty")
    void handleIdList() throws JsonProcessingException {
        String jsonString = "";
        when(content.toString()).thenReturn(jsonString);
        assertThat(ContentHandler.handleIdList(content)).isEqualTo(Collections.EMPTY_LIST);
    }
}