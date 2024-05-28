package com.example.apricart.entity;
import jakarta.persistence.*;

@Entity
@Table(name = "Cart")
public class Cart {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long cartId;

    private String userId;
    private Long productId;
    private Integer quantity;
    private Long warehouseId;

    // Getters and Setters
    public Cart() {

    }
    public Cart(String userId, Long productId, Integer quantity, Long warehouseId) {
        this.userId = userId;
        this.productId = productId;
        this.quantity = quantity;
        this.warehouseId = warehouseId;
    }
    public Long getCartId() {
        return cartId;
    }
    public void setCartId(Long cartId) {
        this.cartId = cartId;
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
