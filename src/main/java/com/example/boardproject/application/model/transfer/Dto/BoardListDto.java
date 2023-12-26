package com.example.boardproject.application.model.transfer.Dto;

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
@Accessors(chain = true)
@AllArgsConstructor
@NoArgsConstructor
public class BoardListDto {
    BigInteger Id;
    BigInteger usn;
    String nickName;
    String title;
    LocalDateTime createdAt;
}
