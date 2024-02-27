package com.example.javaspringjpa.model.response.user;


import com.example.javaspringjpa.model.response.Status;
import com.example.javaspringjpa.model.response.user.base.UserResponse;
import lombok.Builder;

public class CreateUserResponse extends UserResponse {
    private Long userId;

    @Override
    public Status getStatus() {
        return super.getStatus();
    }

    @Builder
    public CreateUserResponse(Long userId) {
        this.userId = userId;
    }
}
