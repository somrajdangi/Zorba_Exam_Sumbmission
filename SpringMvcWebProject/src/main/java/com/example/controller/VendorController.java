package com.example.controller;

import com.example.service.VendorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class VendorController {
    @Autowired
    private VendorService vendorService;

    @GetMapping("/vendorLogin")
    public String vendorLogin() {
        return "vendorLogin";
    }

    @PostMapping("/vendorLogin")
    public String vendorLogin(@RequestParam("userName") String userName,
                              @RequestParam("password") String password,
                              @RequestParam("role") String role,
                              Model model) {
        String addInventory = "";
        boolean validation = vendorService.validate(userName, password ,role);
        if (validation) {
            addInventory = "addInventory";
        } else {
            addInventory = "invalidInputs";
        }
        model.addAttribute("role", role);
        return addInventory;
    }


}
