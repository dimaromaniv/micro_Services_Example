package com.programmingtechniq.inventoryservice.controllers;


import com.programmingtechniq.inventoryservice.dto.InventoryResponse;
import com.programmingtechniq.inventoryservice.services.InventoryService;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/inventory")
@RequiredArgsConstructor
public class InventoryController {

    private final InventoryService inventoryService;

    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    public List<InventoryResponse> isINStock(@RequestParam List<String> skuCode) {


        return inventoryService.isINStock(skuCode);
    }
}
