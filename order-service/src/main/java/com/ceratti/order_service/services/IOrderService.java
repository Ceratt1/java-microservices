package com.ceratti.order_service.services;

import java.util.UUID;

import org.springdoc.core.converters.models.Pageable;

import com.ceratti.order_service.exceptions.BadRequestException;
import com.ceratti.order_service.exceptions.OrderBadRequestException;
import com.ceratti.order_service.models.Order;

public interface IOrderService {

    Order createOrder(Order order) throws OrderBadRequestException;
      
    Order getAllByOrderUuid(UUID orderUuid, Pageable pageable) throws BadRequestException;

    Order getAll(Pageable pageable) throws BadRequestException;
}
