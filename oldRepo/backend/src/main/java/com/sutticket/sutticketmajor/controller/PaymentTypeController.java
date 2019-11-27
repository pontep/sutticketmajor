package com.sutticket.sutticketmajor.controller;

import java.util.Collection;
import java.util.stream.Collectors;

import com.sutticket.sutticketmajor.entity.PaymentType;
import com.sutticket.sutticketmajor.repository.PaymentTypeRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RequestMapping("/api")
@CrossOrigin(origins = "http://localhost:8080")
@RestController
public class PaymentTypeController{
    @Autowired
    PaymentTypeRepository repository;
    
   
    @GetMapping("/payments")
    public Collection<PaymentType> getAllPayments(){
        return repository.findAll().stream().collect(Collectors.toList());
    }
}