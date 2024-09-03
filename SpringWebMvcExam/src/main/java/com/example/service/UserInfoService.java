package com.example.service;

import com.example.model.UserInfoModel;

import java.util.List;

public interface UserInfoService {
    void saveUserInfo(UserInfoModel userinfo);

    List<UserInfoModel> getAllUserInfo();
}
