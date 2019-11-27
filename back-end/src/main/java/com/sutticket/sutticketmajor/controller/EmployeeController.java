package com.sutticket.sutticketmajor.controller;

import java.util.Collection;
import java.util.stream.Collectors;

import com.sutticket.sutticketmajor.entity.Employee;
import com.sutticket.sutticketmajor.repository.EmployeeRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RequestMapping("/api")
@CrossOrigin(origins = "http://localhost:8080")
@RestController
public class EmployeeController{
    @Autowired
    EmployeeRepository repository;

    @GetMapping("/employee")
    public Collection<Employee> getAllReceipt(){
        return repository.findAll().stream().collect(Collectors.toList());
    }
    @GetMapping("/employee/{username}/{password}")
    public Employee employeeLogin(@PathVariable String username, @PathVariable String password){
        return repository.findByUsernameAndPassword(username, password);
    }
    @GetMapping("/employee/{id}")
    public Employee employeeId(@PathVariable long id){
        return repository.findById(id);
    }
    // @PostMapping("/employee")
    // public Employee addEmployee(Employee newEmp, @RequestBody Employee emp){
    //     newEmp.setName(emp.getName());
    //     return repository.save(newEmp);
    // }
}