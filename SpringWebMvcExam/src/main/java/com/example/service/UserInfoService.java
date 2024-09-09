package com.example.service;

import com.example.entity.UserInfoEntity;
import com.example.model.UserInfoModel;

import java.util.List;

public interface UserInfoService {
    public String saveUserInfo(UserInfoModel userInfoModel);

    List<UserInfoEntity> getAllUserInfo();

    public UserInfoEntity vendorValidation(String name, String password, String role);
}
