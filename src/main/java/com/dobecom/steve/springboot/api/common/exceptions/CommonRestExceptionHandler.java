package com.dobecom.steve.springboot.api.common.exceptions;

import com.dobecom.steve.springboot.api.common.CommonErrorResponse;
import com.dobecom.steve.springboot.api.common.CommonNotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class CommonRestExceptionHandler {
    // catch exception for the custom exception
    @ExceptionHandler
    public ResponseEntity<CommonErrorResponse> handleException(CommonNotFoundException exc) {
        CommonErrorResponse error = new CommonErrorResponse(
                HttpStatus.NOT_FOUND.value(),
                exc.getMessage(),
                System.currentTimeMillis()
        );

        return new ResponseEntity<>(error, HttpStatus.NOT_FOUND);
    }

    // catch all exception
    @ExceptionHandler
    public ResponseEntity<CommonErrorResponse> handleException(Exception exc) {
        CommonErrorResponse error = new CommonErrorResponse(
                HttpStatus.BAD_REQUEST.value(), // set exception as 400
                exc.getMessage(),
                System.currentTimeMillis()
        );

        return new ResponseEntity<>(error, HttpStatus.BAD_REQUEST);
    }
}
