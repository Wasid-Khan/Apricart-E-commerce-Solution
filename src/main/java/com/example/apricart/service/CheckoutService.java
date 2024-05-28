package com.example.apricart.service;

import com.example.apricart.entity.Cart;
import com.example.apricart.entity.Order;
import com.example.apricart.repository.CartRepository;
import com.example.apricart.repository.OrderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.UUID;

@Service
public class CheckoutService {

    @Autowired
    private CartRepository cartRepository;

    @Autowired
    private OrderRepository orderRepository;

    @Autowired
    private CouponService couponService;

    @Autowired
    private NotificationService notificationService;

    @Transactional
    public Order processCheckout(String userId, String couponCode, String paymentMethod) {
        // Retrieve cart items for the user
        List<Cart> cartItems = cartRepository.findByUserId(userId);

        // Calculate subtotal
        double subtotal = cartItems.stream().mapToDouble(cart -> cart.getQuantity() * cart.getProduct().getPrice()).sum();

        // Apply coupon discount if available
        double total = couponService.applyCoupon(couponCode, subtotal);

        // Generate a unique order ID
        String orderId = UUID.randomUUID().toString();

        // Create order entries
        for (Cart cart : cartItems) {
            Order order = new Order();
            order.setOrderId(Long.valueOf(orderId));
            order.setUserId(userId);
            order.setProductId(cart.getProductId());
            order.setQuantity(cart.getQuantity());
            order.setTotalPrice(cart.getQuantity() * cart.getProduct().getPrice());
            order.setStatus("pending");
            order.setWarehouseId(cart.getWarehouseId());
            orderRepository.save(order);
        }

        // Clear the user's cart
        cartRepository.deleteAll(cartItems);

        // Send notification (this is a placeholder, you need to implement NotificationService)
        notificationService.sendOrderConfirmation(userId, orderId);

        // Here, you would integrate with a payment gateway to process the payment
        // For this example, we assume the payment is successful and update the order status

        // Update the order status
        List<Order> orders = (List<Order>) orderRepository.findByUserId(userId);
        for (Order order : orders) {
            order.setStatus("paid");
            orderRepository.save(order);
        }

        // Return the final order summary
        Order orderSummary = new Order();
        orderSummary.setOrderId(Long.valueOf(orderId));
        orderSummary.setUserId(userId);
        orderSummary.setTotalPrice(total);
        orderSummary.setStatus("paid");

        return orderSummary;
    }
}
