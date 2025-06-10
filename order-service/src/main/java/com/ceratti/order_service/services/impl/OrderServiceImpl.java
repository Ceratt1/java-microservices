package com.ceratti.order_service.services.impl;

import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;

import com.ceratti.order_service.exceptions.OrderBadRequestException;
import com.ceratti.order_service.models.Order;
import com.ceratti.order_service.models.OrderLineItems;
import com.ceratti.order_service.repositories.IOrderRepository;
import com.ceratti.order_service.services.IOrderService;

import jakarta.transaction.Transactional;


@Service
public class OrderServiceImpl implements IOrderService {


    private IOrderRepository orderRepository;

    private final WebClient webClient;

    private final static String INVENTORY_SERVICE_URL = "http://localhost:9093/api/inventory/";
 

    public OrderServiceImpl(IOrderRepository orderRepository, WebClient webClient) {
        this.orderRepository = orderRepository;
        this.webClient = webClient;
    }



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
    @Transactional
    public Order createOrder(Order order) {
        
        if (order.getOrderLines().size() == 0) {
            throw new OrderBadRequestException("Order must have at least one line item" );            
        }
        List<OrderLineItems> orderLineItems = order.getOrderLines().stream()
            .map(this::mapToDto)
            .toList();
        order.setOrderLines(orderLineItems);
        
        order.getOrderLines().stream()
            .forEach(item -> {
                try {
                        boolean isAvailable = webClient.get()
                        .uri(INVENTORY_SERVICE_URL + item.getSkuCode())
                        .retrieve()
                        .bodyToMono(Boolean.class)
                        .block();

                    if (!isAvailable) {
                        throw new OrderBadRequestException("Item " + item.getSkuCode() + " is not available in inventory");
                    }
                } catch (Exception e) {
                    throw new OrderBadRequestException("Error checking inventory for item " + item.getSkuCode());
                }
                
            });
            

        return orderRepository.save(order);
             
    }

    
}
