package com.programmingtechniq.productservice.repository;

import com.programmingtechniq.productservice.models.Product;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;



public interface ProductRepository extends MongoRepository<Product,String> {
}

