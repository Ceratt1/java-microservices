package com.ceratti.inventory_service.services.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ceratti.inventory_service.exceptions.InventoyNotFoundException;
import com.ceratti.inventory_service.models.Inventory;
import com.ceratti.inventory_service.repositories.InventoryRepository;
import com.ceratti.inventory_service.services.IInventoryService;

import jakarta.persistence.EntityNotFoundException;

@Service
public class InventoryServiceImpl implements IInventoryService {

    @Autowired
    private InventoryRepository inventoryRepository;


    @Override
    public boolean isInStock(String skuCode) {

        try {
            Inventory inventory = inventoryRepository.findBySkuCode(skuCode);
            return true;
            
        } catch (Exception e) {
            throw new InventoyNotFoundException("Inventory not found, skuCode: " + skuCode);
        }

    }
    
}
