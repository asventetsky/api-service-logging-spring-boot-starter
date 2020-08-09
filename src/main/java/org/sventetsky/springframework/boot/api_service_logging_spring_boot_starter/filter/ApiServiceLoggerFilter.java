package org.sventetsky.springframework.boot.api_service_logging_spring_boot_starter.filter;

import lombok.RequiredArgsConstructor;
import org.springframework.web.filter.OncePerRequestFilter;
import org.springframework.web.util.ContentCachingRequestWrapper;
import org.springframework.web.util.ContentCachingResponseWrapper;
import org.sventetsky.springframework.boot.api_service_logging_spring_boot_starter.context.RequestContextHolder;
import org.sventetsky.springframework.boot.api_service_logging_spring_boot_starter.logger.ApiServiceLogger;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@RequiredArgsConstructor
public class ApiServiceLoggerFilter extends OncePerRequestFilter {

    private final ApiServiceLogger logger;

    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain) throws ServletException, IOException {
        ContentCachingRequestWrapper wrappedRequest = new ContentCachingRequestWrapper(request);
        ContentCachingResponseWrapper wrappedResponse = new ContentCachingResponseWrapper(response);
        RequestContextHolder.init(
                wrappedRequest.getMethod(),
                fetchRequestUrl(wrappedRequest)
        );

        logger.logRequest(wrappedRequest);
        filterChain.doFilter(wrappedRequest, wrappedResponse);
        logger.logResponse(wrappedResponse);

        // copy content of response back into original response
        wrappedResponse.copyBodyToResponse();
    }

    private static String fetchRequestUrl(ContentCachingRequestWrapper request) {
        StringBuilder requestUrl = new StringBuilder();
        requestUrl.append(request.getRequestURL());
        String queryString = request.getQueryString();
        if (queryString != null) {
            requestUrl.append("?").append(queryString);
        }
        return requestUrl.toString();
    }
}
