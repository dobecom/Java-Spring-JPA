package com.example.javaspringjpa.domain.user.presentation.request;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import static io.swagger.v3.oas.annotations.media.Schema.RequiredMode.REQUIRED;

@Schema(description = "Sign In Request")
@Getter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class SignInRequest {
    @Email(message = "error.validation.email.not.valid")
    @NotBlank(message = "error.validation.email.not.blank")
    @Schema(description = "Email", example = "test@gmail.com", requiredMode = REQUIRED, type = "string")
    private String email;

    @Size(min = 8, max = 30, message = "error.validation.password.not.valid")
    @NotBlank(message = "error.validation.password.not.blank")
    @Schema(description = "Password", example = "password", requiredMode = REQUIRED, type = "string")
    private String password;
}
