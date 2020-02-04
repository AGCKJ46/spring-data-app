package net.ckj46.springdataapp;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

import java.util.LinkedList;
import java.util.List;

@EnableJpaAuditing
@SpringBootApplication
public class SpringDataAppApplication {

    public static void main(String[] args) {
        SpringApplication.run(SpringDataAppApplication.class, args);
    }

}
