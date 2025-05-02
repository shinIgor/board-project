package com.example.boardproject.application.model.exception;

import org.springframework.http.HttpStatus;

public interface BaseErrorMessage {
    Integer getCode();
    String getMessage();
    HttpStatus getStatus();
}
