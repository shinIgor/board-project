package com.example.boardproject.application.model.transfer.Response;

import lombok.AccessLevel;
import lombok.Data;
import lombok.experimental.FieldDefaults;

import java.math.BigInteger;

@Data
@FieldDefaults(level = AccessLevel.PRIVATE)
public class AssociateUserResponse {
    BigInteger usn;
    String userId;
    Integer type;
}
