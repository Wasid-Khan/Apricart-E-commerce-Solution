package com.example.apricart;

import com.example.apricart.entity.Product;
import com.example.apricart.repository.ProductRepository;
import com.example.apricart.service.ProductService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;

class ProductServiceTest {

    @Mock
    private ProductRepository productRepository;

    @InjectMocks
    private ProductService productService;

    private Product product;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
        product = new Product();
        product.setProductId(1L);
        product.setProductName("Test Product");
        product.setDescription("Test Description");
        product.setPrice(100.0);
        product.setBrand("Test Brand");
        product.setStatus(true);
        product.setWarehouseId(1L);
    }

    @Test
    void testCreateProduct() {
        when(productRepository.save(any(Product.class))).thenReturn(product);
        Product createdProduct = productService.createProduct(product);
        assertNotNull(createdProduct);
        assertEquals("Test Product", createdProduct.getProductName());
    }

    @Test
    void testGetProductById() {
        when(productRepository.findById(1L)).thenReturn(Optional.of(product));
        Product foundProduct = productService.getProductById(1L);
        assertNotNull(foundProduct);
        assertEquals("Test Product", foundProduct.getProductName());
    }

    @Test
    void testUpdateProduct() {
        when(productRepository.findById(1L)).thenReturn(Optional.of(product));
        when(productRepository.save(any(Product.class))).thenReturn(product);
        Product updatedProduct = productService.updateProduct(1L, product);
        assertNotNull(updatedProduct);
        assertEquals("Test Product", updatedProduct.getProductName());
    }

    @Test
    void testDeleteProduct() {
        doNothing().when(productRepository).deleteById(1L);
        productService.deleteProduct(1L);
        verify(productRepository, times(1)).deleteById(1L);
    }
}
