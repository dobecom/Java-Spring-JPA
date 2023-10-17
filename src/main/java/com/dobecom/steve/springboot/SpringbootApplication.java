package com.dobecom.steve.springboot;

import com.dobecom.steve.springboot.api.common.dao.UserDAO;
import com.dobecom.steve.springboot.api.common.entities.User;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.List;

@SpringBootApplication
// If you want to scan the components that is placed different root package, It's required to put the option like below on this annotation
//        (scanBasePackages = {"com.dobecom.steve.springboot.diff.location"})
public class SpringbootApplication {
    public static void main(String[] args) {
        SpringApplication.run(SpringbootApplication.class, args);
    }

    // Test code for Command Line App
//    @Bean
//    public CommandLineRunner commandLineRunner(UserDAO userDAO){
//        return args -> {
//            System.out.println("Hello World from Spring Boot!");
//            try{
//                createUser(userDAO);
//                updateUser(userDAO);
//                deleteUser(userDAO);
//                deleteAllUsers(userDAO);
//            }catch(Exception e){
//                System.out.println("Exception: " + e.getMessage());
//            }
//        };
//    }

    private void deleteAllUsers(UserDAO userDAO) {
        int numRowsDeleted = userDAO.deleteAll("steve");
        System.out.println("Users deleted: " + numRowsDeleted);
    }

    private void deleteUser(UserDAO userDAO) {
        userDAO.deleteById(3);
        System.out.println("User deleted");
    }

    private void updateUser(UserDAO userDAO) {
        User user = userDAO.findById(2);
        user.setFirstName("steve2");
        userDAO.update(user);
        System.out.println("User updated with name: " + user.getFirstName());
    }


    private void createUser(UserDAO userDAO) {
        User user = new User("steve");
        userDAO.save(user);
        String name = user.getFirstName();
        System.out.println("User created with name: " + name);

//        String getUser = userDAO.findById(2).getFirstName();
//        System.out.println("User retrieved with name: " + getUser);

        List<User> users = userDAO.findAllSteve();
        System.out.println("Users retrieved: " + users.size());
    }
}
