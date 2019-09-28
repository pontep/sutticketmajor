package com.france.france.controller;

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

import java.io.IOException;
import java.sql.Timestamp;
import java.util.Collection;
import java.util.Date;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.stream.Collectors;


import com.france.france.entity.*;


import com.france.france.repository.*;



import org.springframework.web.bind.annotation.CrossOrigin;

@CrossOrigin(origins = "http://localhost:8081")
@RestController
@RequestMapping("/api")
public class Customercontroller {
    @Autowired
    private final Customerrepository customerrepository;
    @Autowired
    private RangeAgerepository rangeagerepository;
    @Autowired
    private Carrerrepository carrerrepository;
    @Autowired
    private Sexrepository sexrepository;
    
    

    Customercontroller(Customerrepository customerrepository) {
        this.customerrepository = customerrepository;
    }

    @GetMapping("/customer")
    public Collection<Customer> customer() {
        return customerrepository.findAll().stream().collect(Collectors.toList());
    }

    @PostMapping("/Customer/{sex_id}/{rangeage_id}/{carrer_id}")
    public Customer newcustomer(Customer newCustomer,
    @RequestBody Customer customer,
    @PathVariable long rangeage_id,
    @PathVariable long carrer_id,
    @PathVariable long sex_id) {
    

    RangeAge rangeage = rangeagerepository.findById(rangeage_id);
    Carrer carrer = carrerrepository.findById(carrer_id);
    Sex sex = sexrepository.findById(sex_id);
    
    newCustomer.setName(customer.getName());
    newCustomer.setUsername(customer.getUsername());
    newCustomer.setPassword(customer.getPassword());
    newCustomer.setSex(sex);
    newCustomer.setRangeAge(rangeage);
    newCustomer.setCarrer(carrer);
    


    return customerrepository.save(newCustomer); 
    
    }
}