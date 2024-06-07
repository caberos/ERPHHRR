package com.diplomado.springboot.config;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Info;
import org.springframework.context.annotation.Configuration;

@Configuration
@OpenAPIDefinition(
        info = @Info(
                title = "ERP HHRR",
                version = "1.0.0",
                description = "Diplomado experto en desarrollo de aplicaciones"
        )
)
public class OpenApiConfig {
}
