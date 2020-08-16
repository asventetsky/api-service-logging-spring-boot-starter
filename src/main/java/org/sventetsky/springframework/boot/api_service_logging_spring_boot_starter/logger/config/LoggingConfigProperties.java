package org.sventetsky.springframework.boot.api_service_logging_spring_boot_starter.logger.config;

import lombok.Getter;
import lombok.Setter;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

@Getter
@Setter
@Component
@ConfigurationProperties("api-service-logging")
public class LoggingConfigProperties {

    /**
     * Enable logging of requests and responses of API service
     */
    private boolean loggingEnabled = true;

    /**
     * Enable logging of headers
     */
    private boolean logHeaders = true;

    /**
     * Enable logging of payloads
     */
    private boolean logPayload = true;

}
