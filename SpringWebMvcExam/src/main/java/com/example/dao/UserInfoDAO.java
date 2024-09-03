package com.example.dao;

import com.example.model.UserInfoModel;

import java.util.List;

public interface UserInfoDAO {
    void saveUserInfo(UserInfoModel userInfoModel);
    List<UserInfoModel> getAllUserInfo();
}
