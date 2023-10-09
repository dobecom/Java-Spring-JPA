package com.dobecom.steve.springboot.api.common;

public class CommonNotFoundException extends RuntimeException{
    public CommonNotFoundException(String message) {
        super(message);
    }

    public CommonNotFoundException(String message, Throwable cause) {
        super(message, cause);
    }

    public CommonNotFoundException(Throwable cause) {
        super(cause);
    }
}
