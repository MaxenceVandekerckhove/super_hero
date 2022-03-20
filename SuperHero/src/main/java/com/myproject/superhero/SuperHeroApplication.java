package com.myproject.superhero;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
@RestController
public class SuperHeroApplication {

    public static void main(String[] args) {
            SpringApplication.run(SuperHeroApplication.class, args);
    }
}
