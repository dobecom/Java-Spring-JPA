package com.example.javaspringjpa.domain.user.presentation.response;

import lombok.Builder;
import lombok.Getter;

@Getter
@Builder
public class GetUserResponse {
    private final String email;
    private final String name;
}
