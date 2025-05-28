package io.github.patbattb.yougileapilib.domain;

import lombok.*;
import lombok.experimental.FieldDefaults;

import java.util.List;

@Getter
@FieldDefaults(level = AccessLevel.PRIVATE)
@AllArgsConstructor
@EqualsAndHashCode
@ToString
public class Permission {
    boolean editTitle;
    boolean delete;
    boolean addBoard;
    List<Board> boards;
    Permission children;
}
