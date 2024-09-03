package com.example.controller;

import com.example.model.UserInfoModel;
import com.example.service.UserInfoService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;

@Controller
public class UserInfoController {
    UserInfoService userInfoService;

    @GetMapping(path="/saveUser")
    public String saveUser(@ModelAttribute("userInfo")UserInfoModel userInfoModel){
       userInfoService.saveUserInfo(userInfoModel);
       return "success";//jsp
    }

    public String GetAllStudent(Model model)
List<UserInfoModel>userInfoModelList= this.userInfoService.getAllUserInfo();
    model.addAttribute("alluserinfo",userInfoModelList );
    return "userinfoDashboard";

}
