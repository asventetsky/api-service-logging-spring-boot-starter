package org.sventetsky.springframework.boot.api_service_logging_spring_boot_starter.appender;

import org.springframework.web.util.ContentCachingResponseWrapper;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

import static org.sventetsky.springframework.boot.api_service_logging_spring_boot_starter.appender.Template.HEADERS_TEMPLATE;

public class HeadersResponseAppender implements ResponseAppender {

    @Override
    public void append(ContentCachingResponseWrapper response, StringBuilder message) {
        String headersMessage = getHeadersMessage(response);
        message.append(headersMessage);
    }

    private String getHeadersMessage(ContentCachingResponseWrapper response) {
        Map<String, String> headers = new HashMap<>();
        Collection<String> headerNames = response.getHeaderNames();
        for (String headerName : headerNames) {
            String headerValue = response.getHeader(headerName);
            headers.put(headerName, headerValue);
        }
        return String.format(HEADERS_TEMPLATE, headers.toString());
    }
}
