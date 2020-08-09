package org.sventetsky.springframework.boot.api_service_logging_spring_boot_starter.appender;

import org.springframework.web.util.ContentCachingRequestWrapper;

import static org.sventetsky.springframework.boot.api_service_logging_spring_boot_starter.appender.GenericPayloadAppender.getPayloadMessage;

public class PayloadRequestAppender implements RequestAppender, GenericPayloadAppender {

    @Override
    public void append(ContentCachingRequestWrapper request, StringBuilder message) {
        String payloadMessage = getPayloadMessage(request);
        message.append(payloadMessage);
    }
}
