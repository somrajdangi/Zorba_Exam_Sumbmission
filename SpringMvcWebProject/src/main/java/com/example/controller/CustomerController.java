package com.example.controller;

import com.example.entity.Inventory;
import com.example.service.InventoryService;
import com.example.service.UserInfoService;
import com.example.service.VendorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Controller
public class CustomerController {
    @Autowired
    UserInfoService userInfoService;
    @Autowired
    VendorService vendorService;
    @Autowired
    InventoryService inventoryService;

    @GetMapping("/customerLogin")
    public String customerLoginInit() {
        return "customerLogin";
    }

    @PostMapping("/customerLogin")
    public String customerLogin(@RequestParam("userName") String userName,
                                @RequestParam("password") String password,
                                @RequestParam("role") String role,
                                Model model) {
        String nextView = "";
        boolean validated = vendorService.validate(userName, password, role);
        if (validated) {
            //prepare inventory to send on dashboard.jsp
            List<Inventory> inventoryList = inventoryService.getAllInventory();
            model.addAttribute("inventoryList", inventoryList);
            nextView = "dashboard";

        } else {
            nextView = "invalidInputs";
        }
        model.addAttribute("role", role);

        return nextView;
    }


}
