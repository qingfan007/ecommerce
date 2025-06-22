package com.simple.ecommerce.mysql.controller;

import com.simple.ecommerce.mysql.service.CouponThriftClientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/coupon")
public class CouponController {

    @Autowired
    private CouponThriftClientService couponService;

    /**
     * GET /api/coupon/validate?code=DISCOUNT10
     */
    @GetMapping("/validate")
    public boolean validate(@RequestParam String code) throws Exception {
        return couponService.validateCoupon(code);
    }

    /**
     * GET /api/coupon/discount?code=DISCOUNT10&amount=200
     */
    @GetMapping("/discount")
    public double discount(@RequestParam String code, @RequestParam double amount) throws Exception {
        return couponService.calculateDiscount(code, amount);
    }

}
