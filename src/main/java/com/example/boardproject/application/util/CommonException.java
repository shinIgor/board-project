package com.example.boardproject.application.util;

import com.example.boardproject.application.model.type.ErrorMessageType;
import lombok.Getter;
import lombok.Setter;
import lombok.extern.slf4j.Slf4j;


@Slf4j
@Getter
@Setter
public class CommonException extends RuntimeException {
    private String code;

    private String message;

    private String[] args;

    public CommonException(ErrorMessageType errorMessageType) {
        super();
        this.code = errorMessageType.getCode().toString();
        this.message = errorMessageType.getMessage();
    }

    public  CommonException(String code, String message){
        super();
        this.code = code;
        this.message = message;
    }


}
