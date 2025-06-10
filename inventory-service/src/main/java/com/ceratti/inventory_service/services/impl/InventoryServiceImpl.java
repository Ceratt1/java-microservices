package com.ceratti.inventory_service.services.impl;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ceratti.inventory_service.models.Inventory;
import com.ceratti.inventory_service.repositories.InventoryRepository;
import com.ceratti.inventory_service.services.IInventoryService;


@Service
public class InventoryServiceImpl implements IInventoryService {

    @Autowired
    private InventoryRepository inventoryRepository;


    @Override
    public boolean isInStock(String skuCode) {
        
        Optional<Inventory> inventory = inventoryRepository.findBySkuCode(skuCode);
        if(!inventory.isPresent()) {
            return false;
        }

        return inventory.get().getQuantity().intValue() > 0;


    }
    
}
