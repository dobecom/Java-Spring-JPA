package com.example.javaspringjpa.domain.product.presentation.request;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.*;
import lombok.Builder;
import lombok.Getter;

import java.math.BigDecimal;

import static io.swagger.v3.oas.annotations.media.Schema.RequiredMode.REQUIRED;

@Schema(description = "Update Product Request")
@Getter
@Builder
public class UpdateProductRequest {
    @NotBlank(message = "error.validation.title.not.blank")
    @Size(max = 50, message = "error.validation.title.not.valid")
    @Schema(description = "Title", example = "product1", requiredMode = REQUIRED, type = "string")
    private final String title;

    @NotBlank(message = "error.validation.description.not.blank")
    @Size(max = 200, message = "error.validation.description.not.valid")
    @Schema(description = "Description", example = "description1", requiredMode = REQUIRED, type = "string")
    private final String description;

    @PositiveOrZero(message = "error.validation.price.must.be.positive")
    @NotNull(message = "error.validation.price.not.blank")
    @Schema(description = "Price", example = "100", requiredMode = REQUIRED, type = "number")
    private final BigDecimal price;
}
