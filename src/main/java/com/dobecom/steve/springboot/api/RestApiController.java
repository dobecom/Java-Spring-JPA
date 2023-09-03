package com.dobecom.steve.springboot.api;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class RestApiController {
    @Value("${team.name}")
    private String teamName;

    @GetMapping("/")
    public String sayHello() {
        String name = "Steve (TEAM :" + teamName + ")";
        return "Hello World! " + name;
    }
}
