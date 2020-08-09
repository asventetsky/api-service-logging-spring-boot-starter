package org.sventetsky.springframework.boot.api_service_logging_spring_boot_starter.appender;

import org.springframework.web.util.ContentCachingRequestWrapper;

import static org.sventetsky.springframework.boot.api_service_logging_spring_boot_starter.context.RequestContextHolder.*;
import static org.sventetsky.springframework.boot.api_service_logging_spring_boot_starter.appender.Template.REQUEST_LINE_TEMPLATE;

public class LineRequestAppender implements RequestAppender {

    @Override
    public void append(ContentCachingRequestWrapper request, StringBuilder message) {
        String requestLineMessage = getRequestLineMessage();
        message.append(requestLineMessage);
    }

    private String getRequestLineMessage() {
        return String.format(REQUEST_LINE_TEMPLATE, getRequestId(), getMethod(), getUrl());
    }
}
