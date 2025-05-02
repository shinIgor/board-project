package com.example.boardproject.application.model.transfer.Response;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;
import lombok.experimental.FieldDefaults;

import java.math.BigInteger;

@Data
@FieldDefaults(level = AccessLevel.PRIVATE)
@AllArgsConstructor
@NoArgsConstructor
@Accessors(chain = false)
public class LoginResponse {
    BigInteger usn;
    String userId;
    String nickName;
    Integer permission;


}