package com.dobecom.steve.springboot.api.common.services;

import com.dobecom.steve.springboot.api.common.dao.UserDAOImpl;
import com.dobecom.steve.springboot.api.common.entities.User;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {
    private final UserDAOImpl userDAOImpl;

    public UserService(UserDAOImpl userDAOImpl) {
        this.userDAOImpl = userDAOImpl;
    }

    public List<User> getAllUsers() {
        return userDAOImpl.findAllSteve();
    }

    public User findUser(int id) {
        return userDAOImpl.findById(id);
    }
}
