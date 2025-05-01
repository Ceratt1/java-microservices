package com.ceratti.inventory_service.exceptions;
import org.springframework.http.HttpStatus;

public class DomainException extends RuntimeException {
    public DomainException(String message) {
        super(message);
    }

    public HttpStatus getStatus() {
        return HttpStatus.INTERNAL_SERVER_ERROR;
    }
}

