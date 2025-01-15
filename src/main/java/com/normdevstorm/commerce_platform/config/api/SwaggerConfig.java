package com.normdevstorm.commerce_platform.config.api;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.enums.SecuritySchemeIn;
import io.swagger.v3.oas.annotations.enums.SecuritySchemeType;
import io.swagger.v3.oas.annotations.info.Contact;
import io.swagger.v3.oas.annotations.info.Info;
import io.swagger.v3.oas.annotations.security.SecurityRequirement;
import io.swagger.v3.oas.annotations.security.SecurityScheme;
import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.servers.Server;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.List;

@Configuration
@OpenAPIDefinition
        (info = @Info(contact = @Contact(name = "normdevstorm", email = "normdevstorm@gmail.com", url = "normdev.storm.com"), version = "1.0.0", description = "API for testing request huiii", title = "Commerce"))
@SecurityScheme(name = "bearerAuth",
        description = "JWT authentication",
        scheme = "bearer",
        type = SecuritySchemeType.HTTP,
        bearerFormat = "JWT",
        in = SecuritySchemeIn.HEADER)
public class SwaggerConfig {

//    @Bean
//    public OpenAPI customOpenAPI() {
//        Server server = new Server();
//        server.setUrl("https://api.normdevstorm.online/normdevstorm");
//        return new OpenAPI().servers(List.of(server));
//    }

}
