package com.example.javaspringjpa.model.response.user.base;

import com.example.javaspringjpa.model.response.Status;

public abstract class UserResponse {

    private static final Status status = Status.SUCCESS;

    protected Status getStatus() {
        return status;
    }
}
