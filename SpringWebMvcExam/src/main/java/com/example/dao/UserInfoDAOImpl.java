package com.example.dao;

import com.example.entity.UserInfo;
import com.example.model.UserInfoModel;
import org.hibernate.Query;
import org.hibernate.SessionFactory;
import org.hibernate.Session;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

public class UserInfoDAOImpl implements UserInfoDAO {
   private SessionFactory sessionFactory;

   //constructor di
    public UserInfoDAOImpl(SessionFactory sessionFactory){
        this.sessionFactory=sessionFactory;
    }
    @Transactional(propagation = Propagation.REQUIRES_NEW)

    public String saveUserInfo(UserInfo userInfo) {
        String res="";
        Session session = this.sessionFactory.getCurrentSession();

        try {
            session.persist(userInfo);
            res="data saved successfully";

        } catch (Exception e) {
            e.printStackTrace();
            res="data not saved";

        } finally {
            if (session != null) {
                session.close();
            }
        }
        return res;
    }

    public List<UserInfo> getAllUserInfo() {
        List<UserInfo> userInfoList = new ArrayList<>();
        Session session = sessionFactory.openSession();
        String userInfoGetQuery = "from UserInfo";

        try{
            Query query = session.createQuery(userInfoGetQuery);
            userInfoList = query.list();
        }
        catch (Exception e){
            e.printStackTrace();
        }
        finally {
            if(session !=null){
                session.close();
            }
        }
        return userInfoList;
    }
}
