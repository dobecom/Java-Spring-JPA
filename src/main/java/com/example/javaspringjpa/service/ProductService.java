package com.example.javaspringjpa.service;

import com.example.javaspringjpa.entity.Product;
import com.example.javaspringjpa.repository.ProductRepository;
import com.example.javaspringjpa.vo.ProductVO;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class ProductService {

    private final ProductRepository productRepository;

    public ProductService(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    public Optional<ProductVO> get(Long productId) {
        Optional<Product> product = productRepository.findById(productId);
        if (product.isPresent()) {
            ProductVO vo = new ProductVO();
            vo.setTitle(product.get().getTitle());
            vo.setDescription(product.get().getDescription());
            vo.setPrice(product.get().getPrice());
            vo.setOwnerId(product.get().getOwnerId());
            vo.setStatus(product.get().getStatus());
            return Optional.of(vo);
        } else {
            return Optional.empty();
        }

    }
}
