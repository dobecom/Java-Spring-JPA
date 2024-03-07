package com.example.javaspringjpa.domain.product.presentation.response.base;

import com.example.javaspringjpa.common.presentation.response.Status;

public abstract class ProductResponse {

    private static final Status status = Status.SUCCESS;

    protected Status getStatus() {
        return status;
    }
}
