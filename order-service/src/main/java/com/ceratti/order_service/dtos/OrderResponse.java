package com.ceratti.order_service.dtos;

import java.util.List;
import java.util.UUID;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class OrderResponse {
    
    private UUID uuid;

    private List<OrderItemResponse> items;

}
