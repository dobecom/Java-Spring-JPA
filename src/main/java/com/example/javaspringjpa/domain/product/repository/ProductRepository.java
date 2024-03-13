package com.example.javaspringjpa.domain.product.repository;

import com.example.javaspringjpa.entity.Product;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductRepository extends JpaRepository<Product, Long> {
    Long countByOwnerId(Long ownerId);
}
