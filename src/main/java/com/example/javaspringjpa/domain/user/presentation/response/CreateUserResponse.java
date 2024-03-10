package com.example.javaspringjpa.domain.user.presentation.response;

import lombok.Builder;
import lombok.Getter;

@Getter
@Builder
public class CreateUserResponse {
    private final Long userId;
}
