package com.example.javaspringjpa.domain.product.controller;

import com.example.javaspringjpa.common.presentation.request.ListIdRequest;
import com.example.javaspringjpa.domain.product.presentation.request.CreateProductRequest;
import com.example.javaspringjpa.domain.product.presentation.request.UpdateProductRequest;
import com.example.javaspringjpa.domain.product.presentation.response.CreateProductResponse;
import com.example.javaspringjpa.domain.product.presentation.response.GetProductResponse;
import com.example.javaspringjpa.domain.product.service.ProductService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.media.ArraySchema;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.ExampleObject;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Tag(name = "product", description = "product api")
@RestController
@RequestMapping("product")
@RequiredArgsConstructor
public class ProductController {
    private final ProductService productService;

    @Operation(summary = "Create the product")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "201", description = "Success to create the product",
                    content = @Content(mediaType = "application/json",
                            schema = @Schema(implementation = CreateProductResponse.class))
            )
    })
    @PostMapping
    public ResponseEntity<?> create(@RequestBody @Valid CreateProductRequest request) {
        CreateProductResponse response = productService.create(request);
        return ResponseEntity
                .status(HttpStatus.CREATED)
                .body(response);
    }

    @Operation(summary = "Get product list")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Success to get the product list",
                    content = @Content(mediaType = "application/json",
                            array = @ArraySchema(
                                    schema = @Schema(implementation = GetProductResponse.class)
                            ))
            ),
            @ApiResponse(responseCode = "400", description = "Bad Request the product list",
                    content = @Content(mediaType = "application/json",
                            examples = @ExampleObject(
                                    value = "{\"message\": \"reason\"}"
                            ))
            ),
            @ApiResponse(responseCode = "404", description = "Not found the product list",
                    content = @Content(mediaType = "application/json",
                            examples = @ExampleObject(
                                    value = "{\"message\": \"Not found\"}"
                            ))
            ),
    })
    @GetMapping
    public ResponseEntity<?> list(@RequestParam(required = false, defaultValue = "0", value = "page") int page,
                                  @RequestParam(required = false, defaultValue = "20", value = "pageSize") int pageSize) {
        List<GetProductResponse> list = productService.list(page, pageSize);
        return ResponseEntity
                .status(HttpStatus.OK)
                .body(list);
    }

    @Operation(summary = "Get the product")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Success to get the product",
                    content = @Content(mediaType = "application/json",
                            schema = @Schema(implementation = GetProductResponse.class))
            ),
            @ApiResponse(responseCode = "400", description = "Bad Request the product",
                    content = @Content(mediaType = "application/json",
                            examples = @ExampleObject(
                                    value = "{\"message\": \"reason\"}"
                            ))
            ),
            @ApiResponse(responseCode = "404", description = "Not found the product",
                    content = @Content(mediaType = "application/json",
                            examples = @ExampleObject(
                                    value = "{\"message\": \"Not found\"}"
                            ))
            ),
    })
    @GetMapping("{id}")
    public ResponseEntity<?> findProduct(
            @Parameter(description = "product id", example = "1")
            @PathVariable(name = "id", required = true) Long id
    ) {
        GetProductResponse product = productService.findProductById(id);
        return ResponseEntity
                .status(HttpStatus.OK)
                .body(product);
    }

    @Operation(summary = "Delete products")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Success to delete products"),
            @ApiResponse(responseCode = "404", description = "Product not found",
                    content = @Content(mediaType = "application/json",
                            examples = @ExampleObject(
                                    value = "{\"message\": \"Not found\"}"
                            ))
            ),
    })
    @DeleteMapping()
    public ResponseEntity<?> deleteProducts(@RequestBody ListIdRequest request) {
        productService.deleteProducts(request.getListIds());
        return ResponseEntity
                .status(HttpStatus.OK)
                .build();
    }

    @Operation(summary = "Update the product")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Success to update the product"),
            @ApiResponse(responseCode = "404", description = "Product not found",
                    content = @Content(mediaType = "application/json",
                            examples = @ExampleObject(
                                    value = "{\"message\": \"Not found\"}"
                            ))
            ),
    })
    @PatchMapping("{id}")
    public ResponseEntity<?> updateProduct(
            @Parameter(description = "product id", example = "1")
            @PathVariable(name = "id", required = true) Long id,
            @RequestBody @Valid UpdateProductRequest request
    ) {
        productService.updateProduct(id, request);
        return ResponseEntity
                .status(HttpStatus.OK)
                .build();
    }
}
