package com.ceratti.inventory_service.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

import jakarta.persistence.EntityNotFoundException;

@ResponseStatus(HttpStatus.NOT_FOUND)
public class IventoryNotFoundException extends EntityNotFoundException {
    
    public IventoryNotFoundException(String message) {
        super(message);
    }

}
