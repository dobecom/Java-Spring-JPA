package com.dobecom.steve.springboot.api.common.configs;

import com.dobecom.steve.springboot.api.common.classes.TenisCoach;
import com.dobecom.steve.springboot.api.common.interfaces.Coach;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class SportConfig {

    // This bean id defaults to the method name
    @Bean
    public Coach tenisCoach() {
        return new TenisCoach();
    }
}
