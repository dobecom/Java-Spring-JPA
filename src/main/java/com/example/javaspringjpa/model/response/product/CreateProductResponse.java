package com.example.javaspringjpa.model.response.product;


import com.example.javaspringjpa.model.response.Status;
import com.example.javaspringjpa.model.response.product.base.ProductResponse;
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
