package com.example.javaspringjpa.exception;

public interface ErrorCode {
    String getCode();

    int getHttpStatus();

    String getMessage();
}
