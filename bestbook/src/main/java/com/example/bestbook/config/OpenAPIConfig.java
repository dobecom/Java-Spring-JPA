package com.example.bestbook.config;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.enums.SecuritySchemeType;
import io.swagger.v3.oas.annotations.info.Info;
import io.swagger.v3.oas.annotations.security.SecurityScheme;
import io.swagger.v3.oas.models.OpenAPI;
import org.springframework.context.annotation.Configuration;

@OpenAPIDefinition(info = @Info(title = "Microservice - Best Book", version = "1.0", description = "Best Book"))
@SecurityScheme(
        name = "Bearer Authentication",
        type = SecuritySchemeType.HTTP,
        scheme = "Bearer"
)
@Configuration
public class OpenAPIConfig {
    public OpenAPI openAPI() {
        return new OpenAPI();
    }
}
