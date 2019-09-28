package com.sutticket.sutticketmajor.controller;

import java.util.Collection;
import java.util.stream.Collectors;

import com.sutticket.sutticketmajor.entity.Customer;
import com.sutticket.sutticketmajor.repository.CustomerRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@CrossOrigin(origins = "http://localhost:8080")
@RequestMapping("/api")
public class CustomerController{
    
    @Autowired
    CustomerRepository repository;

    @GetMapping("/customers")
    public Collection<Customer> getAllCustomer(){
        return repository.findAll().stream().collect(Collectors.toList());
    }
    
    @PostMapping("/customer")
    public Customer postCustomer(Customer newcustomer, @RequestBody Customer customer){
        newcustomer.setUsername(customer.getUsername());        
        newcustomer.setName(customer.getName());
        newcustomer.setPassword(customer.getPassword());

        return repository.save(newcustomer);
    }
    //test send data string using pathvariable
    @PostMapping("/newcustomer2/{name}/{username}/{password}")
    public Customer newCustomer2(@PathVariable String name, @PathVariable String username, @PathVariable String password){
        Customer cus = new Customer(name,username,password);
        return repository.save(cus);
    }
    //using body data
    @PostMapping("/newcustomer")
    public Customer newCustomer(@RequestBody Customer customer){
        Customer _customer = repository.save(new Customer(customer.getName(), customer.getUsername(), customer.getPassword()));

        return _customer;
    }

}