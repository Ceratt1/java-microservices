package com.ceratti.order_service.repositories;

import java.lang.StackWalker.Option;
import java.util.Optional;
import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ceratti.order_service.models.Order;

public interface IOrderRepository extends JpaRepository<Order, UUID> {

    Optional<Order> getByUuid(UUID uuid);    
}
