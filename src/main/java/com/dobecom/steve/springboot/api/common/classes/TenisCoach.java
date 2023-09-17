package com.dobecom.steve.springboot.api.common.classes;

import com.dobecom.steve.springboot.api.common.interfaces.Coach;
import jakarta.annotation.PostConstruct;
import jakarta.annotation.PreDestroy;
import org.springframework.context.annotation.Lazy;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

//@Component // Define the dependency
@Scope("prototype") // Create new instance for each request
@Lazy // Lazy loading (only when needed for dependency injection)
public class TenisCoach implements Coach {

    public TenisCoach() {
        System.out.println("TenisCoach : inside default constructor");
    }
    @Override
    public String getDailyWorkout() {
        return "Practice tenis for 15 minutes";
    }

    @PostConstruct
    public void doMyStartupStuff() {
        System.out.println("TenisCoach : inside method doMyStartupStuff");
    }

    @PreDestroy
    public void doMyCleanupStuff() {
        System.out.println("TenisCoach : inside method doMyCleanupStuff");
    }
}
