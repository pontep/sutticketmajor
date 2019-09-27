package com.okta.springbootvue.controller;

import com.okta.springbootvue.entity.Employee;
import com.okta.springbootvue.repository.EmployeeRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;



import java.util.Collection;
import java.util.stream.Collectors;
import org.springframework.web.bind.annotation.CrossOrigin;
@RestController
@CrossOrigin(origins = "http://localhost:8080")
@RequestMapping("/api")
public class EmployeeController {

    @Autowired
    EmployeeRepository employeeRepository;

    
    

    @GetMapping("/Employees")
    public Collection<Employee> getAllEmployees() {
        return employeeRepository.findAll().stream().collect(Collectors.toList());
    }



}
