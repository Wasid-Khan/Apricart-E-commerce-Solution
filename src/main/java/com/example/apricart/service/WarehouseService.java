package com.example.apricart.service;

import com.example.apricart.entity.Warehouse;
import com.example.apricart.repository.WarehouseRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class WarehouseService {

    @Autowired
    private WarehouseRepository warehouseRepository;

    public Warehouse createWarehouse(Warehouse warehouse) {
        return warehouseRepository.save(warehouse);
    }

    public Warehouse updateWarehouse(Long warehouseId, Warehouse warehouseDetails) {
        return warehouseRepository.findById(warehouseId)
                .map(warehouse -> {
                    warehouse.setWarehouseName(warehouseDetails.getWarehouseName());
                    warehouse.setLocation(warehouseDetails.getLocation());
                    warehouse.setCapacity(warehouseDetails.getCapacity());
                    warehouse.setAvailableCapacity(warehouseDetails.getAvailableCapacity());
                    return warehouseRepository.save(warehouse);
                })
                .orElse(null);
    }

    public void deleteWarehouse(Long warehouseId) {
        warehouseRepository.deleteById(warehouseId);
    }

    public Warehouse getWarehouseById(Long warehouseId) {
        return warehouseRepository.findById(warehouseId).orElse(null);
    }

    public List<Warehouse> getAllWarehouses() {
        return warehouseRepository.findAll();
    }

}
