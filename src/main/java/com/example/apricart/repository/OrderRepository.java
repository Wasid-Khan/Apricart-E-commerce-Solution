package com.example.apricart.repository;

import com.example.apricart.entity.Order;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OrderRepository extends JpaRepository<Order, Long> {
    Order findByUserId(String userId);

}
