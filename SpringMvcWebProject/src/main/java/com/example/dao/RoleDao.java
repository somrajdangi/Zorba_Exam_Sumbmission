package com.example.dao;

import com.example.entity.Role;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.ui.Model;

public class RoleDao {
    SessionFactory sessionFactory;

    public RoleDao(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    @Transactional(propagation = Propagation.REQUIRES_NEW)
    public Role getRoleByName(String roleName) {
        Session session = sessionFactory.getCurrentSession();
        String getQuery = "from Role where roleName=:roleName";
        Query query = session.createQuery(getQuery);
        query.setParameter("roleName", roleName);
        Role role = (Role) query.uniqueResult();
        return role;
    }

    @Transactional(propagation = Propagation.REQUIRES_NEW)
    public String updateUserToCustomer() {
        String hql = "UPDATE Role r SET r.roleName = :newRole WHERE r.roleName = :oldRole AND r IN (SELECT roles FROM UserInfo u JOIN u.roleList roles WHERE roles.roleName = :oldRole)";
        Query query = sessionFactory.getCurrentSession().createQuery(hql);
        query.setParameter("newRole","customer");
        query.setParameter("oldRole", "user");
        return "data udated";
    }
}

