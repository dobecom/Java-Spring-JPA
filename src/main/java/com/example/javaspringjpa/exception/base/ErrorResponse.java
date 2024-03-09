package com.example.javaspringjpa.exception.base;

import lombok.Getter;
import org.slf4j.MDC;

@Getter
public class ErrorResponse {
    private String correlationId;
    private String code;
    private String message;
    private long timestamp = System.currentTimeMillis();
    private String statusCode;
    private String path;

    public ErrorResponse() {
    }

    public static ErrorResponse create(String code, String message, String statusCode, String path) {
        return new ErrorResponse(MDC.get("correlationId"), code, message, statusCode, path, System.currentTimeMillis());
    }

    private ErrorResponse(String correlationId, String code, String message, String statusCode, String path, long timestamp) {
        this.correlationId = correlationId;
        this.code = code;
        this.message = message;
        this.statusCode = statusCode;
        this.path = path;
        this.timestamp = timestamp;
    }
}
