package com.example.apricart.entity;

import jakarta.persistence.*;

@Entity
@Table(name = "Product")
public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long productId;

    private String productName;
    private String description;
    private Double price;
    private String brand;
    private Boolean status;
    private Long warehouseId;

    // Getters and Setters
    public Product() {

    }
    public Product(String productName, String description, Double price, String brand, Boolean status, Long warehouseId) {
        this.productName = productName;
        this.description = description;
        this.price = price;
        this.brand = brand;
        this.status = status;
        this.warehouseId = warehouseId;
    }
    public Long getProductId() {
        return productId;
    }
    public void setProductId(Long productId) {
        this.productId = productId;
    }
    public String getProductName() {
        return productName;
    }
    public void setProductName(String productName) {
        this.productName = productName;
    }
    public String getDescription() {
        return description;
    }
    public void setDescription(String description) {
        this.description = description;
    }
    public Double getPrice() {
        return price;
    }
    public void setPrice(Double price) {
        this.price = price;
    }
    public String getBrand() {
        return brand;
    }
    public void setBrand(String brand) {
        this.brand = brand;
    }
    public Boolean getStatus() {
        return status;
    }
    public void setStatus(Boolean status) {
        this.status = status;
    }
    public Long getWarehouseId() {
        return warehouseId;
    }
    public void setWarehouseId(Long warehouseId) {
        this.warehouseId = warehouseId;
    }

    public Boolean isStatus() {
        return status;
    }
}
