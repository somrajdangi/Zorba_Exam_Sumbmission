package com.example.service;

import com.example.dao.UserInfoDAO;
import com.example.entity.UserInfo;
import com.example.model.UserInfoModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import java.util.ArrayList;
import java.util.List;

@Service
public class UserInfoServiceImpl implements UserInfoService {
    @Autowired
    private UserInfoDAO userInfoDAO;

    public List<UserInfoModel> getAllUserInfo() {
        List<UserInfo> userInfoList = this.userInfoDAO.getAllUserInfo();
        List<UserInfoModel> userInfoModelList = new ArrayList<>();
        for (UserInfo userInfo : userInfoList) {
            UserInfoModel userInfoModel = new UserInfoModel();
            userInfoModel.setUserName(userInfo.getUserName());
            userInfoModel.setUserEmail(userInfo.getUserEmail());
            userInfoModel.setUserMobile(userInfo.getUserMobile());
            userInfoModel.setUserPassword(userInfo.getUserPassword());
            userInfoModel.setUserUserName(userInfo.getUserUserName());
            userInfoModelList.add(userInfoModel);
        }
        return userInfoModelList;
    }

    @Transactional(propagation = Propagation.REQUIRES_NEW)
    public String saveUserInfo(UserInfoModel userInfoModel) {
        String responseMsg = "";

            if (userInfoModel.getUserName() != null && userInfoModel.getUserEmail() != null && userInfoModel.getUserMobile() != null && userInfoModel.getUserPassword() != null && userInfoModel.getUserUserName() != null) {
                UserInfo userInfo = new UserInfo();
                userInfo.setUserName(userInfoModel.getUserName());
                userInfo.setUserEmail(userInfoModel.getUserEmail());
                userInfo.setUserMobile(userInfoModel.getUserMobile());
                userInfo.setUserPassword(userInfoModel.getUserPassword());
                userInfo.setUserUserName(userInfoModel.getUserUserName());
            } else {
                responseMsg = "could not process";
            }

        return responseMsg;
    }



}


