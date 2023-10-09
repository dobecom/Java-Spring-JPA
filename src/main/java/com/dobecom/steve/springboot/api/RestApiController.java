package com.dobecom.steve.springboot.api;

import com.dobecom.steve.springboot.api.common.CommonErrorResponse;
import com.dobecom.steve.springboot.api.common.CommonNotFoundException;
import com.dobecom.steve.springboot.api.common.entities.User;
import com.dobecom.steve.springboot.api.common.services.UserService;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

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

        return userService.findUser(userId);
    }
}
