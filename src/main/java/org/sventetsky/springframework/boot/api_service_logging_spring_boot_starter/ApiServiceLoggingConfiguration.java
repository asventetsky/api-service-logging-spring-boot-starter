package org.sventetsky.springframework.boot.api_service_logging_spring_boot_starter;

import org.springframework.boot.autoconfigure.condition.ConditionalOnWebApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
@ConditionalOnWebApplication
public class ApiServiceLoggingConfiguration {

    @Bean
    public RequestAndResponseLogger requestAndResponseLogger() {
        return new RequestAndResponseLogger();
    }

    @Bean
    public LoggerFilter loggerFilter() {
        return new LoggerFilter(requestAndResponseLogger());
    }

}
