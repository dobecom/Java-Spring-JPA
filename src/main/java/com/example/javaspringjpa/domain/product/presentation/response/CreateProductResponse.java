package com.example.javaspringjpa.domain.product.presentation.response;

import com.example.javaspringjpa.domain.product.presentation.response.base.ProductResponse;
import lombok.Builder;

public class CreateProductResponse extends ProductResponse {
    private Long productId;

    @Builder
    public CreateProductResponse(Long productId) {
        this.productId = productId;
    }
}
