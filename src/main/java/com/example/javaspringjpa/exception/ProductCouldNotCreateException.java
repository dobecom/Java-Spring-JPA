package com.example.javaspringjpa.exception;


import com.example.javaspringjpa.exception.base.BusinessException;

public class ProductCouldNotCreateException extends BusinessException {

    private static final long serialVersionUID = -486215695733992820L;

    public ProductCouldNotCreateException() {
        super("error.exception.product.could.not.create");
    }
}
