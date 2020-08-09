package org.sventetsky.springframework.boot.api_service_logging_spring_boot_starter;

import org.springframework.boot.autoconfigure.condition.ConditionalOnWebApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.sventetsky.springframework.boot.api_service_logging_spring_boot_starter.filter.ApiServiceLoggerFilter;
import org.sventetsky.springframework.boot.api_service_logging_spring_boot_starter.logger.config.DefaultLoggingConfig;
import org.sventetsky.springframework.boot.api_service_logging_spring_boot_starter.logger.ApiServiceLogger;
import org.sventetsky.springframework.boot.api_service_logging_spring_boot_starter.logger.DefaultApiServiceLogger;

@Configuration
@ConditionalOnWebApplication
public class ApiServiceLoggingConfiguration {

    @Bean
    public ApiServiceLogger apiServiceLogger() {
        return new DefaultApiServiceLogger(new DefaultLoggingConfig());
    }

    @Bean
    public ApiServiceLoggerFilter apiServiceLoggerFilter() {
        return new ApiServiceLoggerFilter(apiServiceLogger());
    }

}
