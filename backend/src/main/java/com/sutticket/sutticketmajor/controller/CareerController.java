package com.sutticket.sutticketmajor.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import java.util.Collection;
import java.util.stream.Collectors;

import com.sutticket.sutticketmajor.entity.Career;
import com.sutticket.sutticketmajor.repository.CareerRepository;

import org.springframework.web.bind.annotation.CrossOrigin;

@CrossOrigin(origins = "http://localhost:8080")
@RestController
@RequestMapping("/api")
public class CareerController {

    @Autowired
    CareerRepository careerRepository;

    @GetMapping("/careers")
    public Collection<Career> getAllCareers() {
        return careerRepository.findAll().stream().collect(Collectors.toList());
    }

}