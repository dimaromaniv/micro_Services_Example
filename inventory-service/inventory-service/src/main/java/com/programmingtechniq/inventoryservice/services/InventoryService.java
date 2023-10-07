package com.programmingtechniq.inventoryservice.services;


import com.programmingtechniq.inventoryservice.repositorys.InventoryRepository;
import lombok.RequiredArgsConstructor;
import lombok.Setter;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
public class InventoryService {

    private final InventoryRepository inventoryRepository;


    @Transactional(readOnly = true)
    public boolean isINStock(String skuCode){
        return inventoryRepository.findBySkuCode().isPresent();

    }
}
