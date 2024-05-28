package com.example.apricart.entity;

import jakarta.persistence.*;

@Entity
@Table(name = "Coupon")
public class Coupon {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long couponId;

    private String couponCode;
    private Double discountAmount;
    private Double minOrderAmount;
    private String city;
    private Long warehouseId;
    private Boolean isActive;

    // Getters and Setters
    public Coupon() {

    }
    public Coupon (String couponCode, Double discountAmount, Double minOrderAmount, String city, Long warehouseId, Boolean isActive) {
        this.couponCode = couponCode;
        this.discountAmount = discountAmount;
        this.minOrderAmount = minOrderAmount;
        this.city = city;
        this.warehouseId = warehouseId;
        this.isActive = isActive;
    }
    public Long getCouponId() {
        return couponId;
    }
    public void setCouponId(Long couponId) {
        this.couponId = couponId;
    }
    public String getCouponCode() {
        return couponCode;
    }
    public void setCouponCode(String couponCode) {
        this.couponCode = couponCode;
    }
    public Double getDiscountAmount() {
        return discountAmount;
    }
    public void setDiscountAmount(Double discountAmount) {
        this.discountAmount = discountAmount;
    }
    public Double getMinOrderAmount() {
        return minOrderAmount;
    }
    public void setMinOrderAmount(Double minOrderAmount) {
        this.minOrderAmount = minOrderAmount;
    }
    public String getCity() {
        return city;
    }
    public void setCity(String city) {
        this.city = city;
    }
    public Long getWarehouseId() {
        return warehouseId;
    }
    public void setWarehouseId(Long warehouseId) {
        this.warehouseId = warehouseId;
    }
    public Boolean getIsActive() {
        return isActive;
    }

}
