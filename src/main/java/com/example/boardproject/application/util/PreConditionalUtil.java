package com.example.boardproject.application.util;

import com.example.boardproject.application.model.exception.CommonErrorMessage;
import com.example.boardproject.application.model.exception.CommonException;
import lombok.experimental.UtilityClass;
import lombok.extern.slf4j.Slf4j;

import java.util.Optional;

@Slf4j
@UtilityClass
public class PreConditionalUtil {
    public static <T> void valid(T obj) {
        Optional.ofNullable(obj)
                .orElseThrow(() -> {
                    log.error("param is null value.");
                    return new CommonException(CommonErrorMessage.INVALID_PARAM);
                });
    }
}
