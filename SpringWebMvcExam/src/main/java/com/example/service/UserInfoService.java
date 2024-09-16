package com.example.service;

import com.example.entity.UserInfoEntity;
import com.example.model.Inventory;
import com.example.model.UserInfoModel;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

public interface UserInfoService {
    public String saveUserInfo(UserInfoModel userInfoModel);

    List<UserInfoEntity> getAllUserInfo();

    public UserInfoEntity vendorValidation(String name, String password, String role);

    public void saveUserRole(String userId, String role);

    public String saveInventory(Inventory inventory);

    public boolean validateEmail(String email);

    public boolean validatePassword(String password);

    public boolean validateMobile(String mobile);

    public void saveExcelInventory(MultipartFile multipartFile);
}
