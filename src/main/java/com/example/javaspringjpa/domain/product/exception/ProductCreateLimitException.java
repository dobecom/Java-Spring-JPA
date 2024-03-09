package com.example.javaspringjpa.domain.product.exception;

public class ProductCreateLimitException extends RuntimeException {
    public ProductCreateLimitException() {
        super("Not allowed to create more than 5 products. ");
    }
}
