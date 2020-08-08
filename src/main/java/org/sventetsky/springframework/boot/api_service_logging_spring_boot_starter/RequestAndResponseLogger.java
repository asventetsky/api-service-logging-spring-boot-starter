package org.sventetsky.springframework.boot.api_service_logging_spring_boot_starter;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.util.ContentCachingRequestWrapper;
import org.springframework.web.util.ContentCachingResponseWrapper;

import java.io.UnsupportedEncodingException;
import java.util.Collection;
import java.util.Enumeration;
import java.util.HashMap;
import java.util.Map;

public class RequestAndResponseLogger {

    private static final String REQUEST_TEMPLATE = "[RQ:{}][{}]{}\n|HEADERS:{}|\n|BODY:{}|";
    private static final String RESPONSE_TEMPLATE = "[RS:{}][{}][{}]{} in {} ms.\n|HEADERS:{}|\n|BODY:{}|";

    private static final Logger logger = LoggerFactory.getLogger(RequestAndResponseLogger.class);

    public void logRequest(ContentCachingRequestWrapper request, LoggerEvent loggerEvent) {
        String headers = getRequestHeaders(request);
        String body = getBody(request.getContentAsByteArray(), request.getCharacterEncoding());
        logger.info(REQUEST_TEMPLATE,
                loggerEvent.getExecutionId(),
                loggerEvent.getMethod(),
                loggerEvent.getRequestUrl(),
                headers,
                body);
    }

    public void logResponse(ContentCachingResponseWrapper response, LoggerEvent loggerEvent) {
        String headers = getResponseHeaders(response);
        String body = getBody(response.getContentAsByteArray(), response.getCharacterEncoding());
        logger.info(RESPONSE_TEMPLATE,
                loggerEvent.getExecutionId(),
                loggerEvent.getMethod(),
                response.getStatusCode(),
                loggerEvent.getRequestUrl(),
                loggerEvent.calculateDuration(),
                headers,
                body);
    }

    private static String getRequestHeaders(ContentCachingRequestWrapper request) {
        Map<String, String> headers = new HashMap<>();
        Enumeration<String> headerNames = request.getHeaderNames();
        while (headerNames.hasMoreElements()) {
            String headerName = headerNames.nextElement();
            String headerValue = request.getHeader(headerName);
            headers.put(headerName, headerValue);
        }
        return headers.toString();
    }

    private static String getResponseHeaders(ContentCachingResponseWrapper response) {
        Map<String, String> headers = new HashMap<>();
        Collection<String> headerNames = response.getHeaderNames();
        for (String headerName : headerNames) {
            String headerValue = response.getHeader(headerName);
            headers.put(headerName, headerValue);
        }
        return headers.toString();
    }

    private static String getBody(byte[] buf, String charsetName) {
        if (buf == null || buf.length == 0) return "";
        try {
            String body = new String(buf, charsetName);
            return body.length() > 0 ? body : "";
        } catch (UnsupportedEncodingException ex) {
            return "Unsupported Encoding";
        }
    }
}
