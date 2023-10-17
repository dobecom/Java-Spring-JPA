package com.dobecom.steve.springboot.api.common.services;

import com.dobecom.steve.springboot.api.common.dao.UserDAOImpl;
import com.dobecom.steve.springboot.api.common.entities.User;

import java.util.List;

public interface UserService {
    List<User> getAllUsers();

    User findUserById(int id);

    User save(User user);

    void deleteById(int id);
}
