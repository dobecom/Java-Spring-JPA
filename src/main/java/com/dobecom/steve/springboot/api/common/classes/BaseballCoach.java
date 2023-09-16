package com.dobecom.steve.springboot.api.common.classes;

import com.dobecom.steve.springboot.api.common.interfaces.Coach;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Component;

@Component // Define the dependency
@Primary // Priority : @Qualifier (High) > @Primary
public class BaseballCoach implements Coach {
    @Override
    public String getDailyWorkout() {
        return "Practice baseball for 15 minutes";
    }
}
