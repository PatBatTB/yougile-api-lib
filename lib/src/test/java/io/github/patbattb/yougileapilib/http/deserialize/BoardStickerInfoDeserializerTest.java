package io.github.patbattb.yougileapilib.http.deserialize;

import com.fasterxml.jackson.core.JsonProcessingException;
import io.github.patbattb.yougileapilib.domain.BoardStickerInfo;
import io.github.patbattb.yougileapilib.domain.CustomSticker;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatCollection;

class BoardStickerInfoDeserializerTest extends AbstractDeserializerTest {

    @Test
    @DisplayName("Deserialize without fields")
    void deserialize() throws JsonProcessingException {
        String jsonString = "{}";
        BoardStickerInfo boardStickerInfo = mapper.readValue(jsonString, BoardStickerInfo.class);
    }

    @Test
    @DisplayName("Deserialize timer field")
    void deserializeTimer() throws JsonProcessingException {
        String fieldName = "timer";
        boolean fieldValue = true;
        BoardStickerInfo boardStickerInfo = getBoardStickerInfo(fieldName, fieldValue);
        assertThat(boardStickerInfo.isTimer()).isEqualTo(fieldValue);
    }

    @Test
    @DisplayName("Deserialize deadline field")
    void deserializeDeadline() throws JsonProcessingException {
        String fieldName = "deadline";
        boolean fieldValue = true;
        BoardStickerInfo boardStickerInfo = getBoardStickerInfo(fieldName, fieldValue);
        assertThat(boardStickerInfo.isDeadline()).isEqualTo(fieldValue);
    }

    @Test
    @DisplayName("Deserialize stopwatch field")
    void deserializeStopwatch() throws JsonProcessingException {
        String fieldName = "stopwatch";
        boolean fieldValue = true;
        BoardStickerInfo boardStickerInfo = getBoardStickerInfo(fieldName, fieldValue);
        assertThat(boardStickerInfo.isStopwatch()).isEqualTo(fieldValue);
    }

    @Test
    @DisplayName("Deserialize timeTracking field")
    void deserializeTimeTracking() throws JsonProcessingException {
        String fieldName = "timeTracking";
        boolean fieldValue = true;
        BoardStickerInfo boardStickerInfo = getBoardStickerInfo(fieldName, fieldValue);
        assertThat(boardStickerInfo.isTimeTracking()).isEqualTo(fieldValue);
    }

    @Test
    @DisplayName("Deserialize assignee field")
    void deserializeAssignee() throws JsonProcessingException {
        String fieldName = "assignee";
        boolean fieldValue = true;
        BoardStickerInfo boardStickerInfo = getBoardStickerInfo(fieldName, fieldValue);
        assertThat(boardStickerInfo.isAssignee()).isEqualTo(fieldValue);
    }

    @Test
    @DisplayName("Deserialize repeat field")
    void deserializeRepeat() throws JsonProcessingException {
        String fieldName = "repeat";
        boolean fieldValue = true;
        BoardStickerInfo boardStickerInfo = getBoardStickerInfo(fieldName, fieldValue);
        assertThat(boardStickerInfo.isRepeat()).isEqualTo(fieldValue);
    }

    @Test
    @DisplayName("Deserialize custom field")
    void deserializeCustom() throws JsonProcessingException {
        CustomSticker stickerOne = new CustomSticker("idOneValue", true);
        CustomSticker stickerTwo = new CustomSticker("idTwoValue", true);
        String idOne = "idOneValue";
        boolean statusOne = true;
        String idTwo = "idTwoValue";
        boolean statusTwo = true;
        String jsonString = String.format(
                """
                {
                    "custom": {
                    "%s": %s,
                    "%s": %s
                    }
                }
                """, stickerOne.getId(), stickerOne.getStatus(), stickerTwo.getId(), stickerTwo.getStatus()
        );
        BoardStickerInfo boardStickerInfo = mapper.readValue(jsonString, BoardStickerInfo.class);
        assertThatCollection(boardStickerInfo.getCustom()).contains(stickerOne, stickerTwo);
    }

    private BoardStickerInfo getBoardStickerInfo(String fieldName, Object value) throws JsonProcessingException {
        String jsonString = String.format(
                """
                {
                    "%s": %s
                }
                """, fieldName, value
        );
        return mapper.readValue(jsonString, BoardStickerInfo.class);
    }
}