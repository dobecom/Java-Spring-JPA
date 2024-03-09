package com.example.javaspringjpa.exception;

import com.example.javaspringjpa.exception.base.ErrorResponse;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import java.util.NoSuchElementException;

import static org.springframework.http.HttpStatus.*;

@ControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(NoSuchElementException.class)
    public ResponseEntity<ErrorResponse> handleNoSuchElementException(NoSuchElementException e, HttpServletRequest request) {
        return ResponseEntity.status(NOT_FOUND).body(ErrorResponse.create("NF001", "No such element.", "404", request.getRequestURI()));
    }

    @ExceptionHandler(DataIntegrityViolationException.class)
    public ResponseEntity<ErrorResponse> handleDataIntegrityViolationException(DataIntegrityViolationException e, HttpServletRequest request) {
        String message = e.getMessage();

        // Unique key constraint violation
        if (message.contains("Duplicate entry")) {
            return handleDuplicateKeyException(request.getRequestURI());
        }

        // Not null constraint violation
        if (message.contains("column cannot be null")) {
            return handleNotNullConstraintViolationException(request.getRequestURI());
        }

        // Foreign key constraint violation
        if (message.contains("foreign key constraint fails")) {
            return handleForeignKeyConstraintViolationException(request.getRequestURI());
        }

        // DataIntegrityViolationException
        return handleUnknownDataIntegrityViolationException(request.getRequestURI());
    }

    private ResponseEntity<ErrorResponse> handleDuplicateKeyException(String uri) {
        return ResponseEntity.status(CONFLICT).body(ErrorResponse.create("CF001", "Conflict occurred due to duplicate key constraint violation.", "409", uri));
    }

    private ResponseEntity<ErrorResponse> handleNotNullConstraintViolationException(String uri) {
        return ResponseEntity.status(BAD_REQUEST).body(ErrorResponse.create("BR001", "Bad Request due to not null constraint violation.", "400", uri));
    }

    private ResponseEntity<ErrorResponse> handleForeignKeyConstraintViolationException(String uri) {
        return ResponseEntity.status(BAD_REQUEST).body(ErrorResponse.create("BR002", "Bad Request due to foreign key constraint violation.", "400", uri));
    }

    private ResponseEntity<ErrorResponse> handleUnknownDataIntegrityViolationException(String uri) {
        return ResponseEntity.status(BAD_REQUEST).body(ErrorResponse.create("BR003", "Bad Request due to unknown data integrity violation.", "400", uri));
    }
}
