package com.example.controller;

import com.example.entity.UserInfoEntity;
import com.example.model.Inventory;
import com.example.model.UserInfoModel;
import com.example.service.UserInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
public class UserInfoController {
    @Autowired
    UserInfoService userInfoService;

    @GetMapping(path = "/saveUser")
    public String saveUser(@ModelAttribute(name = "userInfoModel") UserInfoModel userInfoModel, Model model) {
        String message = "";
        if (userInfoModel != null) {
            message = userInfoService.saveUserInfo(userInfoModel);
            System.out.println("data saved!");

        }
        model.addAttribute("message", message);
        return "saveUserView";
    }

    @GetMapping(path = "/getAllUser")
    public String getAllUser(Model model) {
        List<UserInfoEntity> userInfoEntityList = userInfoService.getAllUserInfo();
        System.out.println(userInfoEntityList.get(0));
        model.addAttribute("userList", userInfoEntityList);
        return "viewUser";
    }

    @RequestMapping(value = "/addRoles", method = RequestMethod.POST)
    public String addRoles(@RequestParam("userId") String userId,
                           @RequestParam(value = "role") String role,
                           Model model) {
        System.out.println("addRole, userId " + userId);
        System.out.println(role);
        if (role != null) {
            // userInfoService.saveUserRole(userId, role);
        }
        model.addAttribute("userId", userId);

        return "success";
    }

    @RequestMapping("/getRollerId")
    public String getRollerId(@RequestParam("userId") String userId, Model model) {

        model.addAttribute("userId", userId);
        return "addRoles";

    }

    //exam section
    @RequestMapping(value = "/vendorController")
    public String vendorController(@RequestParam("name") String name,
                                   @RequestParam("password") String password,
                                   @RequestParam("role") String role,
                                   Model model) {
        UserInfoEntity user = userInfoService.vendorValidation(name, password, role);
        if (user == null) {
            return "invalidVendorInputs";
        }
        return "addInventory";
    }

    @RequestMapping(value = "/addInventory")
    public String addInventory(@ModelAttribute("inventory") Inventory inventory) {
        String message = userInfoService.saveInventory(inventory);
        return null;
    }

}
