package com.example.javaspringjpa.domain.product.service;

import com.example.javaspringjpa.entity.Product;
import com.example.javaspringjpa.domain.product.presentation.request.CreateProductRequest;
import com.example.javaspringjpa.domain.product.presentation.request.UpdateProductRequest;
import com.example.javaspringjpa.domain.product.presentation.response.CreateProductResponse;
import com.example.javaspringjpa.domain.product.presentation.response.GetProductResponse;
import com.example.javaspringjpa.domain.product.repository.ProductQuerydslRepository;
import com.example.javaspringjpa.domain.product.repository.ProductRepository;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;

@RequiredArgsConstructor
@Service
public class ProductService {

    private final ProductRepository productRepository;
    private final ProductQuerydslRepository productQuerydslRepository;

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

    public GetProductResponse findProductById(Long id) {
        Optional<Product> product = productRepository.findById(id);
        if (product.isPresent()) {
            return GetProductResponse.builder()
                    .productId(product.get().getId())
                    .title(product.get().getTitle())
                    .description(product.get().getDescription())
                    .price(product.get().getPrice())
                    .ownerId(product.get().getOwnerId())
                    .build();
        } else {
            throw new NoSuchElementException();
        }
    }

    @Transactional
    public void deleteProducts(List<Long> listIds) {
        try {
            Long count = productQuerydslRepository.deleteByIds(listIds);
            if (count != listIds.size()) {
                throw new NoSuchElementException("Product not found");
            }
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    @Transactional
    public void updateProduct(Long id, UpdateProductRequest request) {
        Optional<Product> product = productRepository.findById(id);
        if (product.isPresent()) {
            product.get().update(request.getTitle(), request.getDescription(), request.getPrice());
        } else {
            throw new IllegalArgumentException("Product not found" + id);
        }
    }
}
