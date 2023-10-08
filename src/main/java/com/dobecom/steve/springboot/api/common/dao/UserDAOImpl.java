package com.dobecom.steve.springboot.api.common.dao;

import com.dobecom.steve.springboot.api.common.entities.User;
import jakarta.persistence.EntityManager;
import jakarta.persistence.TypedQuery;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class UserDAOImpl implements UserDAO{
    private EntityManager entityManager;

    @Autowired
    public UserDAOImpl(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    @Override
    @Transactional
    public void save(User user) {
        entityManager.persist(user);
    }

    @Override
    public User findById(int id) {
        return entityManager.find(User.class, id);
    }

    @Override
    public List<User> findAllSteve() {
        TypedQuery<User> query = entityManager.createQuery("SELECT u FROM User u WHERE firstName=:firstName", User.class);

        // Named Parameter
        query.setParameter("firstName", "steve");
        List<User> users = query.getResultList();
        return users;
    }
}
