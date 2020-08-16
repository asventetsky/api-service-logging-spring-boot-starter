package org.sventetsky.springframework.boot.api_service_logging_spring_boot_starter.logger.config;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.slf4j.Logger;

@Slf4j
@RequiredArgsConstructor
public class PropertiesLoggingConfig implements LoggingConfig {

    private final LoggingConfigProperties properties;

    @Override
    public Logger getLogger() {
        return log;
    }

    @Override
    public boolean isLoggingEnabled() {
        return properties.isLoggingEnabled();
    }

    @Override
    public boolean isLogPayload() {
        return properties.isLogPayload();
    }

    @Override
    public boolean isLogHeaders() {
        return properties.isLogHeaders();
    }
}
