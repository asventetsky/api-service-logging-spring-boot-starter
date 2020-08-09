package org.sventetsky.springframework.boot.api_service_logging_spring_boot_starter.appender;

import org.springframework.web.util.ContentCachingResponseWrapper;

public interface ResponseAppender {

    void append(ContentCachingResponseWrapper response, StringBuilder message);
}
