package org.sventetsky.springframework.boot.api_service_logging_spring_boot_starter.appender;

import lombok.experimental.UtilityClass;

@UtilityClass
public final class Template {

    public static final String REQUEST_LINE_TEMPLATE = "[RQ:%s][%s]%s";
    public static final String RESPONSE_LINE_TEMPLATE = "[RS:%s][%s][%s]%s in %s ms";
    public static final String HEADERS_TEMPLATE = "\n||||HEADERS:%s||||";
    public static final String PAYLOAD_TEMPLATE = "\n||||BODY:%s||||";
}
