package com.example.boardproject.application.model.transfer.Response;

import com.example.boardproject.application.model.entity.BoardUt;
import lombok.*;
import lombok.experimental.Accessors;
import lombok.experimental.FieldDefaults;

import java.math.BigInteger;
import java.time.LocalDateTime;
import java.util.Objects;

@Getter
@FieldDefaults(level = AccessLevel.PRIVATE)
public class BoardDetailResponse {
    BigInteger id;
    BigInteger usn;
    String nickName;
    String userId;
    String title;
    String post;
    LocalDateTime createdAt;
    LocalDateTime updatedAt;

    public static BoardDetailResponse of(BoardUt param) {
        BoardDetailResponse result = new BoardDetailResponse();
        if (Objects.isNull(param)) return result;

        result.id = param.getId();
        result.usn = param.getOwner().getId();
        result.nickName = param.getOwner().getNickName();
        result.userId = param.getOwner().getUserId();
        result.title = param.getBoardName();
        result.post = param.getBoardPost();
        result.createdAt = param.getCreatedAt();
        result.updatedAt = param.getUpdatedAt();

        return result;
    }
}
