package com.dobecom.steve.springboot.api.common.classes;

import com.dobecom.steve.springboot.api.common.interfaces.Coach;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Component;

@Component // Define the dependency
@Lazy // Lazy loading (only when needed for dependency injection)
public class TenisCoach implements Coach {
    @Override
    public String getDailyWorkout() {
        return "Practice tenis for 15 minutes";
    }
}
