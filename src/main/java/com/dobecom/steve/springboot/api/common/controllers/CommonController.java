package com.dobecom.steve.springboot.api.common.controllers;

import com.dobecom.steve.springboot.api.common.interfaces.Coach;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
//@RequestMapping("/common")
public class CommonController {
    // @Autowired // Dependency injection (Field injection) [Not recommended]
    // reason : hard to take the unit test
    private Coach myCoach;

//    @Autowired // Dependency injection (Setter injection) [Optional]
//    // not only "setter" but also "any method" can be used for dependency injection
//    public void setCoach(Coach theCoach) {
//        myCoach = theCoach;
//    }

    @Autowired // Dependency injection (Constructor injection) [Recommended]
    public CommonController(
            // If interface that have multiple classes is injected, @Qualifier is required
            @Qualifier("cricketCoach")
            Coach theCoach) {
        System.out.println("In CommonController constructor : " + getClass().getSimpleName());
        myCoach = theCoach;
    }

    @GetMapping("/dailyworkout")
    public String getDailyWorkout() {
        return myCoach.getDailyWorkout();
    }

//    @PostMapping("/common")
//    public void createUser(
//    ) {
//
//    }
}
