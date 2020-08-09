package org.sventetsky.springframework.boot.api_service_logging_spring_boot_starter.appender;

import org.springframework.web.util.ContentCachingRequestWrapper;

import java.util.Enumeration;
import java.util.HashMap;
import java.util.Map;

import static org.sventetsky.springframework.boot.api_service_logging_spring_boot_starter.appender.Template.HEADERS_TEMPLATE;

public class HeadersRequestAppender implements RequestAppender {

    @Override
    public void append(ContentCachingRequestWrapper request, StringBuilder message) {
        String headersMessage = getHeadersMessage(request);
        message.append(headersMessage);
    }

    private String getHeadersMessage(ContentCachingRequestWrapper request) {
        Map<String, String> headers = new HashMap<>();
        Enumeration<String> headerNames = request.getHeaderNames();
        while (headerNames.hasMoreElements()) {
            String headerName = headerNames.nextElement();
            String headerValue = request.getHeader(headerName);
            headers.put(headerName, headerValue);
        }
        return String.format(HEADERS_TEMPLATE, headers.toString());
    }
}
