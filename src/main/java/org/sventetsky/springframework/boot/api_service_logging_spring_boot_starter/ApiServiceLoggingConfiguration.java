package org.sventetsky.springframework.boot.api_service_logging_spring_boot_starter;

import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingBean;
import org.springframework.boot.autoconfigure.condition.ConditionalOnWebApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.sventetsky.springframework.boot.api_service_logging_spring_boot_starter.filter.ApiServiceLoggerFilter;
import org.sventetsky.springframework.boot.api_service_logging_spring_boot_starter.logger.ApiServiceLogger;
import org.sventetsky.springframework.boot.api_service_logging_spring_boot_starter.logger.DefaultApiServiceLogger;
import org.sventetsky.springframework.boot.api_service_logging_spring_boot_starter.logger.config.LoggingConfig;
import org.sventetsky.springframework.boot.api_service_logging_spring_boot_starter.logger.config.LoggingConfigProperties;
import org.sventetsky.springframework.boot.api_service_logging_spring_boot_starter.logger.config.PropertiesLoggingConfig;

@Configuration
@ConditionalOnWebApplication
public class ApiServiceLoggingConfiguration {

    @Bean
    public LoggingConfigProperties loggingConfigProperties() {
        return new LoggingConfigProperties();
    }

    @Bean
    @ConditionalOnMissingBean(LoggingConfig.class)
    public LoggingConfig propertiesApiServiceLoggingConfig() {
        return new PropertiesLoggingConfig(loggingConfigProperties());
    }

    @Bean
    public ApiServiceLogger apiServiceLogger() {
        return new DefaultApiServiceLogger();
    }

    @Bean
    public ApiServiceLoggerFilter apiServiceLoggerFilter() {
        return new ApiServiceLoggerFilter(apiServiceLogger());
    }

}
