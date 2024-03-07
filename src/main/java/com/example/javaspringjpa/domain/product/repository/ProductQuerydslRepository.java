package com.example.javaspringjpa.domain.product.repository;

import com.querydsl.jpa.impl.JPAQueryFactory;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

import java.util.List;

import static com.example.javaspringjpa.entity.QProduct.product;

@Repository
@RequiredArgsConstructor
public class ProductQuerydslRepository {
    private final JPAQueryFactory queryFactory;

    public Long deleteByIds(List<Long> listIds) {
        return queryFactory
                .delete(product)
                .where(product.id.in(listIds))
                .execute();
    }
}