package com.example.dao;

import com.example.entity.InventoryCategoryEntity;
import com.example.entity.InventoryEntity;
import com.example.entity.UserInfoEntity;
import org.hibernate.Query;
import org.hibernate.SessionFactory;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

public class UserInfoDAO {
    private SessionFactory sessionFactory;

    //constructor di
    public UserInfoDAO(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    @Transactional(propagation = Propagation.REQUIRES_NEW)
    public String saveUserInfo(UserInfoEntity userInfoEntity) {
        String response = "";
        Session session = sessionFactory.getCurrentSession();//if error, use openSession()

        try {
            session.persist(userInfoEntity);

            response = "data saved successfully";

        } catch (Exception e) {
            e.printStackTrace();
            response = "data not saved";

        }
        return response;
    }

    public List<UserInfoEntity> getAllUserInfo() {
        Session session = sessionFactory.openSession();
        String hqlGetQuery = "from UserInfoEntity";
        List<UserInfoEntity> userInfoEntityList = new ArrayList<>();
        try {
            Query query = session.createQuery(hqlGetQuery);
            userInfoEntityList = query.list();

        } catch (Exception e) {
            e.printStackTrace();
        }
        return userInfoEntityList;
    }

    @Transactional(propagation = Propagation.REQUIRES_NEW)
    public UserInfoEntity findById(Integer id) {


        return null;
    }

    public void saveUserRole(String userId, String role) {
        Session session = sessionFactory.getCurrentSession();
        try {
            //save role into db
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    //exam section
    public UserInfoEntity getVendorData(String name, String password, String role) {
        Session session = sessionFactory.getCurrentSession();
        Transaction tx = null;
        UserInfoEntity user = null;

        try {
            tx = session.beginTransaction();
            String getVandorHql = "from UserInfoEntity where userName=:name AND userPassword=:password AND userRole=:role";
            Query query = session.createQuery((getVandorHql));
            query.setParameter("name", name);
            query.setParameter("password", password);
            query.setParameter("role", role);
            user = (UserInfoEntity) query.uniqueResult();
            tx.commit();
        } catch (Exception e) {
            if (tx != null) {
                tx.rollback();
            }
            e.printStackTrace();
        }

        return user;
    }

    public String saveInventoryCategoryEntity(InventoryCategoryEntity inventoryCategoryEntity) {

        String response = "";
        Session session = sessionFactory.getCurrentSession();//if error, use openSession()

        try {
            session.persist(inventoryCategoryEntity);

            response = "data saved successfully";

        } catch (Exception e) {
            e.printStackTrace();
            response = "data not saved";

        }
        return response;

    }

    public String saveInventoryEntity(InventoryEntity inventoryEntity) {

        String response = "";
        Session session = sessionFactory.getCurrentSession();//if error, use openSession()

        try {
            session.persist(inventoryEntity);

            response = "data saved successfully";

        } catch (Exception e) {
            e.printStackTrace();
            response = "data not saved";

        }
        return response;

    }

    public UserInfoEntity getCustomerData(String name, String password, String role) {
        return validate(name, password, role);
    }

    public UserInfoEntity getAdminData(String name, String password, String role) {
        return validate(name, password, role);
    }

    public UserInfoEntity validate(String name, String password, String role) {
        Session session = sessionFactory.getCurrentSession();
        Transaction tx = null;
        UserInfoEntity user = null;

        try {
            tx = session.beginTransaction();
            String getVandorHql = "from UserInfoEntity where userName=:name AND userPassword=:password AND userRole=:role";
            Query query = session.createQuery((getVandorHql));
            query.setParameter("name", name);
            query.setParameter("password", password);
            query.setParameter("role", role);
            user = (UserInfoEntity) query.uniqueResult();
            tx.commit();
        } catch (Exception e) {
            if (tx != null) {
                tx.rollback();
            }
            e.printStackTrace();
        }

        return user;
    }

    public UserInfoEntity getAllUserWithRoleVendor(String role) {
        //fetch all vendor data where role is role;
        return getAllUserWithRole(role);
    }

    public UserInfoEntity getAllUserWithRoleCustomer(String role) {
        //fetch all customer  where role is role
        return getAllUserWithRole(role);

    }

    public UserInfoEntity getAllUserWithRole(String role) {
        Session session = sessionFactory.getCurrentSession();
        Transaction tx = null;
        UserInfoEntity user = null;

        try {
            tx = session.beginTransaction();
            String getVandorHql = "from UserInfoEntity where userRole=:role ";
            Query query = session.createQuery((getVandorHql));
            user = (UserInfoEntity) query.uniqueResult();
            tx.commit();
        } catch (Exception e) {
            if (tx != null) {
                tx.rollback();
            }
            e.printStackTrace();
        }

        return user;
    }


}

