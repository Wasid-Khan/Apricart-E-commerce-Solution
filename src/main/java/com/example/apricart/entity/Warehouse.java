package com.example.apricart.entity;

import jakarta.persistence.*;

@Entity
@Table(name = "Warehouse")
public class Warehouse {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long warehouseId;

    private String warehouseName;
    private String location;
    private Integer capacity;
    private Integer availableCapacity;

    // Getters and Setters
    public Warehouse() {

    }
    public Warehouse(Long warehouseId, String warehouseName, String location, Integer capacity, Integer availableCapacity) {
        this.warehouseId = warehouseId;
        this.warehouseName = warehouseName;
        this.location = location;
        this.capacity = capacity;
        this.availableCapacity = availableCapacity;

    }
    public Long getWarehouseId() {
        return warehouseId;
    }
    public void setWarehouseId(Long warehouseId) {
        this.warehouseId = warehouseId;
    }
    public String getWarehouseName() {
        return warehouseName;
    }
    public void setWarehouseName(String warehouseName) {
        this.warehouseName = warehouseName;
    }
    public String getLocation() {
        return location;
    }
    public void setLocation(String location) {
        this.location = location;
    }
    public Integer getCapacity() {
        return capacity;
    }
    public void setCapacity(Integer capacity) {
        this.capacity = capacity;
    }
    public Integer getAvailableCapacity() {
        return availableCapacity;
    }
    public void setAvailableCapacity(Integer availableCapacity) {
        this.availableCapacity = availableCapacity;
    }

}
