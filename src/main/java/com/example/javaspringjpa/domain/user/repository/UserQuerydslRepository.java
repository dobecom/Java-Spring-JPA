package com.example.javaspringjpa.domain.user.repository;

import com.querydsl.jpa.impl.JPAQueryFactory;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;


@Repository
@RequiredArgsConstructor
public class UserQuerydslRepository {
    private final JPAQueryFactory queryFactory;

//    public Long deleteByIds(List<Long> listIds) {
//        return queryFactory
//                .delete(user)
//                .where(user.id.in(listIds))
//                .execute();
//    }
}