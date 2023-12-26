package com.example.boardproject.configuration.pebble;

import io.pebbletemplates.pebble.extension.AbstractExtension;
import lombok.RequiredArgsConstructor;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.Map;

/**
 * author      : kyle.mind
 * date        : 2023/05/03
 * description :
 **/
@Component
@RequiredArgsConstructor
@ConditionalOnProperty(prefix = "application.pebble", name = "enabled", havingValue = "true")
public class PebbleExtension extends AbstractExtension {
    private final Environment env;
    @Override
    public Map<String, Object> getGlobalVariables() {
        Map<String, Object> values = new HashMap<>();

        values.put("ENVIRONMENT", getEnvironmentName(env.getActiveProfiles()[0]));

        return values;
    }

    private String getEnvironmentName(String profile) {
        if (null == profile || profile.isEmpty())
            return "Unknown";

        if (profile.contains("dev")) {
            return "개발 환경";
        }
        if (profile.contains("testnet")) {
            return "테스트 환경";
        }
        if (profile.contains("live")) {
            return "라이브 환경";
        }

        return "로컬 환경";
    }
}
