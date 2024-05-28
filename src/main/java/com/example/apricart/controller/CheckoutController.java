package com.example.apricart.controller;

import com.example.apricart.entity.Order;
import com.example.apricart.service.CheckoutService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/checkout")
public class CheckoutController {

    @Autowired
    private CheckoutService checkoutService;

    @PostMapping
    public ResponseEntity<Order> checkout(@RequestParam String userId, @RequestParam String couponCode, @RequestParam String paymentMethod) {
        Order order = checkoutService.processCheckout(userId, couponCode, paymentMethod);
        return ResponseEntity.ok(order);
    }
}
