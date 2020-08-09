package org.sventetsky.springframework.boot.api_service_logging_spring_boot_starter.appender;

import org.springframework.web.util.ContentCachingResponseWrapper;

import static org.sventetsky.springframework.boot.api_service_logging_spring_boot_starter.context.RequestContextHolder.*;
import static org.sventetsky.springframework.boot.api_service_logging_spring_boot_starter.appender.Template.RESPONSE_LINE_TEMPLATE;

public class LineResponseAppender implements ResponseAppender {

    @Override
    public void append(ContentCachingResponseWrapper response, StringBuilder message) {
        String responseLineMessage = getResponseLineMessage(response);
        message.append(responseLineMessage);
    }

    private String getResponseLineMessage(ContentCachingResponseWrapper response) {
        return String.format(
                RESPONSE_LINE_TEMPLATE,
                getRequestId(),
                getMethod(),
                response.getStatus(),
                getUrl(),
                calculateSpentTime());
    }
}
