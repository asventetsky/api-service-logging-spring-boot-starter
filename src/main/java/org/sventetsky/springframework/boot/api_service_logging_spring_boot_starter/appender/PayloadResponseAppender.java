package org.sventetsky.springframework.boot.api_service_logging_spring_boot_starter.appender;

import org.springframework.web.util.ContentCachingResponseWrapper;

import static org.sventetsky.springframework.boot.api_service_logging_spring_boot_starter.appender.GenericPayloadAppender.getPayloadMessage;

public class PayloadResponseAppender implements ResponseAppender, GenericPayloadAppender {

    @Override
    public void append(ContentCachingResponseWrapper response, StringBuilder message) {
        String payloadMessage = getPayloadMessage(response);
        message.append(payloadMessage);
    }
}
