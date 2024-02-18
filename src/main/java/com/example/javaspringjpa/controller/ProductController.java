package com.example.javaspringjpa.controller;

import com.example.javaspringjpa.model.request.GetProductRequest;
import com.example.javaspringjpa.model.response.GetProductResponse;
import com.example.javaspringjpa.service.ProductService;
import com.example.javaspringjpa.vo.ProductVO;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.ExampleObject;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;
import java.util.Optional;

@Tag(name = "product", description = "product api")
@RestController
@RequestMapping("product")
public class ProductController {
    private final ProductService productService;

    public ProductController(ProductService productService) {
        this.productService = productService;
    }

    @Operation(summary = "Get the product")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Success to get the product",
                    content = @Content(mediaType = "application/json",
                            schema = @Schema(implementation = GetProductResponse.class))
            ),
            @ApiResponse(responseCode = "400", description = "Bad Request to get the product",
                    content = @Content(mediaType = "application/json",
                            examples = @ExampleObject(
                                    value = "{\"message\": \"reason\"}"
                            ))
            ),
            @ApiResponse(responseCode = "404", description = "Not Found the product",
                    content = @Content(mediaType = "application/json",
                            examples = @ExampleObject(
                                    value = "{\"message\": \"Not found\"}"
                            ))
            ),
    })
    @GetMapping
    public ResponseEntity<?> get(@Valid GetProductRequest request) {
        Optional<ProductVO> vo = productService.get(Long.valueOf(request.getProductId()));
        if (vo.isPresent()) {
            return ResponseEntity.ok(new GetProductResponse(vo.get()));
        } else {
            return ResponseEntity.notFound().build();
        }
    }
}
