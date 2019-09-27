package com.sutticket.sutticketmajor.controller;

import java.util.Collection;
import java.util.stream.Collectors;

import com.sutticket.sutticketmajor.entity.Test;
import com.sutticket.sutticketmajor.repository.TestRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@CrossOrigin(origins = "http://localhost:8080")
@RequestMapping("/api") 
public class TestController{

    @Autowired
    TestRepository repository;
    
    @GetMapping("/din")
    public String getDin(){
        return "Pontep Thaweesup";
    }

    @GetMapping("/tests")
    public Collection<Test> getAllShowSchedule(){
        return repository.findAll().stream().collect(Collectors.toList());
    }

    @PostMapping("/test")
    public Test postTest(Test newTest, @RequestBody Test test){
        newTest.setTest(test.getTest());
        
        return repository.save(newTest);
    }
}