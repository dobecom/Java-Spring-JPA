package com.example.javaspringjpa.model.response.user;

import com.example.javaspringjpa.model.response.Status;
import com.example.javaspringjpa.model.response.user.base.UserResponse;
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
