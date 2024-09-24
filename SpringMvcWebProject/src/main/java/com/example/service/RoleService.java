package com.example.service;

import com.example.dao.RoleDao;
import com.example.dao.UserInfoDao;
import com.example.entity.Role;
import com.example.entity.UserInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class RoleService {
    @Autowired
    RoleDao roleDao;
    @Autowired
    UserInfoDao userInfoDao;
    @Autowired
    UserInfoService userInfoService;
    @Autowired
    RoleService roleService;

    public String saveRole(Integer userId, String roleName) {
        String message = "";
        // Fetch user by userId
        UserInfo userInfo = userInfoService.getUserById(userId);
        List<Role> tempRoleList = userInfo.getRoleList();
        if (tempRoleList == null) {
            tempRoleList = new ArrayList<>();
        }
        //check if role already exist
        boolean roleExist = tempRoleList.stream()
                .anyMatch(role -> role.getRoleName().equalsIgnoreCase(roleName));

        if (roleExist) {
            message = "role already exists";
        } else {
            Role role = roleDao.getRoleByName(roleName);
            if (role != null) {
                tempRoleList.add(role);
                userInfo.setRoleList(tempRoleList);
               userInfoDao.saveUserInfo(userInfo);
                message = "role added!";

            } else {
                message = "role not found";
            }
        }

        return message;
    }

    public Role getRoleByName(String roleName) {
        return roleDao.getRoleByName(roleName);
    }

    public String removeRole(Integer userId, String roleName) {
        UserInfo userInfo = userInfoDao.getUserById(userId);
        List<Role> tempRoleList = userInfo.getRoleList();
        List<Role> filteredRole = tempRoleList.stream()
                .filter(roleEntity -> !roleEntity.getRoleName().equals(roleName))
                .collect(Collectors.toList());
        //alternatively
        //tempRoleList.removeIf(role->role.getRoleName().equals(roleName));
        userInfo.setRoleList(filteredRole);
        userInfoDao.saveUserInfo(userInfo);
        return "role Removed !";
    }

    public String updateUserToCustomer(){
       return roleDao.updateUserToCustomer();
    }


}
