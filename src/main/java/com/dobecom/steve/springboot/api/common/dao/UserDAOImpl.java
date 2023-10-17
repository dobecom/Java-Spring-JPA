package com.dobecom.steve.springboot.api.common.dao;

import com.dobecom.steve.springboot.api.common.entities.User;
import jakarta.persistence.EntityManager;
import jakarta.persistence.TypedQuery;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class UserDAOImpl implements UserDAO {
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

    @Override
    @Transactional
    public void update(User user) {
        entityManager.merge(user);
    }

    @Override
    @Transactional
    public int deleteAll(String firstName) {
        int numRowsDeleted = entityManager.createQuery("DELETE FROM User u WHERE firstName=:firstName")
                .setParameter("firstName", firstName)
                .executeUpdate();
        return numRowsDeleted;
    }

    @Override
    public User saveByApi(User user) {
        // merge는 entity의 id 값에 따라 insert (id == 0) 또는 update (id != 0) 처리 됨
        User dbUser = entityManager.merge(user);
        return dbUser;
    }

    @Override
    public void deleteById(int id) {
        User user = entityManager.find(User.class, id);
        entityManager.remove(user);
    }
}
