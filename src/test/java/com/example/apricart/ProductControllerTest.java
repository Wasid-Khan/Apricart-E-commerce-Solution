package com.example.apricart;

import com.example.apricart.controller.ProductController;
import com.example.apricart.entity.Product;
import com.example.apricart.service.ProductService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import static org.mockito.Mockito.any;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

class ProductControllerTest {

    @Mock
    private ProductService productService;

    @InjectMocks
    private ProductController productController;

    private MockMvc mockMvc;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
        mockMvc = MockMvcBuilders.standaloneSetup(productController).build();
    }

    @Test
    void testCreateProduct() throws Exception {
        Product product = new Product();
        product.setProductName("Test Product");

        when(productService.createProduct(any(Product.class))).thenReturn(product);

        mockMvc.perform(post("/products")
                .contentType(MediaType.APPLICATION_JSON)
                .content("{\"productName\": \"Test Product\"}"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.productName").value("Test Product"));
    }

    // Similar tests for updateProduct, deleteProduct, getProductById
}
