package com.example.service;

import com.example.model.UserInfoModel;

import java.util.List;

public interface UserInfoService {
    String saveUserInfo(UserInfoModel userInfoModel);

    List<UserInfoModel> getAllUserInfo();
}
