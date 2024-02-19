package com.example.javaspringjpa.entity;

import com.example.javaspringjpa.entity.base.BaseEntity;
import com.example.javaspringjpa.entity.type.ProductStatus;
import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;

@Entity
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class Product extends BaseEntity {

    @Column(nullable = false)
    private String title;

    @Column(nullable = false)
    private String description;

    @Column(nullable = false)
    private BigDecimal price;

    @Column(nullable = false)
    private Long ownerId;

    @Column(nullable = false)
    private ProductStatus status = ProductStatus.WAITING;

    @Builder
    public Product(String title, String description, BigDecimal price, Long ownerId) {
        this.title = title;
        this.description = description;
        this.price = price;
        this.ownerId = ownerId;
    }

    public Long getId() {
        return super.getId();
    }
}
