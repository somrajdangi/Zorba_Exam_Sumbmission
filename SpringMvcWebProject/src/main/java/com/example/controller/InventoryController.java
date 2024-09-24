package com.example.controller;


import com.example.entity.Inventory;
import com.example.entity.InventoryCategory;
import com.example.service.InventoryCategoryService;
import com.example.service.InventoryService;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.ui.Model;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;
import java.util.stream.Collectors;

@Controller
public class InventoryController {
    @Autowired
    InventoryService inventoryService;
    @Autowired
    InventoryCategoryService inventoryCategoryService;

    @GetMapping("/addInventory")
    public String addInventory() {
        return null;
    }

    @PostMapping("/addInventory")
    public String addInventory(@RequestParam("name") String inventoryName,
                               @RequestParam("category") String categoryName,
                               @RequestParam("quantity") Integer inventoryQuantity,
                               @RequestParam("price") Float inventoryPrice,
                               @RequestParam("description") String inventoryDescription,
                               // @RequestParam ("image")MultipartFile image,
                               Model model) {
        String inventoryCategoryMessage = "";
        String inventoryMessage = "";
        //find if not create inventory category
        InventoryCategory inventoryCategory = inventoryCategoryService.findByCategoryName(categoryName);
        if (inventoryCategory == null) {
            inventoryCategory = new InventoryCategory();
            inventoryCategory.setCategoryName(categoryName);
            inventoryCategoryMessage = inventoryCategoryService.saveInventoryCategory(inventoryCategory);
        }

        //find if not create inventory
        Inventory inventory = inventoryService.findByName(inventoryName);
        if (inventory == null) {
            Float totalInventoryPrice = inventoryPrice * inventoryQuantity;
            inventory = new Inventory(inventoryDescription, inventoryPrice, inventoryQuantity, inventoryName);

            inventory.setInventoryCategory(inventoryCategory);

            inventoryMessage = inventoryService.saveInventory(inventory);
        }

        model.addAttribute("inventoryMessage", inventoryMessage);
        model.addAttribute("inventoryCategoryMessage", inventoryCategoryMessage);
        return "inventorySaved";
    }


    @GetMapping("/uploadExcelData")
    public String uploadExcel() {
        return "uploadExcelData";
    }


    @PostMapping("/excelToDb")
    public String excelToDb(@RequestParam("file") MultipartFile file, Model model) {
        String message = "";
        if (file.isEmpty()) {
            message = "file is empty";

        }
        try {
            XSSFWorkbook workbook = new XSSFWorkbook(file.getInputStream());
            Sheet sheet = workbook.getSheetAt(0);

            for (Row row : sheet) {
                if (row.getRowNum() == 0) {
                    continue;//skipping header row
                }
                String categoryName = row.getCell(0).getStringCellValue();
                String inventoryName = row.getCell(1).getStringCellValue();
                String inventoryDescription = row.getCell(2).getStringCellValue();
                Float inventoryPrice = (float) row.getCell(3).getNumericCellValue();
                Integer inventoryQuantity = (int) row.getCell(3).getNumericCellValue();

                Inventory inventory = new Inventory(inventoryDescription, inventoryPrice, inventoryQuantity, inventoryName);
                inventoryService.saveInventory(inventory);
                InventoryCategory inventoryCategory = new InventoryCategory();
                inventoryCategory.setCategoryName(categoryName);
                inventoryCategoryService.saveInventoryCategory(inventoryCategory);
            }
            workbook.close();
            model.addAttribute("message", "all excel data saved");
        } catch (Exception e) {
            e.printStackTrace();
        }
        return "excelDataSaved";
    }

    @PostMapping("/filterCustomerDashboard")
    public String filterCustomerDashboard(@RequestParam("inventoryList") String stringInventoryList,
                                          @RequestParam("category") String category,
                                          Model model) {

        List<Inventory> filteredInventory = inventoryService.filterCustomerDashboard(stringInventoryList, category);

        model.addAttribute("inventoryList", filteredInventory);
        return "dashboard";
    }

}
