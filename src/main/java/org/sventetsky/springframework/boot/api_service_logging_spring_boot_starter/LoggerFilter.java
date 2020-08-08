package org.sventetsky.springframework.boot.api_service_logging_spring_boot_starter;

import lombok.RequiredArgsConstructor;
import org.springframework.web.filter.OncePerRequestFilter;
import org.springframework.web.util.ContentCachingRequestWrapper;
import org.springframework.web.util.ContentCachingResponseWrapper;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.concurrent.atomic.AtomicLong;

@RequiredArgsConstructor
public class LoggerFilter extends OncePerRequestFilter {

    private static AtomicLong incrementer = new AtomicLong();

    private final RequestAndResponseLogger logger;

    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain) throws ServletException, IOException {

        ContentCachingRequestWrapper wrappedRequest = new ContentCachingRequestWrapper(request);
        ContentCachingResponseWrapper wrappedResponse = new ContentCachingResponseWrapper(response);

        LoggerEvent loggerEvent = LoggerEvent.init(wrappedRequest, incrementer.incrementAndGet());

        filterChain.doFilter(wrappedRequest, wrappedResponse);

        logger.logRequest(wrappedRequest, loggerEvent);
        logger.logResponse(wrappedResponse, loggerEvent);

        // copy content of response back into original response
        wrappedResponse.copyBodyToResponse();
    }
}
