package com.pault.code;

import lombok.extern.java.Log;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

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

    @PostMapping
    public void addCustomer(@RequestBody NewCustomerRequest request) {
        Customer customer = new Customer();
        customer.setName(request.name);
        customer.setEmail(request.email);
        customer.setAge(request.age);
        customerRepository.save(customer);
    }

    @PutMapping("{customerId}")
    public void updateCustomer(@PathVariable("customerId") Integer id, @RequestBody NewCustomerRequest request) {
        Optional<Customer> customer = customerRepository.findById(id);
        customer.get().setName(request.name);
        customer.get().setEmail(request.email);
        customer.get().setAge(request.age);
        customerRepository.save(customer.get());
    }

    @DeleteMapping("{customerId}")
    public void deleteCustomer(@PathVariable("customerId") Integer id) {
        customerRepository.deleteById(id);
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

    record NewCustomerRequest(String name, String email, Integer age) {

    }
}

