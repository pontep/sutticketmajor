package com.sutticket.sutticketmajor.controller;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.json.JsonParseException;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.CrossOrigin;

import java.io.IOException;
import java.sql.Timestamp;
import java.util.Collection;
import java.util.Date;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.stream.Collectors;

import com.sutticket.sutticketmajor.entity.*;
import com.sutticket.sutticketmajor.repository.*;


@CrossOrigin(origins = "http://localhost:8081")
@RestController
@RequestMapping("/api")
public class CustomerController {
    @Autowired
    private final CustomerRepository customerRepository;
    @Autowired
    private RangeAgeRepository rangeageRepository;
    @Autowired
    private CareerRepository careerRepository;
    @Autowired
    private SexRepository sexRepository;
    
    

    CustomerController(CustomerRepository customerRepository) {
        this.customerRepository = customerRepository;
    }

    @GetMapping("/customer")
    public Collection<Customer> customer() {
        return customerRepository.findAll().stream().collect(Collectors.toList());
    }

    @PostMapping("/Customer/{sex_id}/{rangeage_id}/{career_id}")
    public Customer newcustomer(Customer newCustomer,
    @RequestBody Customer customer,
    @PathVariable long rangeage_id,
    @PathVariable long career_id,
    @PathVariable long sex_id) {
        
    

    RangeAge rangeage = rangeageRepository.findById(rangeage_id);
    Career career = careerRepository.findById(career_id);
    Sex sex = sexRepository.findById(sex_id);
    
    newCustomer.setName(customer.getName());
    newCustomer.setUsername(customer.getUsername());
    newCustomer.setPassword(customer.getPassword());
    newCustomer.setSex(sex);
    newCustomer.setRangeAge(rangeage);
    newCustomer.setCareer(career);
    
    return customerRepository.save(newCustomer); 
    
    }
}