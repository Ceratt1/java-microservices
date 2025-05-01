package com.ceratti.inventory_service;

import java.math.BigDecimal;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import com.ceratti.inventory_service.models.Inventory;
import com.ceratti.inventory_service.repositories.InventoryRepository;

@SpringBootApplication
public class InventoryServiceApplication {

	public static void main(String[] args) {
		System.out.println("starting inventory service");
		SpringApplication.run(InventoryServiceApplication.class, args);
	}

	@Bean
	public CommandLineRunner loadData (InventoryRepository inventoryRepository) {

		return args -> {
			Inventory inventory = new Inventory()
					.setSkuCode("iphone_13")
					.setQuantity(new BigDecimal(100));
			
			Inventory inventory2 = new Inventory()
					.setSkuCode("iphone_14")
					.setQuantity(new BigDecimal(100));
	
			inventoryRepository.save(inventory);
			inventoryRepository.save(inventory2);

		};

	}


}
