package com.example.service;

import com.example.dao.InventoryDao;
import com.example.entity.Inventory;
import com.example.entity.InventoryCategory;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class InventoryService {
    @Autowired
    InventoryDao inventoryDao;

    public String saveInventory(Inventory inventory) {
        String message = "";
        if (inventory != null) {
            message = inventoryDao.saveInventory(inventory);

        }
        return message;
    }

    public Inventory findByName(String name) {
        return inventoryDao.findByName(name);
    }

    public List<Inventory> getAllInventory() {
        return inventoryDao.getAllInventory();
    }

    public List<Inventory> filterCustomerDashboard(String stringInventoryList, String category) {

        ObjectMapper objectMapper = new ObjectMapper();
        List<Inventory> inventories = null;
        List<Inventory> filteredInventory = null;
        try {
            inventories = objectMapper.readValue(stringInventoryList, new TypeReference<List<Inventory>>() {
            });
        } catch (IOException e) {

        }
        if (inventories != null) {
            filteredInventory = inventories.stream()
                    .filter(item -> item.getInventoryCategory().equals(category))
                    .collect(Collectors.toList());

        }
        return filteredInventory;
    }
}
