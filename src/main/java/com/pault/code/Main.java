package com.pault.code;

import lombok.extern.java.Log;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@Log
@SpringBootApplication
@RestController
public class Main {
    public static void main(String[] args) {

        log.info("Hello Paul !");
        SpringApplication.run(Main.class, args);
    }

    @GetMapping("/greet")
    public GreetResponse greet() {
        return new GreetResponse("Hi...Paul", List.of("Java", "Python", "C++"), new Person("Rory", 19, -30_000.12));
    }

    record Person(String name, int age, double money) {
    }

    record GreetResponse(
            String greet,
            List<String> faveProgrammingLanguages,
            Person person) {
    }
}
