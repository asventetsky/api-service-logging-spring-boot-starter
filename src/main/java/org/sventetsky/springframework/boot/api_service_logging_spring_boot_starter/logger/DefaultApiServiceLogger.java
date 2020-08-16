package org.sventetsky.springframework.boot.api_service_logging_spring_boot_starter.logger;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.util.ContentCachingRequestWrapper;
import org.springframework.web.util.ContentCachingResponseWrapper;
import org.sventetsky.springframework.boot.api_service_logging_spring_boot_starter.appender.*;
import org.sventetsky.springframework.boot.api_service_logging_spring_boot_starter.logger.config.LoggingConfig;

public class DefaultApiServiceLogger implements ApiServiceLogger {

    @Autowired
    private LoggingConfig loggingConfig;

    private RequestAppender lineRequestAppender = new LineRequestAppender();
    private RequestAppender headersRequestAppender = new HeadersRequestAppender();
    private RequestAppender payloadRequestAppender = new PayloadRequestAppender();

    private ResponseAppender lineResponseAppender = new LineResponseAppender();
    private ResponseAppender headersResponseAppender = new HeadersResponseAppender();
    private ResponseAppender payloadResponseAppender = new PayloadResponseAppender();

    @Override
    public void logRequest(ContentCachingRequestWrapper request) {
        if (!loggingConfig.isLoggingEnabled()) {
            return;
        }
        StringBuilder message = new StringBuilder();
        lineRequestAppender.append(request, message);
        if (loggingConfig.isLogHeaders()) {
            headersRequestAppender.append(request, message);
        }
        if (loggingConfig.isLogPayload()) {
            payloadRequestAppender.append(request, message);
        }
        loggingConfig.getLogger().info(message.toString());
    }

    @Override
    public void logResponse(ContentCachingResponseWrapper response) {
        if (!loggingConfig.isLoggingEnabled()) {
            return;
        }
        StringBuilder message = new StringBuilder();
        lineResponseAppender.append(response, message);
        if (loggingConfig.isLogHeaders()) {
            headersResponseAppender.append(response, message);
        }
        if (loggingConfig.isLogPayload()) {
            payloadResponseAppender.append(response, message);
        }
        loggingConfig.getLogger().info(message.toString());
    }
}
