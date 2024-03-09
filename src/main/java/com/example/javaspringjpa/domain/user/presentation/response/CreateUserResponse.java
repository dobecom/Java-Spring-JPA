package com.example.javaspringjpa.domain.user.presentation.response;

import com.example.javaspringjpa.domain.user.presentation.response.base.UserResponse;
import lombok.Builder;

public class CreateUserResponse extends UserResponse {
    private Long userId;

    @Builder
    public CreateUserResponse(Long userId) {
        this.userId = userId;
    }
}
