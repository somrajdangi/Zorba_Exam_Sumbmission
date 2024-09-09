package com.example.dao;

import com.example.entity.UserInfoEntity;

import java.util.List;

public interface UserInfoDAO {
    String saveUserInfo(UserInfoEntity userInfo);

    List<UserInfoEntity> getAllUserInfo();

    public UserInfoEntity getVendorData(String name, String password, String role);


}
