package com.example.boardproject.application.model.transfer.Response;

import com.example.boardproject.application.model.entity.BoardUt;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.experimental.FieldDefaults;

import java.math.BigInteger;
import java.time.LocalDateTime;
import java.util.Objects;

@Getter
@FieldDefaults(level = AccessLevel.PRIVATE)
public class BoardListResponse {
    BigInteger id;
    String nickName;
    String title;
    LocalDateTime createdAt;

    public static BoardListResponse of(BoardUt param) {
        BoardListResponse result = new BoardListResponse();
        if (Objects.isNull(param)) return result;
        result.id = param.getId();
        result.nickName = param.getOwner().getNickName();
        result.title = param.getBoardName();
        result.createdAt = param.getCreatedAt();

        return result;
    }
}
