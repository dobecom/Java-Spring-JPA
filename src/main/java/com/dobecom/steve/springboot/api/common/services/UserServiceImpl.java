package com.dobecom.steve.springboot.api.common.services;

import com.dobecom.steve.springboot.api.common.dao.UserDAO;
import com.dobecom.steve.springboot.api.common.entities.User;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServiceImpl implements UserService {
    private final UserDAO userDAO;

    @Autowired
    public UserServiceImpl(UserDAO userDAO) {
        this.userDAO = userDAO;
    }

    @Override
    public List<User> getAllUsers() {
        return userDAO.findAllSteve();
    }

    @Override
    public User findUserById(int id) {
        return userDAO.findById(id);
    }

    @Override
    @Transactional
    public User save(User user) {
        User savedUser = userDAO.saveByApi(user);
        return savedUser;
    }

    @Override
    @Transactional
    public void deleteById(int id) {
        userDAO.deleteById(id);
    }
}

