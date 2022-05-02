package com.redis.poc.controller;

import com.redis.poc.model.Customer;
import com.redis.poc.repository.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

@RestController
@RequestMapping("/redis")
public class WebController {

    @Autowired
    private CustomerRepository customerRepository;

    @GetMapping(value = "/save")
    public String save(){

        customerRepository.save(new Customer(1, "Jack", "Smith"));
        customerRepository.save(new Customer(2, "Diego", "Peter"));
        customerRepository.save(new Customer(3, "Peter", "John"));
        customerRepository.save(new Customer(4, "Jason", "Bob"));
        customerRepository.save(new Customer(5, "Merry", "kill"));

        return "Save Operation Executed Successfully.";
    }

    @GetMapping(value = "/findAll")
    public String findAll(){
        String result = "";
        Map<Long, Customer> customers = customerRepository.findAll();
        for (Customer customer : customers.values()) {
            result += customer.toString() + "<br>";
        }
        return result;
    }
}
