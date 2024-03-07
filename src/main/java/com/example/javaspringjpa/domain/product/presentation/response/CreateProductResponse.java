package com.example.javaspringjpa.domain.product.presentation.response;


import com.example.javaspringjpa.common.presentation.response.Status;
import com.example.javaspringjpa.domain.product.presentation.response.base.ProductResponse;
import lombok.Builder;

public class CreateProductResponse extends ProductResponse {
    private Long productId;

    @Override
    public Status getStatus() {
        return super.getStatus();
    }

    @Builder
    public CreateProductResponse(Long productId) {
        this.productId = productId;
    }
}
