package com.programmingtechniq.inventoryservice.controllers;


import com.programmingtechniq.inventoryservice.services.InventoryService;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/inventory")
@RequiredArgsConstructor
public class InventoryController {

    private final InventoryService inventoryService;

    @GetMapping("/{skuCode}")
    @ResponseStatus(HttpStatus.OK)
    public boolean isINStock(@PathVariable("/skuCode") String skuCode) {


        return inventoryService.isINStock(skuCode);
    }
}
