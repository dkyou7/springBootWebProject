package com.dkyou.chap05;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@SpringBootApplication
@EnableJpaAuditing
public class Chap05Application {

    public static void main(String[] args) {
        SpringApplication.run(Chap05Application.class, args);
    }

}
