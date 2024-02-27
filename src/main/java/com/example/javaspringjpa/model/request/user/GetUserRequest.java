package com.example.javaspringjpa.model.request.user;

import javax.validation.constraints.NotBlank;

public class GetUserRequest {

    @NotBlank(message = "error.validation.user.id.not.blank")
    private String userId;

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    @Override
    public String toString() {
        return "GetUserRequest{" +
                "userId='" + userId + '\'' +
                '}';
    }
}
