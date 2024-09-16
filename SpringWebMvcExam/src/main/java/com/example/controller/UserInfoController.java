package com.example.controller;

import com.example.entity.UserInfoEntity;
import com.example.model.Inventory;
import com.example.model.UserInfoModel;
import com.example.service.UserInfoServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

@Controller
public class UserInfoController {
    @Autowired
    UserInfoServiceImpl userInfoServiceImpl;

    @GetMapping(path = "/saveUserInfo")
    public String saveUser(@ModelAttribute(name = "userInfoModel") UserInfoModel userInfoModel, Model model) {
        String message = "";
        if (userInfoModel != null) {
            message = userInfoServiceImpl.saveUserInfo(userInfoModel);
            System.out.println("data saved!");

        }
        model.addAttribute("message", message);
        return "saveUserView";
    }

    @GetMapping(path = "/getAllUserInfo")
    public String getAllUser(Model model) {
        List<UserInfoEntity> userInfoEntityList = userInfoServiceImpl.getAllUserInfo();
        System.out.println(userInfoEntityList.get(0));
        model.addAttribute("userList", userInfoEntityList);
        return "viewUser";
    }


    @RequestMapping("/getRollerId")
    public String getRollerId(@RequestParam("userId") String userId, Model model) {

        model.addAttribute("userId", userId);
        return "addRoles";

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

    @GetMapping("/excelRead")
    public void readExcel(@RequestParam MultipartFile multipartFile) {
        userInfoServiceImpl.saveExcelInventory(multipartFile);
    }

    //exam section
    @RequestMapping(value = "/vendorController")
    public String vendorController(@RequestParam("name") String name,
                                   @RequestParam("password") String password,
                                   @RequestParam("role") String role,
                                   Model model) {
        UserInfoEntity user = userInfoServiceImpl.vendorValidation(name, password, role);
        if (user == null) {
            model.addAttribute("user", user.getUserUserName());
            return "invalidInputs";
        }
        return "addInventory";
    }

    @RequestMapping(value = "/addInventory")
    public void addInventory(@ModelAttribute("inventory") Inventory inventory) {
        userInfoServiceImpl.saveInventory(inventory);


    }


    @RequestMapping(value = "/customerController")
    public String customerController(@RequestParam("name") String name,
                                     @RequestParam("password") String password,
                                     @RequestParam("role") String role,
                                     Model model) {
        UserInfoEntity user = userInfoServiceImpl.customerValidation(name, password, role);
        if (user == null) {
            model.addAttribute("user", user.getUserUserName());
            return "invalidInputs";
        } else {
            return "addInventory";
        }

    }


    @RequestMapping(value = "/adminController")
    public String adminController(@RequestParam("name") String name,
                                  @RequestParam("password") String password,
                                  @RequestParam("role") String role,
                                  Model model) {
        UserInfoEntity user = userInfoServiceImpl.adminValidate(name, password, role);
       UserInfoEntity customer= userInfoServiceImpl.getAllUserInfo()
        if (user == null) {
            model.addAttribute("user", user.getUserUserName());
            return "invalidInputs";

        } else {
            return "addInventory";
        }
    }
}
