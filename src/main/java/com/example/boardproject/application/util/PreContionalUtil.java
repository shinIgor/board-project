package com.example.boardproject.application.util;

import com.example.boardproject.application.model.type.ErrorMessageType;
import lombok.experimental.UtilityClass;
import lombok.extern.slf4j.Slf4j;

import java.util.Optional;

@Slf4j
@UtilityClass
public class PreContionalUtil {
    public static <T> void valid(T obj) {
        Optional.ofNullable(obj)
                .orElseThrow(() -> {
                    log.error("param is null value.");
                    return new CommonException(ErrorMessageType.INVALID_PARAMETER);
                });
    }
}
