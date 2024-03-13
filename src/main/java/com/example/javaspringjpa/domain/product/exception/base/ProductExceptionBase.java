package com.example.javaspringjpa.domain.product.exception.base;

import com.example.javaspringjpa.exception.ExceptionEnums;
import lombok.Getter;

@Getter
public class ProductExceptionBase extends RuntimeException {
    private final ExceptionEnums exceptionEnums;
    public ProductExceptionBase(ExceptionEnums exceptionEnums) {
        super(exceptionEnums.getMessage());
        this.exceptionEnums = exceptionEnums;
    }
}
