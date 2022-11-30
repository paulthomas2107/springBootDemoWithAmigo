package com.pault.code;

import lombok.extern.java.Log;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.Mapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@Log
@SpringBootApplication
@RestController
@RequestMapping("api/v1/customers")
public class Main {

    private final CustomerRepository customerRepository;

    public Main(CustomerRepository customerRepository) {
        this.customerRepository = customerRepository;
    }
    public static void main(String[] args) {

        log.info("Hello Paul !");
        SpringApplication.run(Main.class, args);
    }



    @GetMapping
    public List<Customer> getCustomers() {
        return customerRepository.findAll();
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
