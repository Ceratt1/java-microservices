package com.ceratti.inventory_service.exceptions;

import jakarta.persistence.EntityNotFoundException;

public class InventoyNotFoundException extends EntityNotFoundException {
    
    public InventoyNotFoundException(String message) {
        super(message);
    }

}
