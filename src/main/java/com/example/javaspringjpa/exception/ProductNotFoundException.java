package com.example.javaspringjpa.exception;


import com.example.javaspringjpa.exception.base.BusinessException;

public class ProductNotFoundException extends BusinessException {

    private static final long serialVersionUID = -486215695733992820L;

    public ProductNotFoundException() {
        super("error.exception.product.not.found");
    }
}
