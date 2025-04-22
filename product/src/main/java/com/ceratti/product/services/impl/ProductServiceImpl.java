package com.ceratti.product.services.impl;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import com.ceratti.product.models.Product;
import com.ceratti.product.repositories.ProductRepository;
import com.ceratti.product.services.IProductService;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Service
@RequiredArgsConstructor
@Slf4j
public class ProductServiceImpl implements IProductService {

    private final ProductRepository productRepository;

    @Override
    public Product createProduct(Product product) {
        try {
            Product productRaw = productRepository.save(product);
            log.info("Product created: {}", productRaw.getId());
            return productRaw;
        } catch (Exception e) {
            throw new ResponseStatusException(HttpStatus.INTERNAL_SERVER_ERROR, "Error creating product", e);
        }
    }

    @Override
    public Page<Product> getAllProducts(Integer page, Integer pageSize) {
        try {
            Page<Product> products = productRepository.findAll(PageRequest.of(page, pageSize));
            log.info("Products retrieved: {}", products.getTotalElements());
            return products;
            
        } catch (Exception e) {
            throw new ResponseStatusException(HttpStatus.INTERNAL_SERVER_ERROR, "Error getting products", e);
        }
    }
}
