package com.example.javaspringjpa.exception.base;

import lombok.Getter;
import org.slf4j.MDC;

@Getter
public class ErrorResponse {
    private String correlationId;
    private String code;
    private String message;
    private long timestamp = System.currentTimeMillis();

    public ErrorResponse() {
    }

    public static ErrorResponse create(String code, String message, int httpStatusCode, String path) {
        // Handling Logging for statusCode, path
        return new ErrorResponse(MDC.get("correlationId"), code, message, System.currentTimeMillis());
    }

    private ErrorResponse(String correlationId, String code, String message, long timestamp) {
        this.correlationId = correlationId;
        this.code = code;
        this.message = message;
        this.timestamp = timestamp;
    }
}
