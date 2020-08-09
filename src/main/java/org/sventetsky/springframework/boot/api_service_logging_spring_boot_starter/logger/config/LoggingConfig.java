package org.sventetsky.springframework.boot.api_service_logging_spring_boot_starter.logger.config;

import org.slf4j.Logger;

public interface LoggingConfig {

    Logger getLogger();

    boolean isLoggingEnabled();

    boolean isLogPayload();

    boolean isLogHeaders();
}
