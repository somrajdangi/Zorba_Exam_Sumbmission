package com.example.dao;

import com.example.model.UserInfoModel;
import org.hibernate.Query;
import org.hibernate.SessionFactory;
import org.hibernate.Session;
import java.util.ArrayList;
import java.util.List;

public class UserInfoDAOImpl implements UserInfoDAO {
    SessionFactory sessionFactory;

    public void saveUserInfo(UserInfoModel userInfoModel) {
        Session session = sessionFactory.getCurrentSession();
        try {
            session.persist(userInfoModel);
        } catch (Exception e) {
            e.printStackTrace();

        } finally {
            if (session != null) {
                session.close();
            }
        }
    }

    public List<UserInfoModel> getAllUserInfo() {
        List<UserInfoModel> userInfoModelList = new ArrayList<>();
        Session session = sessionFactory.openSession();
        String userInfoGetQuery = "from UserInfo";

        try{
            Query query = session.createQuery(userInfoGetQuery);
            userInfoModelList = query.list();
        }
        catch (Exception e){
            e.printStackTrace();
        }
        finally {
            if(session !=null){
                session.close();
            }
        }
        return userInfoModelList;
    }
}
