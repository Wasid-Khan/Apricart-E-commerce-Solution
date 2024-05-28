package com.example.apricart.controller;

import com.example.apricart.entity.Cart;
import com.example.apricart.service.CartService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/cart")
public class CartController {

    @Autowired
    private CartService cartService;

    @PostMapping
    public ResponseEntity<Cart> addToCart(@RequestBody Cart cart) {
        Cart createdCart = cartService.addToCart(cart);
        return ResponseEntity.ok(createdCart);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Cart> updateCart(@PathVariable Long id, @RequestBody Cart cartDetails) {
        Cart updatedCart = cartService.updateCart(id, cartDetails);
        if (updatedCart != null) {
            return ResponseEntity.ok(updatedCart);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> removeFromCart(@PathVariable Long id) {
        cartService.removeFromCart(id);
        return ResponseEntity.noContent().build();
    }

    @DeleteMapping("/clear/{userId}")
    public ResponseEntity<Void> clearCart(@PathVariable String userId) {
        cartService.clearCart(userId);
        return ResponseEntity.noContent().build();
    }

    @GetMapping("/user/{userId}")
    public ResponseEntity<List<Cart>> getCartItems(@PathVariable String userId) {
        List<Cart> cartItems = cartService.getCartItems(userId);
        return ResponseEntity.ok(cartItems);
    }

    @GetMapping("/total/{userId}")
    public ResponseEntity<Double> getCartTotal(@PathVariable String userId) {
        Double total = cartService.getCartTotal(userId);
        return ResponseEntity.ok(total);
    }
}
