package com.dobecom.steve.springboot.api.common.classes;

import com.dobecom.steve.springboot.api.common.interfaces.Coach;
import org.springframework.stereotype.Component;

@Component // Define the dependency
public class CricketCoach implements Coach {
    @Override
    public String getDailyWorkout() {
        return "Practice fast bowling for 15 minutes";
    }
}
