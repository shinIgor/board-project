package com.example.boardproject.application.model.transfer.Dto;

import lombok.AccessLevel;
import lombok.Data;
import lombok.experimental.Accessors;
import lombok.experimental.FieldDefaults;

import java.math.BigInteger;
@Data
@Accessors(chain = true)
@FieldDefaults(level = AccessLevel.PRIVATE)
public class AssociateLoginDto {
    BigInteger usn;
    String userId;
    Integer type;
}



