package com.example.service;

import com.example.dao.UserInfoDao;
import com.example.entity.Inventory;
import com.example.entity.UserInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class VendorService {
    @Autowired
    UserInfoDao userInfoDao;

    public boolean validate(String userName, String password, String role) {
        UserInfo user = userInfoDao.getUserByUserNameAndPassword(userName, password);
        boolean isValid = false;
        if (user != null && user.getUserUserName().equals(userName) && user.getUserPassword().equals(password)) {{
                isValid = true;
            }
        }
        return isValid;
    }

}