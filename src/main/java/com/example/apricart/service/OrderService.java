package com.example.apricart.service;

import com.example.apricart.entity.Order;
import com.example.apricart.repository.OrderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class OrderService {

    @Autowired
    private OrderRepository orderRepository;

    public Order placeOrder(Order order) {
        return orderRepository.save(order);
    }

    public Order updateOrderStatus(Long orderId, String status) {
        Optional<Order> order = orderRepository.findById(orderId);
        if (order.isPresent()) {
            Order existingOrder = order.get();
            existingOrder.setStatus(status);
            return orderRepository.save(existingOrder);
        } else {
            // Handle the case where the order is not found
            return null;
        }
    }

    public Order getOrderByUserId(String userId) {
        return orderRepository.findByUserId(userId);
    }

    public Order getOrderById(Long orderId) {
        return orderRepository.findById(orderId).orElse(null);
    }

    public void cancelOrder(Long orderId) {
        orderRepository.deleteById(orderId);
    }

    public Double getOrderTotal(Long orderId) {
        Optional<Order> order = orderRepository.findById(orderId);
        return order.map(value -> value.getQuantity() * value.getProduct().getPrice()).orElse(0.0);
    }

    public List<Order> getOrdersByUserId(String userId) {
        return getOrdersByUserId(userId);
    }
}
