package com.example.service;

import com.example.dao.UserInfoDAO;
import com.example.model.UserInfoModel;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.ArrayList;
import java.util.List;

public class UserInfoServiceImpl implements UserInfoService {
    @Autowired
    UserInfoDAO userInfoDAO;

    public void saveUserInfo(UserInfoModel userinfo) {
        userInfoDAO.saveUserInfo(userinfo);
    }

    public List<UserInfoModel> getAllUserInfo() {
        List<UserInfoModel> userInfoModelList = userInfoDAO.getAllUserInfo();
        List<UserInfoModel> userInfoModelList1 = new ArrayList<>();
        for (UserInfoModel userInfoModel : userInfoModelList) {
            UserInfoModel userInfoModel1 = new UserInfoModel();
            userInfoModel1.setUserName(userInfoModel.getUserName());
            userInfoModel1.setUserEmail(userInfoModel.getUserEmail());
            userInfoModel1.setUserMobile(userInfoModel.getUserMobile());
            userInfoModel1.setUserPassword(userInfoModel.getUserPassword());
            userInfoModel1.setUserUserName(userInfoModel.getUserUserName());

        }
        return userInfoModelList1;
    }
}


