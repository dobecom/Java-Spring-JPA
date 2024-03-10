package com.example.javaspringjpa.domain.user.presentation.request;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.Builder;
import lombok.Getter;

import static io.swagger.v3.oas.annotations.media.Schema.RequiredMode.REQUIRED;

@Schema(description = "Create Product Request")
@Getter
@Builder
public class SignUpRequest {
    @Email(message = "error.validation.email.not.valid")
    @NotBlank(message = "error.validation.email.not.blank")
    @Schema(description = "Title", example = "test@gmail.com", requiredMode = REQUIRED, type = "string")
    private String email;

    @Size(min = 8, max = 200, message = "error.validation.password.not.valid")
    @NotBlank(message = "error.validation.password.not.blank")
    @Schema(description = "Password", example = "password", requiredMode = REQUIRED, type = "string")
    private String password;

    @NotBlank(message = "error.validation.name.not.blank")
    @Schema(description = "Name", example = "steve", requiredMode = REQUIRED, type = "string")
    private String name;
}
