package com.programmingtechniq.orderservice.controllers;

import com.programmingtechniq.orderservice.dto.OrderRequest;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/order")
public class OrderController {

    public String placeOrder(@RequestBody OrderRequest orderRequest) {
        return "Order Placed Successfully";
    }
}
