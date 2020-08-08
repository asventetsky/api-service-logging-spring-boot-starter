package org.sventetsky.springframework.boot.api_service_logging_spring_boot_starter;

import lombok.Getter;
import lombok.Setter;
import org.springframework.web.util.ContentCachingRequestWrapper;

@Getter
@Setter
public class LoggerEvent {

    private ContentCachingRequestWrapper request;
    private long executionId;
    private String method;
    private String requestUrl;
    private long startTime;


    public static LoggerEvent init(ContentCachingRequestWrapper request, long executionId) {
        LoggerEvent loggerEvent = new LoggerEvent();
        loggerEvent.setRequest(request);
        loggerEvent.setExecutionId(executionId);
        loggerEvent.setMethod(request.getMethod());
        loggerEvent.setRequestUrl(getRequestUrl(request));
        loggerEvent.setStartTime(System.currentTimeMillis());
        return loggerEvent;
    }

    private static String getRequestUrl(ContentCachingRequestWrapper request) {
        StringBuilder requestUrl = new StringBuilder();
        requestUrl.append(request.getRequestURL());
        String queryString = request.getQueryString();
        if (queryString != null) {
            requestUrl.append("?").append(queryString);
        }
        return requestUrl.toString();
    }

    public long calculateDuration() {
        return System.currentTimeMillis() - startTime;
    }
}
