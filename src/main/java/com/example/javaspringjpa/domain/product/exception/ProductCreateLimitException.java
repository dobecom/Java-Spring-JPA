package com.example.javaspringjpa.domain.product.exception;

import com.example.javaspringjpa.domain.product.exception.base.ProductExceptionBase;
import com.example.javaspringjpa.exception.ExceptionEnums;
import lombok.Getter;

@Getter
public class ProductCreateLimitException extends ProductExceptionBase {
    public ProductCreateLimitException(ExceptionEnums exceptionEnums) {
        super(exceptionEnums);
    }
}
