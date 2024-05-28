package com.example.apricart.service;

import org.springframework.stereotype.Service;

@Service
public class NotificationService {

    public void sendOrderConfirmation(String userId, String orderId) {
        // Implement email or SMS notification logic here
        // This is a placeholder implementation
        System.out.println("Order confirmation sent to user: " + userId + " for order: " + orderId);
    }
}
