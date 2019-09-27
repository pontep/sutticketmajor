package com.okta.spring.controller;

import java.util.Collection;
import java.util.stream.Collectors;

import com.okta.spring.entity.Employee;
import com.okta.spring.repository.EmployeeRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RequestMapping("/api")
@CrossOrigin(origins = "http://localhost:8080")
@RestController
public class EmployeeController{
    @Autowired
    EmployeeRepository repository;

    @GetMapping("/din")
    public String getDin(){
        return "Pontep THaweesup";
    }
    @GetMapping("/employee")
    public Collection<Employee> getAllReceipt(){
        return repository.findAll().stream().collect(Collectors.toList());
    }
    // @PostMapping("/employee")
    // public Employee addEmployee(Employee newEmp, @RequestBody Employee emp){
    //     newEmp.setName(emp.getName());
    //     return repository.save(newEmp);
    // }
}