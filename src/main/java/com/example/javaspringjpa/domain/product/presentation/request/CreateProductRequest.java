package com.example.javaspringjpa.domain.product.presentation.request;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.*;
import lombok.*;

import java.math.BigDecimal;

import static io.swagger.v3.oas.annotations.media.Schema.RequiredMode.REQUIRED;

@Schema(description = "Create Product Request")
@Getter
@Builder
public class CreateProductRequest {
    @NotBlank(message = "error.validation.title.not.blank")
    @Size(max = 50, message = "error.validation.title.not.valid")
    @Schema(description = "Title", example = "product1", requiredMode = REQUIRED, type = "string")
    private final String title;

    @NotBlank(message = "error.validation.description.not.blank")
    @Size(max = 200, message = "error.validation.description.not.valid")
    @Schema(description = "Description", example = "description1", requiredMode = REQUIRED, type = "string")
    private final String description;

    @NotNull(message = "error.validation.price.not.blank")
    @PositiveOrZero(message = "error.validation.price.must.be.positive")
    @Digits(integer = 19, fraction = 2, message = "error.validation.price.not.valid")
    @Schema(description = "Price", example = "100", requiredMode = REQUIRED, type = "number")
    private final BigDecimal price;

    @NotNull(message = "error.validation.ownerId.not.blank")
    @Schema(description = "Owner Id", example = "1", requiredMode = REQUIRED, type = "integer")
    private final Long ownerId;
}
