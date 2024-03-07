package com.example.javaspringjpa.domain.user.presentation.response;

import com.example.javaspringjpa.common.presentation.response.Status;
import com.example.javaspringjpa.domain.user.presentation.response.base.UserResponse;
import lombok.Builder;
import lombok.Getter;

@Getter
public class GetUserResponse extends UserResponse {
    private String email;
    private String name;

    @Builder
    public GetUserResponse(String email, String name) {
        this.email = email;
        this.name = name;
    }

    @Override
    public Status getStatus() {
        return super.getStatus();
    }

}
