package com.example.boardproject.application.model.type;

import lombok.Getter;

import java.util.Arrays;
import java.util.function.Predicate;
@Getter
public enum ErrorMessageType {
    UNKNOWN(-1, "unknown"),
    BAD_REQUEST(1, "bad request"),
    DUPLICATE_PARAMETER(2,"duplicate parameter"),
    INVALID_PARAMETER(3,"invalid parameter");



    final Integer code;
    final String message;

    ErrorMessageType(Integer code, String message) {
        this.code = code;
        this.message = message;
    }

    static ErrorMessageType find(Predicate<ErrorMessageType> predicate){
        return Arrays.stream(values())
                .filter(predicate)
                .findAny()
                .orElse(UNKNOWN);
    }
}
