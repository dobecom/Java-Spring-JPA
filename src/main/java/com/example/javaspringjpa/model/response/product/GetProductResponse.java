package com.example.javaspringjpa.model.response.product;

import com.example.javaspringjpa.model.response.Status;
import com.example.javaspringjpa.model.response.product.base.ProductResponse;
import lombok.Builder;
import lombok.Getter;

import java.math.BigDecimal;

@Getter
public class GetProductResponse extends ProductResponse {
    private Long productId;
    private String title;
    private String description;
    private BigDecimal price;
    private Long ownerId;


    @Builder
    public GetProductResponse(Long productId, String title, String description, BigDecimal price, Long ownerId) {
        this.productId = productId;
        this.title = title;
        this.description = description;
        this.price = price;
        this.ownerId = ownerId;
    }

    @Override
    public Status getStatus() {
        return super.getStatus();
    }

}