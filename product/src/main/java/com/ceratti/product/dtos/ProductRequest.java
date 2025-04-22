package com.ceratti.product.dtos;

import java.math.BigDecimal;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ProductRequest {

    @NotBlank
    @NotNull(message = "Name cannot be null")
    private String name;
    
    private String description;
    
    @NotNull(message = "Price cannot be null")
    private BigDecimal price;
}
