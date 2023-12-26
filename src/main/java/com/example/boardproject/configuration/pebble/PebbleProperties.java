package com.example.boardproject.configuration.pebble;

import lombok.AccessLevel;
import lombok.Data;
import lombok.experimental.FieldDefaults;
import org.springframework.boot.context.properties.ConfigurationProperties;

import java.util.Locale;

@Data
@FieldDefaults(level = AccessLevel.PRIVATE)
@ConfigurationProperties(prefix = "application.pebble")
public class PebbleProperties {
    boolean enabled = false;
    String contentType = "text/html";
    String encoding = "UTF-8";
    boolean cache = false;
    boolean allowRequestOverride;
    boolean allowSessionOverride;
    boolean exposeRequestAttributes;
    boolean exposeSessionAttributes;
    boolean exposeSpringMacroHelpers;
    String requestContextAttribute;
    String prefix = "/templates/";
    String suffix = ".html";

    Locale defaultLocale;
    boolean strictVariables;
}
