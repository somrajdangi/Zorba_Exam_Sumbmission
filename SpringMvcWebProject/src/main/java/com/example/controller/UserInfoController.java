package com.example.controller;

import com.example.entity.UserInfo;
import com.example.service.UserInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@RequestMapping("/")
public class UserInfoController {
    @Autowired
    UserInfoService userInfoService;

    @GetMapping
    public String home() {
        return "index";
    }

    @GetMapping("/saveUserInfo")
    public String saveUserInfo(@ModelAttribute UserInfo userInfo, Model model) {
        String message = "";
        if (userInfo != null) {
            message = userInfoService.saveUserInfo(userInfo);
        } else {
            message = "input data can't be empty";
        }
        model.addAttribute("message", message);
        return "userInfoSaved";

    }

    @GetMapping("/getAllUserInfo")
    public String getUserInfo(Model model) {
        List<UserInfo> userInfoList = null;
        userInfoList = userInfoService.getAllUserInfo();
        if(userInfoList !=null){
            model.addAttribute("userInfoList", userInfoList);
        }
        return "viewUser";
    }
}



