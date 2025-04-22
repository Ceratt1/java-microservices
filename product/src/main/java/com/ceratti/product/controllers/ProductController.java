package com.ceratti.product.controllers;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ceratti.product.dtos.ProductRequest;
import com.ceratti.product.dtos.ProductResponse;
import com.ceratti.product.models.Product;
import com.ceratti.product.services.IProductService;

import jakarta.validation.Valid;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;



@RestController
@RequestMapping("/products")
public class ProductController {

    /*
     * This class make a mapper between the DTO and the entity
     */
    @Autowired
    private ModelMapper modelMapper;

    @Autowired
    private IProductService productService;


    @PostMapping()
    public ResponseEntity<ProductResponse> createProduct(@RequestBody @Valid ProductRequest productRequest) {

        Product product = modelMapper.map(productRequest, Product.class);
        Product productRaw = productService.createProduct(product);
        return ResponseEntity.status(HttpStatus.CREATED).body(modelMapper.map(productRaw, ProductResponse.class));
        
    }
 
    
    @GetMapping()
    public ResponseEntity<Page<ProductResponse>> getAll(@RequestParam Integer page, @RequestParam Integer pageSize) {
        Page<Product> products = productService.getAllProducts(page, pageSize);
        Page<ProductResponse> productResponses = products.map(product -> modelMapper.map(product, ProductResponse.class));
        return ResponseEntity.ok(productResponses);
    }
    

}
