package com.example.javaspringjpa.entity.base;

import jakarta.persistence.*;
import org.springframework.data.annotation.LastModifiedBy;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import java.util.Date;

//@MappedSuperclass
//@EntityListeners(AuditingEntityListener.class)
public abstract class MutableBaseEntity extends BaseEntity {
//    @LastModifiedDate
//    @Column(updatable = true)
//    private Date updatedAt;
//
//    @LastModifiedBy
//    @Column(updatable = true)
//    private String modifiedBy;
}
