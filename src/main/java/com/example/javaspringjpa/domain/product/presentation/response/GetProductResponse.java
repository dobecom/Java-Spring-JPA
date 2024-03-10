package com.example.javaspringjpa.domain.product.presentation.response;

import lombok.Builder;
import lombok.Getter;

import java.math.BigDecimal;

@Getter
@Builder
public class GetProductResponse {
    private final Long productId;
    private final String title;
    private final String description;
    private final BigDecimal price;
    private final Long ownerId;
}
