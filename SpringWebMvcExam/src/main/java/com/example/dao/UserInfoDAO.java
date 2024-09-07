package com.example.dao;

import com.example.entity.UserInfo;
import com.example.model.UserInfoModel;

import java.util.List;

public interface UserInfoDAO {
    String saveUserInfo(UserInfo userInfo);
    List<UserInfo> getAllUserInfo();
}
