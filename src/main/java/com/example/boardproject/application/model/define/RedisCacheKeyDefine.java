package com.example.boardproject.application.model.define;

import lombok.experimental.UtilityClass;

@UtilityClass
public class RedisCacheKeyDefine {
    private final String REDIS_KEY_DELIMITER = ":";

    public String getMemberKey(Long usn) {
        return String.join(REDIS_KEY_DELIMITER, DefineDefaultValue.SERVICE_NAME,
                "usn", usn.toString());
    }
}
