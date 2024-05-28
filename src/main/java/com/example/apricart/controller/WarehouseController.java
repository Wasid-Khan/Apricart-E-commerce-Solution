package com.example.apricart.controller;

import com.example.apricart.entity.Warehouse;
import com.example.apricart.service.WarehouseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/warehouses")
public class WarehouseController {

    @Autowired
    private WarehouseService warehouseService;

    @PostMapping
    public ResponseEntity<Warehouse> createWarehouse(@RequestBody Warehouse warehouse) {
        Warehouse createdWarehouse = warehouseService.createWarehouse(warehouse);
        return ResponseEntity.ok(createdWarehouse);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Warehouse> updateWarehouse(@PathVariable Long id, @RequestBody Warehouse warehouseDetails) {
        Warehouse updatedWarehouse = warehouseService.updateWarehouse(id, warehouseDetails);
        if (updatedWarehouse != null) {
            return ResponseEntity.ok(updatedWarehouse);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteWarehouse(@PathVariable Long id) {
        warehouseService.deleteWarehouse(id);
        return ResponseEntity.noContent().build();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Warehouse> getWarehouseById(@PathVariable Long id) {
        Warehouse warehouse = warehouseService.getWarehouseById(id);
        if (warehouse != null) {
            return ResponseEntity.ok(warehouse);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @GetMapping
    public ResponseEntity<List<Warehouse>> getAllWarehouses() {
        List<Warehouse> warehouses = warehouseService.getAllWarehouses();
        return ResponseEntity.ok(warehouses);
    }
}
