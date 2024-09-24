package com.example.dao;

import com.example.entity.Inventory;
import com.example.entity.InventoryCategory;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

public class InventoryDao {
    SessionFactory sessionFactory;

    InventoryDao(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    @Transactional(propagation = Propagation.REQUIRES_NEW)
    public String saveInventory(Inventory inventory) {
        Session session = sessionFactory.getCurrentSession();
        String message = "";
        try {
            session.saveOrUpdate(inventory);
            message = "inventory data saved!";

        } catch (Exception e) {
            e.printStackTrace();
            message = "inventory did not saved!";
        }
        return message;
    }

    @Transactional(propagation = Propagation.REQUIRES_NEW)
    public Inventory findByName(String inventoryName) {
        Session session = sessionFactory.getCurrentSession();
        Inventory inventory = null;
        try {
            String getQuery = "from Inventory where inventoryName=:inventoryName";
            Query query = session.createQuery(getQuery);
            query.setParameter("inventoryName", inventoryName);
            query.setMaxResults(1);
            inventory = (Inventory) query.uniqueResult();
        } catch (Exception e) {
            e.printStackTrace();

        }
        return inventory;
    }

    @Transactional(propagation = Propagation.REQUIRES_NEW)
    public List<Inventory> getAllInventory() {
        Session session = sessionFactory.getCurrentSession();
        List<Inventory> inventoryList = null;
        try {
            String getAllQuery = "from Inventory ";
            Query query = session.createQuery(getAllQuery);
            inventoryList = query.list();
        } catch (Exception e) {
            e.printStackTrace();
            sessionFactory.getCurrentSession().clear();
            throw e;
        }
        return inventoryList;

    }
}
