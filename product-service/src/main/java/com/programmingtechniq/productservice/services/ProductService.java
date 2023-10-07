package com.programmingtechniq.productservice.services;

import com.mongodb.annotations.Sealed;
import com.programmingtechniq.productservice.dto.ProductRequest;
import com.programmingtechniq.productservice.models.Product;
import com.programmingtechniq.productservice.repository.ProductRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
@Slf4j
public class ProductService {

    private final ProductRepository productRepository;


    public void createProduct(ProductRequest productRequest){
        Product product = Product.builder()
                .name(productRequest.getName())
                .description(productRequest.getDescription())
                .price(productRequest.getPrice())
                .build();

        productRepository.save(product);
        log.info("Product " + product.getId() + " is saved.");
    }
}
