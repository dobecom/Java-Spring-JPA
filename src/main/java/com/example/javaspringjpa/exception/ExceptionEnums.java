package com.example.javaspringjpa.exception;

import lombok.AllArgsConstructor;

@AllArgsConstructor
public enum ExceptionEnums implements ErrorCode {
    // Common Exception

    // User Exception

    // Product Exception
    PRODUCT_CREATE_LIMIT("BR005", 400, "Not allowed to create more than 5 products. ");

    private final String code;
    private final int httpStatus;
    private final String message;

    @Override
    public String getCode() {
        return code;
    }

    @Override
    public int getHttpStatus() {
        return httpStatus;
    }

    @Override
    public String getMessage() {
        return message;
    }
}
