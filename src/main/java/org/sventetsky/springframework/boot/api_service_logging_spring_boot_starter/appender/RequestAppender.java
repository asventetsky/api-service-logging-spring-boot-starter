package org.sventetsky.springframework.boot.api_service_logging_spring_boot_starter.appender;

import org.springframework.web.util.ContentCachingRequestWrapper;

public interface RequestAppender {

    void append(ContentCachingRequestWrapper request, StringBuilder message);
}
