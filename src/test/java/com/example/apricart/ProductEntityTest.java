package com.example.apricart;
import com.example.apricart.entity.Product;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

class ProductEntityTest {

    @Test
    void testProductEntity() {
        Product product = new Product();
        product.setProductId(1L);
        product.setProductName("Test Product");
        product.setDescription("Test Description");
        product.setPrice(100.0);
        product.setBrand("Test Brand");
        product.setStatus(true);
        product.setWarehouseId(1L);

        assertNotNull(product);
        assertEquals(1L, product.getProductId());
        assertEquals("Test Product", product.getProductName());
        assertEquals("Test Description", product.getDescription());
        assertEquals(100.0, product.getPrice());
        assertEquals("Test Brand", product.getBrand());
        assertEquals(true, product.getStatus());
        assertEquals(1L, product.getWarehouseId());
    }
}
