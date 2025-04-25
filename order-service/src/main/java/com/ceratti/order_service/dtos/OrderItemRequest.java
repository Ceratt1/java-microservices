package com.ceratti.order_service.dtos;

import java.math.BigDecimal;

import jakarta.validation.Valid;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class OrderItemRequest {


    @NotBlank
    @NotNull(message = "skuCode cannot be null")
    private String skuCode;
    

    @NotNull(message = "skuCode cannot be null")
    private BigDecimal price;
    
    @NotNull(message = "skuCode cannot be null")
    private Integer quantity;



}
