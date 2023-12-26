package com.example.boardproject.application.model.transfer.Dto;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;
import lombok.experimental.FieldDefaults;

import java.math.BigInteger;

@Data
@NoArgsConstructor
@AllArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
public class MemberLoginDataDto {
    BigInteger usn;
    String userId;
    String nickName;
    Boolean isDelete;
    Integer permission;
}
