package com.example.boardproject.application.model.type;

import lombok.Getter;

@Getter
public enum CheckDuplicateKeywordType {
    ID("user_id"),
    NICK_NAME("nick_name")
    ;


    private final String message;


    CheckDuplicateKeywordType(String message) {this.message = message;}
}
