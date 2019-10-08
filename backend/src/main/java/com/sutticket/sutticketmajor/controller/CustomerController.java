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

import java.io.IOException;
import java.sql.Timestamp;
import java.util.Collection;
import java.util.Date;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.stream.Collectors;
import org.springframework.web.bind.annotation.CrossOrigin;

import com.sutticket.sutticketmajor.entity.Carrer;
import com.sutticket.sutticketmajor.entity.Customer;
import com.sutticket.sutticketmajor.entity.RangeAge;
import com.sutticket.sutticketmajor.entity.Sex;
import com.sutticket.sutticketmajor.repository.CarrerRepository;
import com.sutticket.sutticketmajor.repository.CustomerRepository;
import com.sutticket.sutticketmajor.repository.RangeAgeRepository;
import com.sutticket.sutticketmajor.repository.SexRepository;

@CrossOrigin(origins = "http://localhost:8080")
@RestController
@RequestMapping("/api")
public class CustomerController {
    @Autowired
    private CustomerRepository customerRepository;
    @Autowired
    private RangeAgeRepository rangeagerepository;
    @Autowired
    private CarrerRepository carrerrepository;
    @Autowired
    private SexRepository sexrepository;

    @GetMapping("/customers")
    public Collection<Customer> customer() {
        return customerRepository.findAll().stream().collect(Collectors.toList());
    }

    @GetMapping("/customer/{id}")
    public Customer getCustomer(@PathVariable long id ){
        return customerRepository.findById(id);
    }
    @GetMapping("/customer/{username}/{password}")
    public Customer customerfindByUsername(@PathVariable String username, @PathVariable String password){
        return customerRepository.findByUsernameAndPassword(username, password);

    }
    

    @PostMapping("/customer/{sex_id}/{rangeAge_id}/{carrer_id}/{name}/{username}/{password}")
    public Customer newcustomer(Customer newCustomer,
    @PathVariable String name,
    @PathVariable String username,
    @PathVariable String password,
    @PathVariable long rangeAge_id,
    @PathVariable long carrer_id,
    @PathVariable long sex_id) {
    

    RangeAge rangeage = rangeagerepository.findById(rangeAge_id);
    Carrer carrer = carrerrepository.findById(carrer_id);
    Sex sex = sexrepository.findById(sex_id);
    
    newCustomer.setName(name);
    newCustomer.setUsername(username);
    newCustomer.setPassword(password);
    newCustomer.setSex(sex);
    newCustomer.setRangeAge(rangeage);
    newCustomer.setCarrer(carrer);
    


    return customerRepository.save(newCustomer); 
    
    }
}