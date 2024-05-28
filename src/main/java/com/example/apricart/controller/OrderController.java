package com.example.apricart.controller;

import com.example.apricart.entity.Order;
import com.example.apricart.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/orders")
public class OrderController {

    @Autowired
    private OrderService orderService;

    @PostMapping
    public ResponseEntity<Order> placeOrder(@RequestBody Order order) {
        Order placedOrder = orderService.placeOrder(order);
        return ResponseEntity.ok(placedOrder);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Order> updateOrderStatus(@PathVariable Long id, @RequestBody String status) {
        Order updatedOrder = orderService.updateOrderStatus(id, status);
        if (updatedOrder != null) {
            return ResponseEntity.ok(updatedOrder);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @GetMapping("/user/{userId}")
    public ResponseEntity<List<Order>> getOrdersByUserId(@PathVariable String userId) {
        List<Order> orders = orderService.getOrdersByUserId(userId);
        return ResponseEntity.ok(orders);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Order> getOrderById(@PathVariable Long id) {
        Order order = orderService.getOrderById(id);
        if (order != null) {
            return ResponseEntity.ok(order);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> cancelOrder(@PathVariable Long id) {
        orderService.cancelOrder(id);
        return ResponseEntity.noContent().build();
    }

    @GetMapping("/total/{id}")
    public ResponseEntity<Double> getOrderTotal(@PathVariable Long id) {
        Double total = orderService.getOrderTotal(id);
        return ResponseEntity.ok(total);
    }
}
