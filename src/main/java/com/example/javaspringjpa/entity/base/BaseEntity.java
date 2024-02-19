package com.example.javaspringjpa.entity.base;

import jakarta.persistence.*;
import lombok.Getter;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;

import java.time.Instant;
import java.util.Date;

@Getter
@MappedSuperclass
public abstract class BaseEntity {
    @Id
    @Column
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    @CreatedDate
    protected Date createdAt = Date.from(Instant.now());

    @Column(nullable = false)
    @LastModifiedDate
    protected Date updatedAt = Date.from(Instant.now());
}
