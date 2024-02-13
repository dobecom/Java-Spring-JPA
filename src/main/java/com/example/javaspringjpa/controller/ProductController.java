package com.example.javaspringjpa.controller;

import com.example.javaspringjpa.model.request.GetProductRequest;
import com.example.javaspringjpa.model.response.GetProductResponse;
import com.example.javaspringjpa.service.ProductService;
import com.example.javaspringjpa.vo.ProductVO;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;
import java.util.Optional;

@RestController
@RequestMapping("product")
public class ProductController {
    private final ProductService productService;

    public ProductController(ProductService productService) {
        this.productService = productService;
    }

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
