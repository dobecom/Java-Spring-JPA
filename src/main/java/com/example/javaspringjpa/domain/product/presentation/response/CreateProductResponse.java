package com.example.javaspringjpa.domain.product.presentation.response;

import lombok.Builder;
import lombok.Getter;

@Getter
@Builder
public class CreateProductResponse {
    private final Long productId;
}
