package com.programmingtechniq.productservice.controller;

import com.programmingtechniq.productservice.dto.ProductRequest;
import com.programmingtechniq.productservice.services.ProductService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/product")
@RequiredArgsConstructor
public class ProductController {

    private final ProductService productService;

    @PostMapping()
    @ResponseStatus(HttpStatus.CREATED)
    public void creteProduct(@RequestBody ProductRequest productRequest){
        productService.createProduct(productRequest);

    }

}
