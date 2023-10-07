package com.programmingtechniq.orderservice.controllers;

import com.programmingtechniq.orderservice.dto.OrderRequest;
import com.programmingtechniq.orderservice.services.OrderServices;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/order")
@AllArgsConstructor
public class OrderController {

    private final OrderServices orderServices;


    @PostMapping
    @ResponseStatus(HttpStatus.CREATED )

    public String placeOrder(@RequestBody OrderRequest orderRequest) {

        orderServices.placeServices(orderRequest);
        return "Order Placed Successfully";
    }
}
