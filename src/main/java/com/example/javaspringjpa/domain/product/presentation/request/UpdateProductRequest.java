package com.example.javaspringjpa.domain.product.presentation.request;

import com.example.javaspringjpa.domain.product.presentation.request.base.ProductRequest;
import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.Digits;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;

import static io.swagger.v3.oas.annotations.media.Schema.RequiredMode.REQUIRED;

@Schema(description = "Update Product Request")
@Getter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class UpdateProductRequest implements ProductRequest {
    @Size(max = 50, message = "error.validation.title.not.valid")
    @NotBlank(message = "error.validation.title.not.blank")
    @Schema(description = "Title", example = "product1", requiredMode = REQUIRED, type = "string")
    private String title;

    @Size(max = 200, message = "error.validation.description.not.valid")
    @NotBlank(message = "error.validation.description.not.blank")
    @Schema(description = "Description", example = "description1", requiredMode = REQUIRED, type = "string")
    private String description;

    @Digits(integer = 19, fraction = 2, message = "error.validation.price.not.valid")
    @NotBlank(message = "error.validation.price.not.blank")
    @Schema(description = "Price", example = "100", requiredMode = REQUIRED, type = "string")
    private BigDecimal price;
}
