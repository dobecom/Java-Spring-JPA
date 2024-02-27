package com.example.javaspringjpa.module.user.repository;

import com.example.javaspringjpa.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {

}
