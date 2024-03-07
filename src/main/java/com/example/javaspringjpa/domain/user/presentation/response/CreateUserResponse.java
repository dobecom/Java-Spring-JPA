package com.example.javaspringjpa.domain.user.presentation.response;


import com.example.javaspringjpa.common.presentation.response.Status;
import com.example.javaspringjpa.domain.user.presentation.response.base.UserResponse;
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
