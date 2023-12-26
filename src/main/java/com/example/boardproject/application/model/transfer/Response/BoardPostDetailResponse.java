package com.example.boardproject.application.model.transfer.Response;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;
import lombok.experimental.FieldDefaults;

import java.math.BigInteger;
import java.time.LocalDateTime;

@Data
@FieldDefaults(level = AccessLevel.PRIVATE)
@NoArgsConstructor
@AllArgsConstructor
@Accessors(chain = true)
public class BoardPostDetailResponse {
    BigInteger id;
    BigInteger usn;
    String nickName;
    String userId;
    String title;
    String post;
    LocalDateTime createdAt;
    LocalDateTime updatedAt;
}
