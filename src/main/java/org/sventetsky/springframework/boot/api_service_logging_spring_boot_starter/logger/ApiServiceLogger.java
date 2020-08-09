package org.sventetsky.springframework.boot.api_service_logging_spring_boot_starter.logger;

import org.springframework.web.util.ContentCachingRequestWrapper;
import org.springframework.web.util.ContentCachingResponseWrapper;

public interface ApiServiceLogger {

    void logRequest(ContentCachingRequestWrapper request);

    void logResponse(ContentCachingResponseWrapper response);
}
