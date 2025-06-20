package io.github.patbattb.yougileapilib.domain;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import io.github.patbattb.yougileapilib.http.deserialize.ColumnDeserializer;
import lombok.*;
import lombok.experimental.FieldDefaults;

@Getter
@FieldDefaults(level = AccessLevel.PRIVATE)
@AllArgsConstructor
@EqualsAndHashCode
@ToString
@JsonDeserialize(using = ColumnDeserializer.class)
public class Column {
    @Setter
    boolean deleted;
    String id;
    @Setter
    String title;
    @Setter
    Integer color; //TODO проверка на допустимость значения
    @Setter
    String boardId;
}
