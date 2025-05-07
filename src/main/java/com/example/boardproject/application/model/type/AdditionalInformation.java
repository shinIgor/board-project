package com.example.boardproject.application.model.type;

import lombok.AccessLevel;
import lombok.Getter;
import lombok.experimental.FieldDefaults;

@Getter
@FieldDefaults(level = AccessLevel.PRIVATE)
public enum AdditionalInformation {
    USN("USN", "usn"),
    USER_ID("USERID", "userId"),
    NICK_NAME("NICKNAME", "nickName"),
    IS_CONNECT("IS_CONNECT", "isBappConnect"),
    EXTRA_PARAM("EXTRA_PARAM", "extraParam");

    final String code;
    final String name;
    AdditionalInformation(String code, String name) {
        this.code = code;
        this.name = name;
    }
}
