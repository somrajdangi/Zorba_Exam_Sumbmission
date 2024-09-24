package com.example.service;

import com.example.dao.UserInfoDao;
import com.example.entity.UserInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserInfoService {
    @Autowired
    UserInfoDao userInfoDao;
    public String saveUserInfo(UserInfo userInfo) {
        UserInfo user= userInfoDao.getUserByUserUserName(userInfo.getUserUserName());
       String message="";
       if(user==null ){
          message= userInfoDao.saveUserInfo(userInfo);

       }
       else{
           message="userInfo already exist, please login";
       }

           return message;
    }
    public String updateUserInfoWithRole(UserInfo userInfo){
       String message= userInfoDao.saveUserInfo(userInfo);
       return message;
    }

   public List<UserInfo> getAllUserInfo(){
        return userInfoDao.getAllUserInfo();
   }

   public UserInfo getUserById(Integer userId){
        UserInfo userInfo = userInfoDao.getUserById(userId);
      return userInfo;

   }
}
