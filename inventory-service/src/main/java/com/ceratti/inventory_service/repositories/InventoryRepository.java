package com.ceratti.inventory_service.repositories;

import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ceratti.inventory_service.models.Inventory;

public interface InventoryRepository extends JpaRepository<Inventory, UUID> {
    
}
