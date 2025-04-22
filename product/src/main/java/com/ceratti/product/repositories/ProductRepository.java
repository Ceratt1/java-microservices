package com.ceratti.product.repositories;


import org.springframework.data.mongodb.repository.MongoRepository;

import com.ceratti.product.models.Product;

public interface ProductRepository extends MongoRepository<Product, String> {
    
}
