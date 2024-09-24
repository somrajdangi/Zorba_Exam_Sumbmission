package com.example.dao;

import com.example.entity.UserInfo;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

public class UserInfoDao {
    SessionFactory sessionFactory;

    public UserInfoDao(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    @Transactional(propagation = Propagation.REQUIRES_NEW)
    public UserInfo getUserByUserUserName(String userName) {
        Session session = sessionFactory.getCurrentSession();
        UserInfo user = null;
        try {
            String getQuery = "from UserInfo where userUserName=:userUserName";
            Query query = session.createQuery(getQuery);
            query.setMaxResults(1);
            query.setParameter("userUserName", userName);
            user = (UserInfo) query.uniqueResult();
            //  List<UserInfo>  UserInfoList=query.list();
            //query.list() retrives all
            //if we need only one, we user uniqueresult but to limit we need
            //only one result, do setmaxresults(1)
        } catch (Exception e) {
            e.printStackTrace();
        }
        return user;
    }

    @Transactional(propagation = Propagation.REQUIRES_NEW)
    public String saveUserInfo(UserInfo userInfo) {
        String message = "";
        Session session = sessionFactory.getCurrentSession();
        try {
            session.saveOrUpdate(userInfo);
            message = "user data saved";
        } catch (Exception e) {
            e.printStackTrace();
            message = "user data not saved";
        }
        return message;

    }

    @Transactional(propagation = Propagation.REQUIRES_NEW)
    public List<UserInfo> getAllUserInfo() {
        Session session = sessionFactory.getCurrentSession();
        String getAllQuery = "from UserInfo";
        Query query = session.createQuery(getAllQuery);
        List<UserInfo> userInfoList = query.list();
        return userInfoList;
    }

    @Transactional(propagation = Propagation.REQUIRES_NEW)
    public UserInfo getUserById(Integer userId) {
        Session session = sessionFactory.getCurrentSession();
        String getQuery = "from UserInfo where userId=:userId";
        Query query = session.createQuery(getQuery);
        query.setParameter("userId", userId);
        UserInfo userInfo = (UserInfo) query.uniqueResult();
        return userInfo;
    }

    @Transactional(propagation = Propagation.REQUIRES_NEW)
    public UserInfo getUserByUserNameAndPassword(String userUserName, String userPassword) {
        UserInfo user = null;
        Session session = sessionFactory.getCurrentSession();
        try {
            String getQuery = "from UserInfo  where userUserName=:userUserName and userPassword=:userPassword";
            Query query = session.createQuery(getQuery);
            query.setParameter("userUserName", userUserName);
            query.setParameter("userPassword", userPassword);
            user = (UserInfo) query.uniqueResult();
        } catch (Exception e) {
            e.printStackTrace();
        }

        return user;
    }

}
