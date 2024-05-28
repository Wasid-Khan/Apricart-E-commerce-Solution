package com.example.apricart.controller;

import com.example.apricart.service.CouponService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/coupons")
public class CouponController {

    @Autowired
    private CouponService couponService;

    @GetMapping("/validate/{couponCode}")
    public ResponseEntity<Boolean> validateCoupon(@PathVariable String couponCode) {
        boolean isValid = couponService.validateCoupon(couponCode);
        return ResponseEntity.ok(isValid);
    }

    @PostMapping("/apply")
    public ResponseEntity<Double> applyCoupon(@RequestParam String couponCode, @RequestParam Double orderTotal) {
        Double discountedTotal = couponService.applyCoupon(couponCode, orderTotal);
        return ResponseEntity.ok(discountedTotal);
    }
}
