package com.ceratti.order_service.services.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ceratti.order_service.exceptions.OrderBadRequestException;
import com.ceratti.order_service.models.Order;
import com.ceratti.order_service.models.OrderLineItems;
import com.ceratti.order_service.repositories.IOrderRepository;
import com.ceratti.order_service.services.IOrderService;


@Service
public class OrderServiceImpl implements IOrderService {


    @Autowired
    private IOrderRepository orderRepository;

    private OrderLineItems mapToDto(OrderLineItems orderLineItemDto) {
        if (orderLineItemDto == null) {
            return null;
        }
        OrderLineItems orderLineItem = new OrderLineItems()
            .setSkuCode(orderLineItemDto.getSkuCode())
            .setQuantity(orderLineItemDto.getQuantity())
            .setPrice(orderLineItemDto.getPrice());
        return orderLineItem;


    }


    @Override
    public Order createOrder(Order order) {
        
        if (order.getOrderLines().size() == 0) {
            throw new OrderBadRequestException("Order must have at least one line item" );            
        }
            List<OrderLineItems> orderLineItems = order.getOrderLines().stream()
                .map(this::mapToDto)
                .toList();
            order.setOrderLines(orderLineItems);
            
            order = orderRepository.save(order);
            return order;

    }





    
}
