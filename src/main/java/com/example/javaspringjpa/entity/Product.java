package com.example.javaspringjpa.entity;

import com.example.javaspringjpa.entity.base.BaseEntity;
import com.example.javaspringjpa.entity.type.ProductStatus;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;

@Entity
@Getter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Product extends BaseEntity {

    @Column(nullable = false)
    private String title;

    @Column(nullable = false)
    private String description;

    @Column(nullable = false)
    private BigDecimal price;

    @Column(nullable = false)
    private Long ownerId;

    @Builder.Default
    @Column(nullable = false)
    private ProductStatus status = ProductStatus.WAITING;

    public Long getId() {
        return super.getId();
    }

    public void update(String title, String description, BigDecimal price) {
        this.title = title;
        this.description = description;
        this.price = price;
    }
}
