package com.example;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.stereotype.Component;

@SpringBootApplication()
@ComponentScan("com.example.controller")
public class Application {
    public static void main(String[] args) {
        System.setProperty("server.port", "8081");
        SpringApplication.run(Application.class, args);
    }

}