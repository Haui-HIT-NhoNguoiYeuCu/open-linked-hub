package com.openlinkedhub.authservice;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.enums.SecuritySchemeType;
import io.swagger.v3.oas.annotations.info.Info;
import io.swagger.v3.oas.annotations.security.SecurityScheme;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.event.EventListener;
import org.springframework.boot.context.event.ApplicationReadyEvent;

@SpringBootApplication
@OpenAPIDefinition(info = @Info(
        title = "Auth Service API",
        version = "1.0",
        description = "API cho việc xác thực và quản lý người dùng"
))
@SecurityScheme(
        name = "bearerAuth",
        type = SecuritySchemeType.HTTP,
        scheme = "bearer",
        bearerFormat = "JWT"
)
public class AuthServiceApplication {

    @Value("${server.port:8080}")
    private int serverPort;

    @Value("${server.servlet.context-path:}")
    private String contextPath;

    public static void main(String[] args) {
        SpringApplication.run(AuthServiceApplication.class, args);
    }

    @EventListener(ApplicationReadyEvent.class)
    public void printSwaggerUrl() {
        String base = "http://localhost:" + serverPort + (contextPath == null ? "" : contextPath);
        System.out.println("\n==============================================");
        System.out.println("Swagger UI: " + base + "/swagger-ui/index.html");
        System.out.println("==============================================\n");
    }

}
