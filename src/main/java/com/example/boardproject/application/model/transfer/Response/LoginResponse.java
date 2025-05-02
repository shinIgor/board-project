package com.example.boardproject.application.model.transfer.Response;

import com.example.boardproject.application.model.entity.AccountUt;
import lombok.*;
import lombok.experimental.FieldDefaults;

import java.math.BigInteger;
import java.util.Objects;

@Getter
@FieldDefaults(level = AccessLevel.PRIVATE)
public class LoginResponse {
    BigInteger usn;
    String userId;
    String nickName;

    public static LoginResponse of(AccountUt param) {
        LoginResponse result = new LoginResponse();
        if (Objects.isNull(param)) return result;

        result.usn = param.getId();
        result.userId = param.getUserId();
        result.nickName = param.getNickName();
        return result;
    }
}