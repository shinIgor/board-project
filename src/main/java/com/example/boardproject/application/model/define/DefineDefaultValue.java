package com.example.boardproject.application.model.define;

import lombok.experimental.UtilityClass;

import java.time.Duration;

@UtilityClass
public class DefineDefaultValue {
    public static final String SERVICE_NAME = "board_project";

    public static final Duration WEBCLIENT_RETRY_DELAY_SECOND = Duration.ofSeconds(3);
}
