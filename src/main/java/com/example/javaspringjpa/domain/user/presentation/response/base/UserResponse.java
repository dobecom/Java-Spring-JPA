package com.example.javaspringjpa.domain.user.presentation.response.base;

import com.example.javaspringjpa.common.presentation.response.Status;

public abstract class UserResponse {

    private static final Status status = Status.SUCCESS;

    protected Status getStatus() {
        return status;
    }
}
