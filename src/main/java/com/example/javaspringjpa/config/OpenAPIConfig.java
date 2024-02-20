package com.example.javaspringjpa.config;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Info;
import io.swagger.v3.oas.models.OpenAPI;
import org.springframework.context.annotation.Configuration;

@OpenAPIDefinition(info = @Info(title = "Java Spring JPA", version = "1.0", description = "Java Spring JPA"))
@Configuration
public class OpenAPIConfig {
    public OpenAPI openAPI() {
        return new OpenAPI();
    }
}
