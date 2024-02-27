package com.example.javaspringjpa.controller;

import com.example.javaspringjpa.model.request.product.CreateProductRequest;
import com.example.javaspringjpa.module.product.controller.ProductController;
import com.example.javaspringjpa.module.product.service.ProductService;
import com.fasterxml.jackson.databind.ObjectMapper;
import jakarta.transaction.Transactional;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@Transactional
public class ProductControllerTest {
    private ProductService productService;

    private ObjectMapper objectMapper;

    @Autowired
    ProductControllerTest(ProductService productService, ObjectMapper objectMapper) {
        this.productService = productService;
        this.objectMapper = objectMapper;
    }

    private MockMvc mockMvc;

    @BeforeEach
    void setUp() {
        this.mockMvc = MockMvcBuilders.standaloneSetup(new ProductController(this.productService)).build();
    }

    @Test
    public void testCreateProduct() throws Exception {
        // given
        CreateProductRequest request = CreateProductRequest.builder()
                .title("title")
                .description("description")
                .price("1000")
                .ownerId("1")
                .build();

        // when & then
        mockMvc.perform(MockMvcRequestBuilders.post("/product")
                .contentType(MediaType.APPLICATION_JSON)
                .content(objectMapper.writeValueAsString(request)))
                .andExpect(status().isCreated());
    }

    @AfterAll
    static void afterAll() {
        System.out.println("Finished all tests");
    }
}