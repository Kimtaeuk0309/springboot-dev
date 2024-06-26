package me.taeuk.springbootdev;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@EnableJpaAuditing
@SpringBootApplication

public class springbootdevApp {
    public static void main(String[] args) {
        SpringApplication.run(springbootdevApp.class, args);
    }
}
