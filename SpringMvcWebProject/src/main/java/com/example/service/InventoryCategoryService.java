package com.example.service;

import com.example.dao.InventoryCategoryDao;
import com.example.dao.InventoryDao;
import com.example.entity.InventoryCategory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class InventoryCategoryService {
    @Autowired
    InventoryCategoryDao inventoryCategoryDao;

    public String saveInventoryCategory(InventoryCategory inventoryCategory) {
        String message = "";
        if(inventoryCategory !=null){
            message = inventoryCategoryDao.saveInventory(inventoryCategory);
        }
        return message;
    }
    public InventoryCategory findByCategoryName(String category){
       return inventoryCategoryDao.findByCategoryName(category);
    }
}
