package com.ceratti.order_service.dtos;

import java.math.BigDecimal;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class OrderItemResponse {


    private String skuCode;
    
    private BigDecimal price;
    
    private Integer quantity;


}
