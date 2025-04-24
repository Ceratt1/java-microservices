package com.ceratti.order_service.controllers;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.ceratti.order_service.dtos.OrderRequest;
import com.ceratti.order_service.dtos.OrderResponse;
import com.ceratti.order_service.models.Order;
import com.ceratti.order_service.services.IOrderService;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/orders")
public class OrderController {

    private  IOrderService orderService;

    private  ModelMapper modelMapper;

    public OrderController(IOrderService orderService, ModelMapper modelMapper) {
        this.orderService = orderService;
        this.modelMapper = modelMapper;
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public OrderResponse createOrder(@RequestBody @Valid OrderRequest orderRequest) {
        Order order = modelMapper.map(orderRequest, Order.class);
        order = orderService.createOrder(order);
        OrderResponse orderResponse = modelMapper.map(order, OrderResponse.class);
        return orderResponse;

    }
    
}
