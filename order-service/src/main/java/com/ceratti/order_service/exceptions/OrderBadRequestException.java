package com.ceratti.order_service.exceptions;

public class OrderBadRequestException extends BadRequestException {

    public OrderBadRequestException(String message) {
        super(message);
    }
    
}
