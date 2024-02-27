package com.example.javaspringjpa.model.request.user;

import com.example.javaspringjpa.entity.User;
import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.Digits;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import static io.swagger.v3.oas.annotations.media.Schema.RequiredMode.REQUIRED;

@Schema(description = "Create Product Request")
@Getter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class CreateUserRequest {
    @Size(max = 50, message = "error.validation.email.not.valid")
    @NotBlank(message = "error.validation.email.not.blank")
    @Schema(description = "Title", example = "test@gmail.com", requiredMode = REQUIRED, type = "string")
    private String email;

    @Size(max = 200, message = "error.validation.password.not.valid")
    @NotBlank(message = "error.validation.password.not.blank")
    @Schema(description = "Password", example = "password", requiredMode = REQUIRED, type = "string")
    private String password;

    @Digits(integer = 19, fraction = 2, message = "error.validation.name.not.valid")
    @NotBlank(message = "error.validation.name.not.blank")
    @Schema(description = "Name", example = "steve", requiredMode = REQUIRED, type = "string")
    private String name;

    public User toEntity() {
        return User.builder()
                .email(email)
                .password(password)
                .name(name)
                .build();
    }
}
