package org.sventetsky.springframework.boot.api_service_logging_spring_boot_starter.context;

import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

@Getter
@Setter
public class RequestContext {

    private String requestId;
    private String method;
    private String url;
    private LocalDateTime startTime;
}
