package com.programmingtechniq.inventoryservice;

import com.programmingtechniq.inventoryservice.models.Inventory;
import com.programmingtechniq.inventoryservice.repositorys.InventoryRepository;
import com.programmingtechniq.inventoryservice.services.InventoryService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class InventoryServiceApplication {

    public static void main(String[] args) {
        SpringApplication.run(InventoryServiceApplication.class, args);
    }

    @Bean
    public CommandLineRunner loadData(InventoryRepository inventoryRepository) {


        return args -> {
            Inventory inventory = new Inventory();
            inventory.setSkuCode("Iphone 13");
            inventory.setQuantity(100);

            Inventory inventory1 = new Inventory();
            inventory1.setSkuCode("Iphone 13_RED");
            inventory1.setQuantity(0);

            inventoryRepository.save(inventory);
            inventoryRepository.save(inventory1);


        };
    }
}
