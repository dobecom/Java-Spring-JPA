package com.dobecom.steve.springboot.api;

import com.dobecom.steve.springboot.api.common.CommonNotFoundException;
import com.dobecom.steve.springboot.api.common.entities.User;
import com.dobecom.steve.springboot.api.common.services.UserService;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class RestApiController {

    private final UserService userService;

    @Value("${team.name}")
    private String teamName;

    public RestApiController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping("/")
    public String sayHello() {
        String name = "Steve (TEAM :" + teamName + ")";
        return "Hello World! " + name;
    }

    @GetMapping("/users")
    public List<User> getUsers() {
        System.out.println("In getUsers : " + getClass().getSimpleName());
        return userService.getAllUsers();
    }

    @GetMapping("/users/{userId}")
    public User getUser(@PathVariable int userId) {
        if (userId <= 0) {
            throw new CommonNotFoundException("User id not found - " + userId);
        }

        User user = userService.findUserById(userId);
        if (user == null) {
            throw new CommonNotFoundException("User id not found - " + userId);
        }

        return user;
    }

    @PostMapping("/users")
    public User saveUser(@RequestBody User user) {
        User savedUser = userService.save(user);
        return savedUser;
    }

    @PutMapping("/users")
    public User updateUser(@RequestBody User user) {
        User updatedUser = userService.save(user);
        return updatedUser;
    }

    @DeleteMapping("/users/{userId}")
    public String deleteUser(@PathVariable int userId){
        User user = userService.findUserById(userId);
        if(user == null){
            throw new RuntimeException("User is not found - " + userId);
        }
        userService.deleteById(userId);
        return "Delete user id - " + userId;
    }
}
