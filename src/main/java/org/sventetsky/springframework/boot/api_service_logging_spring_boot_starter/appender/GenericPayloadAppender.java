package org.sventetsky.springframework.boot.api_service_logging_spring_boot_starter.appender;

import org.springframework.web.util.ContentCachingRequestWrapper;
import org.springframework.web.util.ContentCachingResponseWrapper;

import java.io.UnsupportedEncodingException;

import static java.lang.String.format;
import static org.sventetsky.springframework.boot.api_service_logging_spring_boot_starter.appender.Template.PAYLOAD_TEMPLATE;

public interface GenericPayloadAppender {

    static String getPayloadMessage(ContentCachingRequestWrapper request) {
        return getPayloadMessage(request.getContentAsByteArray(), request.getCharacterEncoding());
    }

    static String getPayloadMessage(ContentCachingResponseWrapper response) {
        return getPayloadMessage(response.getContentAsByteArray(), response.getCharacterEncoding());
    }

    static String getPayloadMessage(byte[] payloadAsByteArray, String characterEncoding) {
        if (payloadAsByteArray.length == 0) {
            return "";
        }
        String payload = null;
        try {
            payload = new String(payloadAsByteArray, characterEncoding);
        } catch (UnsupportedEncodingException ex) {
            payload = "Unsupported Encoding";
        }
        return format(PAYLOAD_TEMPLATE, payload);
    }
}
