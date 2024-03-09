package com.example.javaspringjpa.exception;

import com.example.javaspringjpa.exception.base.ErrorResponse;
import org.slf4j.MDC;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import java.util.NoSuchElementException;

import static org.springframework.http.HttpStatus.*;

@ControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(NoSuchElementException.class)
    public ResponseEntity<ErrorResponse> handleNoSuchElementException(NoSuchElementException e) {
        return ResponseEntity.status(NOT_FOUND).body(ErrorResponse.create(MDC.get("correlationId"), "NF001", "No such element."));
    }

    @ExceptionHandler(DataIntegrityViolationException.class)
    public ResponseEntity<ErrorResponse> handleDataIntegrityViolationException(DataIntegrityViolationException e) {
        String message = e.getMessage();

        // Unique key constraint violation
        if (message.contains("Duplicate entry")) {
            return handleDuplicateKeyException(e);
        }

        // Not null constraint violation
        if (message.contains("column cannot be null")) {
            return handleNotNullConstraintViolationException(e);
        }

        // Foreign key constraint violation
        if (message.contains("foreign key constraint fails")) {
            return handleForeignKeyConstraintViolationException(e);
        }

        // DataIntegrityViolationException
        return handleUnknownDataIntegrityViolationException(e);
    }

    private ResponseEntity<ErrorResponse> handleDuplicateKeyException(DataIntegrityViolationException e) {
        return ResponseEntity.status(CONFLICT).body(ErrorResponse.create(MDC.get("correlationId"), "CF001", "Conflict occurred due to duplicate key constraint violation."));

    }

    private ResponseEntity<ErrorResponse> handleNotNullConstraintViolationException(DataIntegrityViolationException e) {
        return ResponseEntity.status(BAD_REQUEST).body(ErrorResponse.create(MDC.get("correlationId"), "BR001", "Bad Request due to not null constraint violation."));
    }

    private ResponseEntity<ErrorResponse> handleForeignKeyConstraintViolationException(DataIntegrityViolationException e) {
        return ResponseEntity.status(BAD_REQUEST).body(ErrorResponse.create(MDC.get("correlationId"), "BR002", "Bad Request due to foreign key constraint violation."));
    }

    private ResponseEntity<ErrorResponse> handleUnknownDataIntegrityViolationException(DataIntegrityViolationException e) {
        return ResponseEntity.status(BAD_REQUEST).body(ErrorResponse.create(MDC.get("correlationId"), "BR003", "Bad Request due to unknown data integrity violation."));
    }
}
