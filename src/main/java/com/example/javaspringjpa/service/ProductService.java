package com.example.javaspringjpa.service;

import com.example.javaspringjpa.entity.Product;
import com.example.javaspringjpa.model.request.product.CreateProductRequest;
import com.example.javaspringjpa.model.response.product.CreateProductResponse;
import com.example.javaspringjpa.model.response.product.GetProductResponse;
import com.example.javaspringjpa.repository.ProductRepository;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ProductService {

    private final ProductRepository productRepository;

    public ProductService(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    public CreateProductResponse create(CreateProductRequest request) {
        final Product product = productRepository.save(request.toEntity());

        return CreateProductResponse.builder()
                .productId(product.getId())
                .build();
    }

    public List<GetProductResponse> list(int page, int pageSize) {
        Pageable pageable = PageRequest.of(page, pageSize, Sort.by(Sort.Direction.ASC, "title"));
        Page<Product> result = productRepository.findAll(pageable);

        return result.getContent().stream().map(
                product -> GetProductResponse.builder()
                        .productId(product.getId())
                        .title(product.getTitle())
                        .description(product.getDescription())
                        .price(product.getPrice())
                        .ownerId(product.getOwnerId())
                        .build()
        ).toList();
    }
}
