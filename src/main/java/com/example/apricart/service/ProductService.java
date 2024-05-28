package com.example.apricart.service;

import com.example.apricart.entity.Product;
import com.example.apricart.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ProductService {

    @Autowired
    private ProductRepository productRepository;

    public Product createProduct(Product product) {
        return productRepository.save(product);
    }

    public Product updateProduct(Long productId, Product product) {
        Optional<Product> existingProduct = productRepository.findById(productId);
        if (existingProduct.isPresent()) {
            Product updatedProduct = existingProduct.get();
            updatedProduct.setProductName(product.getProductName());
            updatedProduct.setDescription(product.getDescription());
            updatedProduct.setPrice(product.getPrice());
            updatedProduct.setBrand(product.getBrand());
            updatedProduct.setStatus(product.isStatus());
            updatedProduct.setWarehouseId(product.getWarehouseId());
            return productRepository.save(updatedProduct);
        } else {
            throw new RuntimeException("Product not found with id " + productId);
        }
    }

    public void deleteProduct(Long productId) {
        productRepository.deleteById(productId);
    }

    public Product getProductById(Long productId) {
        return productRepository.findById(productId).orElseThrow(() -> new RuntimeException("Product not found with id " + productId));
    }

    public List<Product> getAllProducts() {
        return productRepository.findAll();
    }
}
