package com.example.apricart.service;

import com.example.apricart.entity.Coupon;
import com.example.apricart.repository.CouponRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class CouponService {

    @Autowired
    private CouponRepository couponRepository;

    public boolean validateCoupon(String couponCode) {
        Optional<Coupon> coupon = couponRepository.findByCouponCode(couponCode);
        return coupon.isPresent() && coupon.get().getIsActive();
    }

    public Double applyCoupon(String couponCode, Double orderTotal) {
        return couponRepository.findByCouponCode(couponCode)
                .filter(Coupon::getIsActive)
                .map(coupon -> {
                    if (orderTotal >= coupon.getMinOrderAmount()) {
                        return orderTotal - coupon.getDiscountAmount();
                    } else {
                        return orderTotal;
                    }
                })
                .orElse(orderTotal);
    }
}
