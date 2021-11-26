package com.dkyou.chap04;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@SpringBootApplication
@EnableJpaAuditing
public class Chap04Application {

    public static void main(String[] args) {
        SpringApplication.run(Chap04Application.class, args);
    }

}
