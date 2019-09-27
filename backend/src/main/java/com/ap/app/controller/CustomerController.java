package com.ap.app.controller;

import java.util.Collection;
import java.util.stream.Collectors;

import com.ap.app.entity.Customer;
import com.ap.app.repository.CustomerRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@CrossOrigin(origins = "http://localhost:8080")
@RequestMapping("/api")
public class CustomerController{

    @Autowired
    private final CustomerRepository customerrepository;

    public CustomerController(CustomerRepository customerrepository) {
        this.customerrepository = customerrepository;
    }

    @GetMapping("/cm")
    public Collection<Customer> getAllCustomers(){
        return customerrepository.findAll().stream().collect(Collectors.toList());
    }

}