package com.example.controller;

import com.example.entity.Role;
import com.example.entity.UserInfo;
import com.example.service.RoleService;
import com.example.service.UserInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.ArrayList;
import java.util.List;

@Controller
public class RoleController {
    @Autowired
    RoleService roleService;

    @GetMapping("/addRoles")
    public String addRoles(@RequestParam Integer userId, Model model) {
        model.addAttribute("userId", userId);
        return "addRoles";
    }

    @PostMapping("/saveRoles")

    public String saveRoles(@RequestParam Integer userId, @RequestParam String roleName, Model model) {
        String message = "";
       message= roleService.saveRole(userId,roleName);
        model.addAttribute("message", message);
        return "roleSaved";  // Return to the JSP page
    }


    @GetMapping("/removeRole")
    public String removeRole(@RequestParam String roleName,
                             @RequestParam Integer userId, Model model) {

        String message = roleService.removeRole(userId, roleName);
        model.addAttribute("message", message);
        return "roleRemoved";
    }
    @GetMapping("/updateUserToCustomer")
    public String updateUserToCustomer(Model model){
        roleService.updateUserToCustomer();
        model.addAttribute("message","user role updated to customer from user");
        return "updateUserToCustomer";
    }
}
