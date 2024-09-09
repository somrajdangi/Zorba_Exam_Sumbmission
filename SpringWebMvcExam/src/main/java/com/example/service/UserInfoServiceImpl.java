package com.example.service;

import com.example.dao.UserInfoDAO;
import com.example.entity.InventoryCategoryEntity;
import com.example.entity.InventoryEntity;
import com.example.entity.UserInfoEntity;
import com.example.model.Inventory;
import com.example.model.UserInfoModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class UserInfoServiceImpl implements UserInfoService {
    @Autowired
    private UserInfoDAO userInfoDAO;


    @Transactional(propagation = Propagation.REQUIRES_NEW)
    public String saveUserInfo(UserInfoModel userInfoModel) {
        String responseMsg = "";
        String userEmail = userInfoModel.getUserEmail();
        String userPassword = userInfoModel.getUserPassword();
        String userMobiile = userInfoModel.getUserMobile();
        if (validateEmail(userEmail) && validatePassword(userPassword) && validateMobile(userMobiile) && userInfoModel.getUserName() != null && userInfoModel.getUserUserName() != null) {
            UserInfoEntity userInfoEntity = new UserInfoEntity();
            userInfoEntity.setUserName(userInfoModel.getUserName());
            userInfoEntity.setUserEmail(userInfoModel.getUserEmail());
            userInfoEntity.setUserMobile(userInfoModel.getUserMobile());
            userInfoEntity.setUserPassword(userInfoModel.getUserPassword());
            userInfoEntity.setUserUserName(userInfoModel.getUserUserName());
            responseMsg = this.userInfoDAO.saveUserInfo(userInfoEntity);
        } else {
            responseMsg = "validation failed";
        }
        return responseMsg;
    }

    public List<UserInfoEntity> getAllUserInfo() {
        List<UserInfoEntity> userInfoEntityList = userInfoDAO.getAllUserInfo();
        return userInfoEntityList;
    }

    public void saveUserRole(String userId, String role) {
        Integer id = Integer.parseInt(userId);

        //fetch user from database
        UserInfoEntity user = userInfoDAO.findById(id);
        userInfoDAO.saveUserRole(userId, role);
    }

    //exam section
    public UserInfoEntity vendorValidation(String name, String password, String role) {
        UserInfoEntity user = userInfoDAO.getVendorData(name, password, role);
        return user;
    }

    public String saveInventory(Inventory inventory) {
        InventoryCategoryEntity inventoryCategoryEntity = new InventoryCategoryEntity();
        InventoryEntity inventoryEntity = new InventoryEntity();
        if (inventory.getName() != null && inventory.getCategory() != null && inventory.getPrice() != null
                && inventory.getQuantity() != null) {
            inventoryEntity.setInventoryName(inventory.getName());
            inventoryEntity.setInventoryDescription(inventory.getDescription());
            inventoryEntity.setInventoryQuantity(Integer.parseInt(inventory.getQuantity()));
            inventoryEntity.setInventoryPrice(Float.parseFloat(inventory.getPrice()));


            userInfoDAO.saveInventoryEntity(inventoryEntity);

            inventoryCategoryEntity.setCategoryName(inventory.getName());
            userInfoDAO.saveInventoryCategoryEntity(inventoryCategoryEntity);


        }
        return null;
    }


    public boolean validateEmail(String email) {
        boolean isEmailValid = false;
        if (email.contains("@")) {
            isEmailValid = true;
        }
        return isEmailValid;
    }

    public boolean validatePassword(String password) {
        boolean isPasswordValid = false;
        if (password.length() >= 8) {
            isPasswordValid = true;
        }
        return isPasswordValid;
    }

    public boolean validateMobile(String mobile) {

        if (mobile.length() == 10) {
            for (char c : mobile.toCharArray()) {
                if (!Character.isDigit(c)) {
                    return false;
                }
            }
            return true;
        } else {
            return false;
        }
    }


}


