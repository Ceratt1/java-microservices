package com.ceratti.product.services;

import org.springframework.data.domain.Page;

import com.ceratti.product.models.Product;

public interface IProductService {

    Product createProduct(Product product);

    Page<Product> getAllProducts(Integer page, Integer pageSize);
}
