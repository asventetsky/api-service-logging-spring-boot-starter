package org.sventetsky.springframework.boot.api_service_logging_spring_boot_starter.logger.config;

import lombok.extern.slf4j.Slf4j;
import org.slf4j.Logger;

@Slf4j
public class DefaultLoggingConfig implements LoggingConfig {

    @Override
    public Logger getLogger() {
        return log;
    }

    @Override
    public boolean isLoggingEnabled() {
        return true;
    }

    @Override
    public boolean isLogPayload() {
        return true;
    }

    @Override
    public boolean isLogHeaders() {
        return true;
    }
}
