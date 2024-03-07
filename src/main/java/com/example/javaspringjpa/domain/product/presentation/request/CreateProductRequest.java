package com.example.javaspringjpa.domain.product.presentation.request;

import com.example.javaspringjpa.entity.Product;
import com.example.javaspringjpa.domain.product.presentation.request.base.ProductRequest;
import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.Digits;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.*;

import static io.swagger.v3.oas.annotations.media.Schema.RequiredMode.REQUIRED;

@Schema(description = "Create Product Request")
@Getter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class CreateProductRequest implements ProductRequest {
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
    private String price;

    @NotBlank(message = "error.validation.owner.id.not.blank")
    @Schema(description = "Owner Id", example = "1", requiredMode = REQUIRED, type = "long")
    private String ownerId;

    public Product toEntity() {
        return Product.builder()
                .title(title)
                .description(description)
                .price(new java.math.BigDecimal(price))
                .ownerId(Long.parseLong(ownerId))
                .build();
    }
}
