package com.example.apricart.service;

import com.example.apricart.entity.Cart;
import com.example.apricart.repository.CartRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CartService {

    @Autowired
    private CartRepository cartRepository;

    public Cart addToCart(Cart cart) {
        return cartRepository.save(cart);
    }

    public Cart updateCart(Long cartId, Cart cartDetails) {
        Optional<Cart> cart = cartRepository.findById(cartId);
        if (cart.isPresent()) {
            Cart existingCart = cart.get();
            existingCart.setQuantity(cartDetails.getQuantity());
            return cartRepository.save(existingCart);
        } else {
            // Handle the case where the cart is not found
            return null;
        }
    }

    public void removeFromCart(Long cartId) {
        cartRepository.deleteById(cartId);
    }

    public void clearCart(String userId) {
        List<Cart> userCarts = cartRepository.findByUserId(userId);
        cartRepository.deleteAll(userCarts);
    }

    public List<Cart> getCartItems(String userId) {
        return cartRepository.findByUserId(userId);
    }

    public Double getCartTotal(String userId) {
        List<Cart> cartItems = cartRepository.findByUserId(userId);
        return cartItems.stream().mapToDouble(cart -> cart.getQuantity() * cart.getProduct().getPrice()).sum();
    }
}
