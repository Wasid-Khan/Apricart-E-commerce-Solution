package com.example.apricart.entity;

import jakarta.persistence.*;

@Entity
@Table(name = "OrderEntity")
public class Order {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long orderId;

    private String userId;
    private Long productId;
    private Integer quantity;
    private Double totalPrice;
    private String status;
    private Long warehouseId;

    // Getters and Setters
    public Order() {

    }
    public Order(Long orderId, String userId, Long productId, Integer quantity, Double totalPrice, String status) {
        this.orderId = orderId;
        this.userId = userId;
        this.productId = productId;
        this.quantity = quantity;
        this.totalPrice = totalPrice;
        this.status = status;
    }
    public Long getOrderId() {
        return orderId;
    }
    public void setOrderId(Long orderId) {
        this.orderId = orderId;
    }
    public String getUserId() {
        return userId;
    }
    public void setUserId(String userId) {
        this.userId = userId;
    }
    public Long getProductId() {
        return productId;
    }
    public void setProductId(Long productId) {
        this.productId = productId;
    }
    public Integer getQuantity() {
        return quantity;
    }
    public void setQuantity(Integer quantity) {
        this.quantity = quantity;
    }
    public Double getTotalPrice() {
        return totalPrice;
    }
    public void setTotalPrice(Double totalPrice) {
        this.totalPrice = totalPrice;
    }
    public String getStatus() {
        return status;
    }
    public void setStatus(String status) {
        this.status = status;
    }
    public Long getWarehouseId() {
        return warehouseId;
    }
    public void setWarehouseId(Long warehouseId) {
        this.warehouseId = warehouseId;
    }

    public Product getProduct() {
        Product product = new Product();
        product.setProductId(productId);
        return product;
    }
}
