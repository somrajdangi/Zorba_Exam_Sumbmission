package com.example.dao;

import com.example.entity.Inventory;
import com.example.entity.InventoryCategory;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;


public class InventoryCategoryDao {
    SessionFactory sessionFactory;

    InventoryCategoryDao(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    @Transactional(propagation = Propagation.REQUIRES_NEW)
    public String saveInventory(InventoryCategory inventoryCategory) {
        Session session = sessionFactory.getCurrentSession();
        String message = "";
        try {
            session.saveOrUpdate(inventoryCategory);
            message = "inventory category data saved!";

        } catch (Exception e) {
            e.printStackTrace();
            message = "inventory category data did not saved!";
        }
        return message;
    }

    @Transactional(propagation = Propagation.REQUIRES_NEW)
    public InventoryCategory findByCategoryName(String categoryName) {
        Session session = sessionFactory.getCurrentSession();
        InventoryCategory inventoryCategory = null;
        try {
            String getQuery = "from InventoryCategory where categoryName=:categoryName";
            Query query = session.createQuery(getQuery);
            query.setParameter("categoryName",categoryName);
            query.setMaxResults(1);
            inventoryCategory = (InventoryCategory) query.uniqueResult();
        } catch (Exception e) {
            e.printStackTrace();

        }
        return inventoryCategory;
    }
}
