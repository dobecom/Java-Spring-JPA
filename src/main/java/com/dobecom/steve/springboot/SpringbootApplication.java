package com.dobecom.steve.springboot;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
// If you want to scan the components that is placed different root package, It's required to put the option like below on this annotation
//        (scanBasePackages = {"com.dobecom.steve.springboot.diff.location"})
public class SpringbootApplication {
    public static void main(String[] args) {
        SpringApplication.run(SpringbootApplication.class, args);
    }
}
