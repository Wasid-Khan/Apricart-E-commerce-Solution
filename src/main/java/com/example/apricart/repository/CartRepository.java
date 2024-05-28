package com.example.apricart.repository;

import com.example.apricart.entity.Cart;
import com.example.apricart.entity.Warehouse;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface CartRepository extends JpaRepository<Cart, Long> {
    List<Cart> findByUserId(String userId);

    List <Warehouse> findByCapacity (Integer capacity);
}
