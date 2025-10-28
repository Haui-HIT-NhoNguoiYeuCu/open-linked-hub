package com.openlinkedhub.datasetservice;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Info;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.event.EventListener;

@SpringBootApplication
@OpenAPIDefinition(info = @Info(
        title = "Dataset Service API",
        version = "1.0",
        description = "API quản lý siêu dữ liệu (metadata) cho các bộ dữ liệu"
))
public class DatasetServiceApplication {

    @Value("${server.port:8081}")
    private int serverPort;

    @Value("${server.servlet.context-path:}")
    private String contextPath;

    public static void main(String[] args) {
        SpringApplication.run(DatasetServiceApplication.class, args);
    }

    @EventListener(ApplicationReadyEvent.class)
    public void printSwaggerUrl() {
        String base = "http://localhost:" + serverPort + (contextPath == null ? "" : contextPath);
        System.out.println("\n==============================================");
        System.out.println("Swagger UI: " + base + "/swagger-ui/index.html");
        System.out.println("==============================================\n");
    }


}